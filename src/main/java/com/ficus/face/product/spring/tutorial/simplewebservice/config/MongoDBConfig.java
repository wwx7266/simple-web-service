package com.ficus.face.product.spring.tutorial.simplewebservice.config;

import com.ficus.face.product.spring.tutorial.simplewebservice.DAO.MarkRepository;
import com.ficus.face.product.spring.tutorial.simplewebservice.DAO.StudentRepository;
import com.ficus.face.product.spring.tutorial.simplewebservice.DAO.SubjectRepository;
import com.ficus.face.product.spring.tutorial.simplewebservice.models.Mark;
import com.ficus.face.product.spring.tutorial.simplewebservice.models.Student;
import com.ficus.face.product.spring.tutorial.simplewebservice.models.Subject;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@EnableMongoRepositories(basePackageClasses = StudentRepository.class)
@Configuration
public class MongoDBConfig {
    @Bean
    CommandLineRunner commandLineRunner(StudentRepository studentRepository,
                                        SubjectRepository subjectRepository,
                                        MarkRepository markRepository) {
        return strings -> {
            studentRepository.deleteAll();
            subjectRepository.deleteAll();
            markRepository.deleteAll();


            studentRepository.save(new Student("Alice"));
            studentRepository.save(new Student("Bob"));

            subjectRepository.save(new Subject("math"));
            subjectRepository.save(new Subject("comp"));

            markRepository.save(new Mark("Alice", "math", 98));
            markRepository.save(new Mark("Alice", "comp", 91));
        };
    }
}
