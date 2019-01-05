package com.ficus.face.product.spring.tutorial.simplewebservice.DAO;



import java.util.List;

import com.ficus.face.product.spring.tutorial.simplewebservice.models.Subject;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SubjectRepository extends MongoRepository<Subject, String> {

     Subject findByName(String firstName);
     Subject findById(long id);

}