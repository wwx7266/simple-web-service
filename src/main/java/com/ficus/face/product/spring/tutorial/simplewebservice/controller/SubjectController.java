package com.ficus.face.product.spring.tutorial.simplewebservice.controller;

import java.util.List;


import com.ficus.face.product.spring.tutorial.simplewebservice.DAO.SubjectRepository;
import com.ficus.face.product.spring.tutorial.simplewebservice.models.Subject;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;


@Api(tags = {"学科管理接口"}, description = "提供学科的查询操作")

@RestController
@RequestMapping("/subjects")
public class SubjectController {

    private SubjectRepository subjectRepository;

    public SubjectController(SubjectRepository subjectRepository) {
        this.subjectRepository = subjectRepository;
    }

    @ApiOperation(value = "获取学科列表", notes = "获取所有学科")
    @GetMapping("/")
    public List<Subject> getAll() {
        return subjectRepository.findAll();
    }

    @ApiOperation(value = "获取学科列表", notes = "根据学科id获取学科")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Subject getSubjectById(@PathVariable("id") long id) {
        return subjectRepository.findById(id);
    }


    @ApiOperation(value = "获取学科列表", notes = "根据学科名称获取学科")
    @RequestMapping(method = RequestMethod.GET)
    public Subject getSubjectByName(@RequestParam(value = "name") String name) {
        return subjectRepository.findByName(name);
    }

    @ApiOperation(value = "新建学科", notes = "根据上传信息创建学科")
    @RequestMapping(value = "/add", method = RequestMethod.PUT)
    public void addStudent(@RequestParam(value = "name") String name){
        subjectRepository.save(new Subject(name));
    }

}