package com.ficus.face.product.spring.tutorial.simplewebservice.controller;

import java.util.List;

import com.ficus.face.product.spring.tutorial.simplewebservice.DAO.StudentRepository;
import com.ficus.face.product.spring.tutorial.simplewebservice.models.Student;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

@Api(tags = {"学生管理接口"}, description = "提供学生的查询操作以及学生成绩的查询操作")

@RestController
@RequestMapping("/students")
public class StudentController {

    private StudentRepository studentRepository;

    public StudentController(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @ApiOperation(value = "获取学生列表", notes = "获取全部学生")
    @GetMapping("/")
    public List<Student> getAll() {
        return studentRepository.findAll();
    }

    @ApiOperation(value = "学生查询", notes = "根据id查找学生信息")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Student getStudentById(@PathVariable("id") long id) {
        return studentRepository.findById(id);
    }

    @ApiOperation(value = "学生查询", notes = "根据学生姓名查找学生信息")
    @RequestMapping(method = RequestMethod.GET)
    public Student getStudentByName(@RequestParam(value = "name") String name) {
        return studentRepository.findByName(name);
    }


    @ApiOperation(value = "创建学生信息", notes = "根据上传信息创建学生信息")
    @RequestMapping(value = "/add", method = RequestMethod.PUT)
    public void addStudent(@RequestParam(value = "name") String name){
        studentRepository.save(new Student(name));
    }

}