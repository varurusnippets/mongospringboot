package com.test.firstspringboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.firstspringboot.model.Student;
import com.test.firstspringboot.model.StudentRepository;

@Service
public class FirstService {

	@Autowired
	StudentRepository repo;

	public List<Student> getStudent() {
		List<Student> stList = (List<Student>) repo.findAll();

		return stList;
	}

	public String insertStudent(Student student) {

		Student st = repo.save(student);

		return st.getId();
	}

}
