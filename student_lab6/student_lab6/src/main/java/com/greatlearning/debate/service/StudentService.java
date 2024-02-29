package com.greatlearning.debate.service;

import java.util.List;

import com.greatlearning.debate.model.Student;

public interface StudentService {
	Student saveStudent(Student student);

	List<Student> getAllStudents();

	Student getStudentbyId(Long id);

	Student updateStudent(Student student, Long id);

	void deleteStudent(Long id);

}
