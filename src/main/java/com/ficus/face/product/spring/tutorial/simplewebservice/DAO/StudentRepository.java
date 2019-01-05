package com.ficus.face.product.spring.tutorial.simplewebservice.DAO;

import java.util.List;

import com.ficus.face.product.spring.tutorial.simplewebservice.models.Student;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface StudentRepository extends MongoRepository<Student, String> {

     Student findByName(String name);
     Student findById(long id);

}