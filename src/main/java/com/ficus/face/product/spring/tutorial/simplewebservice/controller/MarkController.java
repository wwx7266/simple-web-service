package com.ficus.face.product.spring.tutorial.simplewebservice.controller;

import java.util.List;


import com.ficus.face.product.spring.tutorial.simplewebservice.DAO.MarkRepository;
import com.ficus.face.product.spring.tutorial.simplewebservice.DAO.StudentRepository;
import com.ficus.face.product.spring.tutorial.simplewebservice.models.Mark;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Api(tags = {"成绩管理接口"}, description = "提供学生成绩的查询操作以及分数的批量上传操作")
@RestController
@RequestMapping("/marks")
public class MarkController {

    private StudentRepository studentRepository;
    private MarkRepository markRepository;


    public MarkController(StudentRepository studentRepository, MarkRepository markRepository) {
        this.markRepository = markRepository;
        this.studentRepository = studentRepository;
    }

    @ApiOperation(value = "获取成绩列表", notes = "获取所有成绩")
    @GetMapping("/")
    public List<Mark> getAll() {
        return markRepository.findAll();
    }


    @ApiOperation(value = "获取成绩列表", notes = "根据学生姓名获取成绩信息")
    @GetMapping("/mark")
    public List<Mark> getMarkByName(@RequestParam(value = "name") String name) {
        return markRepository.findByStudent(name);
    }

    @ApiOperation(value = "创建成绩", notes = "根据上传信息登记成绩")
    @RequestMapping(value = "/add", method = RequestMethod.PUT)
    public void addMark(@RequestParam(value = "student") String student,
                           @RequestParam(value = "subject") String subject,
                           @RequestParam(value = "mark") double mark){
        markRepository.save(new Mark(student, subject, mark));
    }

    @ApiOperation(value = "创建成绩", notes = "批量上传成绩")
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public void createPet(@Valid @RequestBody List<Mark> marks) {
        for(Mark m : marks) {
            markRepository.save(m);
        }
    }

}