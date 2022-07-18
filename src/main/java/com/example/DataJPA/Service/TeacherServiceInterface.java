package com.example.DataJPA.Service;

import java.util.List;

import com.example.DataJPA.Entity.Teacher;

public interface TeacherServiceInterface {
    Teacher addTeacher(Teacher teach);
    List<Teacher> getAllTeacher();
    Teacher updateTeacher(Teacher teach);
    String removeTeacher(Integer id);
    Teacher updateTeacherTest(Teacher teach);
    List<Teacher> getByFirstName(String firstName);
    Teacher getTeacher(String firstName, String lastName, String department);
    List<Teacher> matchTeacherByFirstName(String firstName);
}
