package com.imooc.guli.teacher.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.imooc.guli.teacher.entity.EduTeacher;
import com.baomidou.mybatisplus.extension.service.IService;
import com.imooc.guli.teacher.query.TeacherQuery;

/**
 * <p>
 * 讲师 服务类
 * </p>
 *
 * @author testjava
 * @since 2020-03-13
 */
public interface EduTeacherService extends IService<EduTeacher> {
    /**
     *  根据多个条件查询讲师列表
     * @param pageParam
     * @param teacherQuery
     */
    void pageQuery(Page<EduTeacher> pageParam, TeacherQuery teacherQuery);


}
