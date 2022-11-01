package com.main.service.imp;

import java.util.List;

import org.springframework.stereotype.Service;

import com.main.exception.ResourceNotFoundException;
import com.main.model.Student;
import com.main.repository.StudentRepository;
import com.main.service.StudentService;

@Service
public class StudentServiceImp  implements StudentService {
	
	private StudentRepository studentRepository;

	
	public StudentServiceImp(StudentRepository studentRepository) {
		super();
		this.studentRepository = studentRepository;
	}

	@Override
	public Student save(Student student) {
		return studentRepository.save(student);
	}

	@Override
	public List<Student> getAllStudent() {
		// TODO Auto-generated method stub
		return studentRepository.findAll();
	}

	@Override
	public Student getSingleStudent(long id) {
		// TODO Auto-generated method stub
		return studentRepository.findById(id).orElseThrow( ()-> 
			new ResourceNotFoundException("Student" , "id", id));
	}

	@Override
	public Student updateStudent(Student student, long id) {
		Student existStudent = studentRepository.findById(id).orElseThrow( () -> 
		new ResourceNotFoundException("Student", "id" , id));
		
		existStudent.setFirstName(student.getFirstName());
		existStudent.setLastName(student.getLastName());
		existStudent.setAddress(student.getAddress());
		studentRepository.save(existStudent);
		return existStudent;
	}

	

	@Override
	public void deleteStudent(long id) {
		studentRepository.findById(id).orElseThrow( ()->
		new ResourceNotFoundException("Student", "id", id));
		studentRepository.deleteById(id);;
	}

}
