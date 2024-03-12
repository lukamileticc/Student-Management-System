package net.javaprojects.sms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import net.javaprojects.sms.entity.Student;
import net.javaprojects.sms.repository.StudentRepository;

@SpringBootApplication
public class StudentManagementSystem2Application implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(StudentManagementSystem2Application.class, args);
	}
	
	@Autowired
	private StudentRepository student_repository;
	
	@Override
	public void run(String... args) throws Exception {
	
		Student student1 = new Student("Luka","Miletic","lukamilecki@gmail.com");
		Student student2 = new Student("Milos","Milovanovic","miki9987@gmail.com");
		Student student3 = new Student("Teodora","Bekric","tedii@gmail.com");

//		student_repository.save(student1);
//		student_repository.save(student2);
//		student_repository.save(student3);
	}

}
