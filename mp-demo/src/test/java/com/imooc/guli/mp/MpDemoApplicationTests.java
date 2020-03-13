package com.imooc.guli.mp;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.imooc.guli.mp.domain.User;
import com.imooc.guli.mp.mapper.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class MpDemoApplicationTests {
    @Autowired
    private UserMapper userMapper;

    @Test
    public void selectAll() {
        List<User> userList = userMapper.selectList(null);
        userList.forEach(System.out::println);
    }
    @Test
    public void testInsert() {
        User user=new User();
        user.setName("小猫");
        user.setAge(18);
        user.setEmail("123@qq.com");
       userMapper.insert(user);
    }
    @Test
    public void update() {
        User user = new User();
        user.setId(8L);
        user.setName("小三123");
        userMapper.updateById(user);
    }
    @Test
    public void testLock()
    {
        //User user = userMapper.selectById(9L);
        //user.setName("小鬼哈哈");
        //user.setVersion(user.getVersion()-1);
        userMapper.deleteById(10L);
    }
    @Test
    public void testSelect()
    {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("age",18);
        List<User> users = userMapper.selectList(wrapper);
        //List<User> users = userMapper.selectBatchIds(Arrays.asList(1L, 2L, 3L));
        users.forEach(System.err::println);
    }
    @Test
    public void testSelectPage()
    {
        Page<User> userPage = new Page<>(1,3);
        userMapper.selectPage(userPage,null);
        System.out.println(userPage.hasNext());
        System.out.println(userPage.hasPrevious());
        System.out.println(userPage.getCurrent());
        System.out.println(userPage.getRecords());
        System.out.println(userPage.getSize());
        System.out.println("总记录数"+userPage.getTotal());
        System.out.println(userPage.getPages());
    }

}
