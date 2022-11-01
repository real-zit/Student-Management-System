package com.main.service;

import java.util.List;

import com.main.model.Student;

public interface StudentService {
Student save(Student student);
List<Student> getAllStudent();
Student getSingleStudent(long id);
Student updateStudent(Student student, long id);
void deleteStudent(long id);

}
