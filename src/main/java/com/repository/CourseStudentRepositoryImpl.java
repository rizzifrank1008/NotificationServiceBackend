package com.repository;

import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.entity.Course;
import com.entity.Student;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Transactional
@Repository
public class NotificationRepositoryImpl implements CourseStudentRepository {

	@PersistenceContext
	private EntityManager em;

	@Override
	public void insertCourse(Course course) {
		em.persist(course);

	}

	@Override
	public void insertStudent(Student student) {
		em.persist(student);

	}

	@Override
	public void insertStudentByListCourse(Student student, Set<Course> courseslist) {
		Set<Student> studentsSet = new HashSet<>();
		studentsSet.add(student);

		courseslist.forEach(r -> r.setStudents(studentsSet));
		courseslist.forEach(r -> em.persist(r));

		student.setLikedCourses(courseslist);

		em.persist(student);

	}

}
