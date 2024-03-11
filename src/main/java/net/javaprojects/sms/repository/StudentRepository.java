package net.javaprojects.sms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.javaprojects.sms.entity.Student;

public interface StudentRepository extends JpaRepository<Student,Long>{
	
	

}
