package com.test.firstspringboot.model;

import org.springframework.data.mongodb.repository.MongoRepository;

//public interface StudentRepository extends PagingAndSortingRepository<Student, Integer> {
//
//}

public interface StudentRepository extends MongoRepository<Student,Integer>{
	
}
