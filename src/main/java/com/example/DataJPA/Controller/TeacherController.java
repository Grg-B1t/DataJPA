package com.example.DataJPA.Controller;

import java.util.List;

import javax.net.ssl.HttpsURLConnection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.DataJPA.Entity.Teacher;
import com.example.DataJPA.Service.TeacherService;

@RestController
@RequestMapping("/teacherAPI")
public class TeacherController {

    @Autowired
    TeacherService ts;

    @PostMapping("/addTeacher")
    public ResponseEntity<Teacher> addTeacher(@Validated @RequestBody Teacher teach){
        try {
            return new ResponseEntity<>(ts.addTeacher(teach), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/getAllTeachers")
    public ResponseEntity<List<Teacher>> getAllTeacher(){
        try {
            return new ResponseEntity<>(ts.getAllTeacher(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/updateTeacher")
    public ResponseEntity<Teacher> updateTeacher(@RequestBody Teacher teach){
        try {
            return new ResponseEntity<>(ts.updateTeacher(teach), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }
    }

    @DeleteMapping("/removeTeacher/{id}")
    public ResponseEntity<String> removeTeacher(@PathVariable Integer id){
        try {
            return new ResponseEntity<>(ts.removeTeacher(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/updateTeacherTest")
    public ResponseEntity<Teacher> updateTeacherTest(@RequestBody Teacher teach){
        try {
            return new ResponseEntity<>(ts.updateTeacherTest(teach), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }
    }

    @GetMapping("/getTeacherByFirstName")
    public ResponseEntity<List<Teacher>> searchByName(@RequestParam String firstName){
        try {
            return new ResponseEntity<>(ts.getByFirstName(firstName), HttpStatus.FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/getTeacher/{firstName}/{lastName}/{department}")
    public ResponseEntity<Teacher> getTeacher(@PathVariable String firstName, @PathVariable String lastName, @PathVariable String department){
        try {
            return new ResponseEntity<>(ts.getTeacher(firstName, lastName, department), HttpStatus.FOUND);
        } catch (Exception e) {
            System.out.println(e);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("getTeacherByMatchFristName/{firstName}")
    public ResponseEntity<List<Teacher>> matchTeacherByFirstName(@PathVariable String firstName){
        try {
            return new ResponseEntity<>(ts.matchTeacherByFirstName(firstName), HttpStatus.FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
