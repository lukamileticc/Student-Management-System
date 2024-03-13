package net.javaprojects.sms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.ui.Model;

import net.javaprojects.sms.entity.Student;
import net.javaprojects.sms.service.StudentService;

//ova klasa ce da hendluje requestove
//implementiramo moguce funkcionalnosti(implementing students features)

@Controller
public class StudentController {
	
	private StudentService student_service;
	
	public StudentController(StudentService student_service) {
		super();
		this.student_service = student_service;
	}
	
	//hendler metod to handle list students and return model and view
	//Thymeleaf je Java template -engine(sablon mehanizam) za kreiranje dinamickih web stranica
	//omogucava nekoliko atributa za vezivanje podataka iz modela sa html pogledom
	@GetMapping("/students")
	public String listStudents(Model model) {
		model.addAttribute("students", student_service.getAllStudents());
		return "students";
	}
	
	@GetMapping("/students/new")
	public String createStudentFrom(Model model) {
		
		//create new empty student to hold student form data
		Student student = new Student();
		model.addAttribute("student", student);
		
		return "create_student";
	}
	
	@PostMapping("/students")
	public String saveStudent(@ModelAttribute("student") Student student) {
		
		//debug info
		System.out.println(student.getFirst_name());
		
		//save student to database
		student_service.saveStudent(student);
		return "redirect:/students";
	}
	
	@GetMapping("/students/edit/{id}")
	public String editStudentForm(@PathVariable Long id, Model model) {
		model.addAttribute("student", student_service.getStudentById(id));
		return "update_student";
	}
	
	@PostMapping("/students/{id}")
	public String updateStudent(@PathVariable Long id,
			@ModelAttribute("student") Student student) {
		
		//get student from database by id;
		Student existing_student = student_service.getStudentById(id);
		existing_student.setId(id);
		existing_student.setFirst_name(student.getFirst_name());
		existing_student.setLast_name(student.getLast_name());
		existing_student.setEmail(student.getEmail());
		//update student to database
		student_service.updateStudent(existing_student);
		return "redirect:/students";
	}

	
}