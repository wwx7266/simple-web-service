package com.ficus.face.product.spring.tutorial.simplewebservice.models;

public class Mark {
    public String student;
    public String subject;
    public double mark;

    public Mark(String student, String subject, double mark) {
        this.student = student;
        this.subject = subject;
        this.mark = mark;
    }

    public String getStudent() {
        return student;
    }

    public void setStudent(String student) {
        this.student = student;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public double getMark() {
        return mark;
    }

    public void setMark(double mark) {
        this.mark = mark;
    }
}
