package com.imooc.guli.teacher.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement
@Configuration
@MapperScan("com.imooc.guli.teacher.mapper")
public class TeacherConfig {
}
