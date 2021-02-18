package net.amir.security.controller;

import net.amir.security.entity.Student;
import net.amir.security.scurity.ApplicationUserPermission;
import net.amir.security.scurity.ApplicationUserRole;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

import static net.amir.security.scurity.ApplicationUserPermission.COURSE_WRITE;
import static net.amir.security.scurity.ApplicationUserRole.ADMINTRAINEE;

@RestController
@RequestMapping("management/api/v1")
public class ManagementStudentController {

    private static List<Student> studentList = Arrays.asList(
            new Student(1l, "Amir Roodaki"),
            new Student(2l, "Mina Alizade"),
            new Student(3l, "Bahar Rahmati"),
            new Student(4l, "Reza Azimi")
    );

    @GetMapping()
    @PreAuthorize("hasAnyRole('ADMIN','ADMINTRAINEE')")
    public List<Student> getStudentList() {
        return studentList;
    }

    @PostMapping
    @PreAuthorize("hasAuthority('course:write')")
    public void registerStudent(@RequestBody Student student) {
        System.out.println(student);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasAuthority('course:write')")
    public void updateStudent(@PathVariable Long id, @RequestBody Student student) {
        System.out.println("update : " + id + "  " + student);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('course:write')")
    public void deleteStudent(@PathVariable Long id) {
        System.out.println("delete : " + id);
    }


}
