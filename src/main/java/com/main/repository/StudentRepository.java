package com.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.main.model.Student;

public interface StudentRepository extends JpaRepository <Student, Long>{

}
