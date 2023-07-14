package com;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.entity.Course;
import com.entity.Student;

@Configuration
public class EntityBeanConfiguration {

	@Bean(name = "courseToInsert1")
	public Course getCourseToInsert1() {
		return new Course("Java Base", "Corso su Java Base - Base level");
	}

	@Bean(name = "courseToInsert2")
	public Course getCourseToInsert2() {
		return new Course("Java Spring", "Corso su Java Spring - Advanced level");
	}

	@Bean(name = "courseToInsert3")
	public Course getCourseToInsert3() {
		return new Course("Angular", "Corso su Java Spring - Frontend");
	}

	@Bean(name = "courseToInsert4")
	public Course getCourseToInsert4() {
		return new Course("Filosofia", "Monografia su Schopenhauer");
	}

	@Bean(name = "studentToInsert1")
	public Student getstudentToInsert1() {
		return new Student("mario@gmail.com", "Mario", "Rossi", 24);
	}

	@Bean(name = "studentToInsert2")
	public Student getstudentToInsert2() {
		return new Student("giuseppe@gmail.com", "Giuseppe", "Verdi", 24);
	}

}
