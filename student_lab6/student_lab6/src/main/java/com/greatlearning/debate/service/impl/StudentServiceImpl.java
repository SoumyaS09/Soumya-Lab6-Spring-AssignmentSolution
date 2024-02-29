package com.greatlearning.debate.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.greatlearning.debate.exception.ResourceNotFoundException;
import com.greatlearning.debate.model.Student;
import com.greatlearning.debate.repository.StudentRepository;
import com.greatlearning.debate.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {

	private StudentRepository studentRepository;

	public StudentServiceImpl(StudentRepository studentRepository) {
		super();
		this.studentRepository = studentRepository;
	}

	@Override
	public Student saveStudent(Student student) {
		return studentRepository.save(student);
	}

	@Override
	public List<Student> getAllStudents() {
		return studentRepository.findAll();
	}

	@Override
	public Student getStudentbyId(Long id) {
		Optional<Student> student = studentRepository.findById(id);
		if (student.isPresent()) {
			return student.get();
		} else {
			throw new ResourceNotFoundException("Student", "Id", id);
		}
//		return null;
	}

	@Override
	public Student updateStudent(Student student, Long id) {
		// Checking is student id exists in database
		Student existingStudent = studentRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Student", "Id", id));

		existingStudent.setFullName(student.getFullName());
		existingStudent.setDepartment(student.getDepartment());
		existingStudent.setCountry(student.getCountry());

		// save existing student to database
		studentRepository.save(existingStudent);
		return existingStudent;
	}

	@Override
	public void deleteStudent(Long id) {
		// check if student exists in Database
		studentRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Student", "Id", id));
		studentRepository.deleteById(id);

	}

}
