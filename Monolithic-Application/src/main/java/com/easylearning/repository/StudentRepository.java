package com.easylearning.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.easylearning.entity.Student;



@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

	
	
}
