package com.main.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.main.service.StudentService;
import com.main.model.Student;

@RestController
@RequestMapping("/api/v1/students")
public class StudentController {

private StudentService studentService;

public StudentController(StudentService studentService) {
	super();
	this.studentService = studentService;
}

@PostMapping()
public ResponseEntity<Student> saveStudent(@RequestBody Student student){
	return new ResponseEntity<Student>(studentService.save(student), HttpStatus.CREATED);
}

@GetMapping()
public List<Student> getAllStudent(){
	return studentService.getAllStudent();
}

@GetMapping("{id}")
public ResponseEntity<Student> getStudentById(@PathVariable("id") long studentId ){
	return new ResponseEntity<Student> (studentService.getSingleStudent(studentId),  HttpStatus.OK);
}
@PutMapping("{id}")
public ResponseEntity<Student> updateStudent(@PathVariable("id") long studentId, @RequestBody Student student){
	return new ResponseEntity<Student> (studentService.updateStudent(student, studentId), HttpStatus.ACCEPTED);
}

@DeleteMapping("{id}")
public ResponseEntity<String> deleteStudent(@PathVariable long studentId){
	studentService.deleteStudent(studentId);
	return new ResponseEntity<String>("Employee Deleted Successfully! ",HttpStatus.OK);
}
}