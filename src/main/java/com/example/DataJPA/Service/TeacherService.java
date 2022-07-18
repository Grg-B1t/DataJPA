package com.example.DataJPA.Service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.DataJPA.Entity.Teacher;
import com.example.DataJPA.Repository.Repo;

@Service
public class TeacherService implements TeacherServiceInterface {
    @Autowired
    Repo rep;
    
    @Override
    public Teacher addTeacher(Teacher teach) {
        Teacher teacher = new Teacher();
        teacher.setFirstName(teach.getFirstName());
        teacher.setLastName(teach.getLastName());
        teacher.setDepartment(teach.getDepartment());
        rep.save(teacher);
        
        return teacher;
    }

    @Override
    public List<Teacher> getAllTeacher() {
        return rep.findAll();
    }

    @Override
    public Teacher updateTeacher(Teacher teach) {
        List<Teacher> teachList = rep.findAll();
        Teacher teacher = teachList.stream().filter(a -> a.getTeacherId().equals(teach.getTeacherId())).findFirst().get();
        teacher.setFirstName(teach.getFirstName());
        teacher.setLastName(teach.getLastName());
        teacher.setDepartment(teach.getDepartment());
        
        rep.save(teacher);
        return teacher;
    }

    @Override
    public String removeTeacher(Integer id) {
        rep.deleteById(id);
        return "Teacher is removed from the list";
    }

    @Override
    public Teacher updateTeacherTest(Teacher teach) {
        
        return rep.save(teach);
    }

    @Override
    public List<Teacher> getByFirstName(String firstName) {
        
        return rep.findByFirstName(firstName);
    }

    @Override
    public Teacher getTeacher(String firstName, String lastName, String department) {
        return rep.findByFirstNameAndLastNameAndDepartment(firstName, lastName, department).stream().findFirst().get();
    }

    @Override
    public List<Teacher> matchTeacherByFirstName(String firstName) {
      //  List<Teacher> teacherList = rep.findAll().stream().filter(a -> a.getFirstName().endsWith(firstName)).collect(Collectors.toList());
        return rep.findByFirstNameContaining(firstName);
    }
    
    
}
