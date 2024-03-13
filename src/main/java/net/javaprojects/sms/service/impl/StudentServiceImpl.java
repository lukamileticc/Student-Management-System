package net.javaprojects.sms.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import net.javaprojects.sms.entity.Student;
import net.javaprojects.sms.repository.StudentRepository;
import net.javaprojects.sms.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService{

	private StudentRepository student_repository;
	
	public StudentServiceImpl(StudentRepository student_repository) {
		super();
		this.student_repository = student_repository;
	}
	
	@Override
	public List<Student> getAllStudents() {
		return student_repository.findAll();
	}

	@Override
	public Student saveStudent(Student student) {
		return student_repository.save(student);
	}
	
	@Override
	public Student getStudentById(Long id) {
		return student_repository.findById(id).get();
	}

	@Override
	public Student updateStudent(Student student) {
		
		return student_repository.save(student);
	}

	@Override
	public void deleteStudent(Student student) {
		student_repository.delete(student);
	}
	
}