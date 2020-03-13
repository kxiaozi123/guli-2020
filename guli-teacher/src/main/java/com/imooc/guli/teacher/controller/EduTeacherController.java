package com.imooc.guli.teacher.controller;


import com.imooc.guli.teacher.entity.EduTeacher;
import com.imooc.guli.teacher.service.EduTeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 讲师 前端控制器
 * </p>
 *
 * @author testjava
 * @since 2020-03-13
 */
@RestController
@RequestMapping("/teacher")
public class EduTeacherController {
    @Autowired
    private EduTeacherService teacherService;
    @GetMapping("list")
    public List<EduTeacher> list()
    {
        return teacherService.list(null);
    }

}

