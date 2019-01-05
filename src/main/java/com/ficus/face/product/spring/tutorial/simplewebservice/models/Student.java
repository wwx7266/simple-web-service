package com.ficus.face.product.spring.tutorial.simplewebservice.models;


import org.springframework.data.annotation.Id;

import java.util.concurrent.atomic.AtomicLong;

public class Student {


    private static  AtomicLong counter = new AtomicLong();
    public  long id;
    public  String name;



    public Student(String name) {
        this.id = counter.incrementAndGet();
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public long getId() {
        return this.id;
    }


//    public static Builder Studentbuilder(){
//        return new Builder();
//    }
//
//    public static class Builder {
//        private static final AtomicLong counter = new AtomicLong();
//        private long id;
//        private String firstName;
//        private String lastName;
//
//        private Builder() {
//            this.id = counter.incrementAndGet();
//        }
//
//        public Builder firstName(String firstName) {
//            this.firstName = firstName;
//            return this;
//        }
//
//        public Builder lastName(String lastName) {
//            this.lastName = lastName;
//            return this;
//        }
//
//        public Student build(){
//            return new Student(this.id, this.firstName, this.lastName);
//        }
//    }
}