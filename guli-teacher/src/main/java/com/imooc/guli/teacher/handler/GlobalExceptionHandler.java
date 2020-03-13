package com.imooc.guli.teacher.handler;

import com.baomidou.mybatisplus.extension.api.R;
import com.imooc.guli.common.exception.EduException;
import com.imooc.guli.common.result.Result;
import com.imooc.guli.common.result.ResultCode;
import com.imooc.guli.common.utils.ExceptionUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.BadSqlGrammarException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Result error(Exception e) {
        e.printStackTrace();
        return Result.error().message("出错了");
    }

    @ExceptionHandler(BadSqlGrammarException.class)
    @ResponseBody
    public Result error(BadSqlGrammarException e) {
        e.printStackTrace();
        return Result.error().code(ResultCode.SQL_ERROR).message("SQL语法错误");

    }
    @ExceptionHandler(EduException.class)
    @ResponseBody
    public Result error(EduException e){
        e.printStackTrace();
        //log.error(e.getMessage());
        //输出到日志文件中
        log.error(ExceptionUtil.getMessage(e));
        return Result.error().code(e.getCode()).message(e.getMsg());
    }

}
