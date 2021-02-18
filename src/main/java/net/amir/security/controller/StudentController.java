package net.amir.security.controller;

import net.amir.security.entity.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class StudentController {

    private static List<Student> studentList = Arrays.asList(
            new Student(1l,"Amir Roodaki"),
            new Student(2l,"Mina Alizade"),
            new Student(3l,"Bahar Rahmati"),
            new Student(4l,"Reza Azimi")
    );


    @GetMapping("/{studentId}")
    public Student getStudebtById(@PathVariable Long studentId) {
        return studentList.stream()
                .filter(student -> student.getStudentId().equals(studentId))
                .findFirst()
                .orElseThrow( () -> new IllegalStateException("student " + studentId + " does not exist"));
    }

}
