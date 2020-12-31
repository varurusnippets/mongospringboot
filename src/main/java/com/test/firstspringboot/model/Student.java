package com.test.firstspringboot.model;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

//@Entity
@Document
public class Student {

	@Id
	private String id;

//	@Id
//	@GeneratedValue
//	private long id;

	private String name;

	private int rollno;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getRollno() {
		return rollno;
	}

	public void setRollno(int rollno) {
		this.rollno = rollno;
	}

	public Student() {

	}

	public Student(String id, String string, int rollno) {
		super();
		this.id = id;
		this.name = string;
		this.rollno = rollno;
	}

}
