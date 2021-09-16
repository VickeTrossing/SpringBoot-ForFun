package com.example.forfunnies.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.sql.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }


    public List<Student> getStudents() {
        return studentRepository.findAll();
    }




    public void addNewStudent(Student student) {

        Optional<Student> studentOptional = studentRepository.findByEmail(student.getEmail());

        if(studentOptional.isPresent()){
            throw new IllegalStateException("Email taken");
        }

        studentRepository.save(student);
    }


    public void deleteStudent(Long id){

       boolean exists = studentRepository.existsById(id);

       if(!exists){
           throw new IllegalStateException("Student with id: " + id + " does not exsist");
       }

       studentRepository.deleteById(id);
    }


    @Transactional
    public void updateStudent(Long id, String name, String email){

        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException("Student with id " + id + " does not exist"));

        if(name != null && !Objects.equals(student.getName(), name)){
            student.setName(name);
        }

        if(email != null && email.length() > 0 && !Objects.equals(student.getEmail(), email)){
            Optional<Student> studentOptional = studentRepository.findByEmail(email);

            if(studentOptional.isPresent()){
                throw new IllegalStateException("This email is already in use");
            }
            student.setEmail(email);
        }
    }
}
