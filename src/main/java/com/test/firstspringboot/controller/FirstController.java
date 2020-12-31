package com.test.firstspringboot.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.test.firstspringboot.model.Student;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@ControllerAdvice
@Api(value = " This controller is focusing on Student Operations", description = "")
public class FirstController {

	@Autowired
	FirstService firstService;

	@Autowired
	KafkaTemplate<String, String> kafkaTemplate;

	@ApiOperation(value = "This api is for getting the students")
	@GetMapping(path = "/first", produces = "application/json")
//	@HystrixCommand(fallbackMethod = "getStudentFallBack")
	public List<Student> getStudent() throws Exception {
//		throw new Exception("I am not ready");
		List<Student> stList = firstService.getStudent();

		return stList;
	}

	@PostMapping(path = "/first", produces = "application/json")
	public ResponseEntity<String> insertStudent(@RequestBody Student student) throws Exception {
		String id = firstService.insertStudent(student);
//		String studentjson = new ObjectMapper().writeValueAsString(student);
//		kafkaTemplate.send("test", studentjson);
		return new ResponseEntity<String>("new student added " + id, HttpStatus.CREATED);
	}

	@ExceptionHandler({ Exception.class })
	public ResponseEntity<String> handleException(Exception ex) {

		System.out.println(ex.getMessage());

		return new ResponseEntity<String>("{\"errocode\" : \"ABC123\", \"message\" : \"got exception \"} ",
				HttpStatus.INTERNAL_SERVER_ERROR);
	}

	public List<Student> getStudentFallBack() throws Exception {
		List<Student> stList = new ArrayList<>();
		return stList;
	}
}
