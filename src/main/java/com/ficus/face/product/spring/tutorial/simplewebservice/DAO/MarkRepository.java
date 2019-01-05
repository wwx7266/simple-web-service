package com.ficus.face.product.spring.tutorial.simplewebservice.DAO;

import java.util.List;

import com.ficus.face.product.spring.tutorial.simplewebservice.models.Mark;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MarkRepository extends MongoRepository<Mark, String> {

    List<Mark> findByStudent(String student);
    List<Mark> findBySubject(String subject);

}