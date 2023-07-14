package com;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.entity.Course;
import com.entity.Student;
import com.service.CourseStudentService;

import jakarta.annotation.Resource;

@SpringBootApplication
public class Application implements CommandLineRunner {

	@Autowired
	CourseStudentService courseStudentService;

	@Resource(name = "courseToInsert1")
	private Course courseToInsert1;

	@Resource(name = "courseToInsert2")
	private Course courseToInsert2;

	@Resource(name = "courseToInsert3")
	private Course courseToInsert3;

	@Resource(name = "courseToInsert4")
	private Course courseToInsert4;

	@Resource(name = "studentToInsert1")
	private Student studentToInsert1;

	@Resource(name = "studentToInsert2")
	private Student studentToInsert2;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// Inserisco 3 corsi
		courseStudentService.insertCourse(courseToInsert1); // Java Base
		courseStudentService.insertCourse(courseToInsert2); // Java Spring
		courseStudentService.insertCourse(courseToInsert3); // Angular - Course da aggiornare: cerco l'id tramite title

		// Inserisco 2 studenti
		courseStudentService.insertStudent(studentToInsert1); // mario
		courseStudentService.insertStudent(studentToInsert2); // giuseppe

	}

}
