package com.example.DataJPA.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.DataJPA.Entity.Teacher;

@Repository
public interface Repo extends JpaRepository<Teacher, Integer>{
    List<Teacher> findByFirstName(String firstName);
    List<Teacher> findByFirstNameAndLastNameAndDepartment(String firstName, String lastName, String department);
    List<Teacher> findByFirstNameContaining(String firstName);
}
