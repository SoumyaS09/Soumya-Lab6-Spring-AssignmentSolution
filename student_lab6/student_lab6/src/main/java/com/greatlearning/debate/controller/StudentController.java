package com.greatlearning.debate.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.greatlearning.debate.model.Student;
import com.greatlearning.debate.service.StudentService;

@RestController
@RequestMapping("/api/students")
public class StudentController {

	private StudentService studentService;

	public StudentController(StudentService studentService) {
		super();
		this.studentService = studentService;
	}

	// build create student REST API
	@PostMapping
	public ResponseEntity<Student> sveStudent(@RequestBody Student student) {
		return new ResponseEntity<Student>(studentService.saveStudent(student), HttpStatus.CREATED);
	}

	// build get student by id REST API
	@GetMapping
	public List<Student> getAllStudents() {
		return studentService.getAllStudents();

	}
	// build get student by REST API

	@GetMapping("{id}")
	public ResponseEntity<Student> getStudentById(@PathVariable("id") Long studentId) {
		return new ResponseEntity<Student>(studentService.getStudentbyId(studentId), HttpStatus.OK);
	}

	// build update student by REST API
	@PutMapping("{id}")
	public ResponseEntity<Student> updateStudent(@PathVariable("id") Long id, @RequestBody Student student) {
		return new ResponseEntity<Student>(studentService.updateStudent(student, id), HttpStatus.OK);

	}

	// build Delete Student REST API
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteStudent(@PathVariable("id") Long id) {
		studentService.deleteStudent(id);
		return new ResponseEntity<String>("Student deleted successfully!", HttpStatus.OK);
	}
}