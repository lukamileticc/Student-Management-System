package net.javaprojects.sms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;

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
	@GetMapping("/students")
	public String listStudents(Model model) {
		model.addAttribute("students", student_service.getAllStudents());
		return "students";
	}
	
}