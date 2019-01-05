package com.ficus.face.product.spring.tutorial.simplewebservice.models;

import java.util.concurrent.atomic.AtomicLong;

public class Subject {

    private static AtomicLong counter = new AtomicLong();
    public long id;
    public String name;

    public Subject(String name) {
        this.id = counter.incrementAndGet();
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
