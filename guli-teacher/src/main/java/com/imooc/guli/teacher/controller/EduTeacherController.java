package com.imooc.guli.teacher.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.imooc.guli.common.exception.EduException;
import com.imooc.guli.common.result.Result;
import com.imooc.guli.teacher.entity.EduTeacher;
import com.imooc.guli.teacher.query.TeacherQuery;
import com.imooc.guli.teacher.service.EduTeacherService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
@Api("讲师管理")
public class EduTeacherController {
    @Autowired
    private EduTeacherService teacherService;

    @GetMapping("list")
    @ApiOperation(value = "所有讲师列表")
    public Result list() {
       /* try {
            int a = 1/0;
        } catch (Exception e) {
            throw new EduException(20001,"你不知道0不能做除数啊？憨熊！");
        }*/
        List<EduTeacher> list = teacherService.list(null);
        return Result.ok().data("list", list);
    }

    @ApiOperation(value = "根据ID删除讲师")
    @DeleteMapping("{id}")
    public Result removeById(
            @ApiParam(name = "id", value = "讲师ID", required = true)
            @PathVariable String id)
    {
        boolean b = teacherService.removeById(id);
        if(b){
            return Result.ok();
        }
        return Result.error();

    }
    @ApiOperation(value = "分页讲师列表")
    @GetMapping("{page}/{limit}")
    public Result pageList(
            @ApiParam(name = "page", value = "当前页码", required = true,defaultValue = "1")
            @PathVariable Long page,

            @ApiParam(name = "limit", value = "每页记录数", required = true,defaultValue = "4")
            @PathVariable Long limit,
            @ApiParam(name = "teacherQuery", value = "查询对象", required = false)
                    TeacherQuery teacherQuery)
    {

        Page<EduTeacher> pageParam = new Page<>(page, limit);

        teacherService.pageQuery(pageParam, teacherQuery);
        List<EduTeacher> records = pageParam.getRecords();
        long total = pageParam.getTotal();

        return  Result.ok().data("total", total).data("size",records.size()).data("rows", records);
    }
    @ApiOperation(value = "新增讲师")
    @PostMapping
    public Result save(
            @ApiParam(name = "teacher", value = "讲师对象", required = true)
            @RequestBody EduTeacher teacher)
    {

        teacherService.save(teacher);
        return Result.ok();
    }
    @ApiOperation(value = "根据ID查询讲师")
    @GetMapping("{id}")
    public Result getById(
            @ApiParam(name = "id", value = "讲师ID", required = true)
            @PathVariable String id)
    {

        EduTeacher teacher = teacherService.getById(id);
        return Result.ok().data("item", teacher);
    }
    @ApiOperation(value = "根据ID修改讲师")
    @PutMapping("{id}")
    public Result updateById(
            @ApiParam(name = "id", value = "讲师ID", required = true)
            @PathVariable String id,

            @ApiParam(name = "teacher", value = "讲师对象", required = true)
            @RequestBody EduTeacher teacher){

        teacher.setId(id);
        teacherService.updateById(teacher);
        return Result.ok();
    }




}

