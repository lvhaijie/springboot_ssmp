package com.lhj.service;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lhj.pojo.UserInfo;
import org.apache.logging.log4j.util.Strings;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class LoginServiceTest {
    @Autowired
    private LoginService loginService;

//    /**
//     * 查询单个
//     */
    @Test
    void testGetById() {
        System.out.println(loginService.selectByName("zhangsan"));
    }
//
//    /**
//     * 添加
//     */
    @Test
    void insert() {
        UserInfo userInfo = new UserInfo();
        userInfo.setNickname("王五");
        userInfo.setPassword("234");
        userInfo.setUsername("wangwu");
        userInfo.setRole("user");
        loginService.save(userInfo);
    }
//
//    /**
//     * 修改
//     */
    @Test
    void updateById() {
        UserInfo userInfo = new UserInfo();
        userInfo.setId(2);
        userInfo.setNickname("王五");
        userInfo.setPassword("234");
        userInfo.setUsername("wangwu");
        userInfo.setRole("user");
        loginService.updateById(userInfo);
    }
//
//    /**
//     * 删除
//     */
    @Test
    void deleteById() {
        loginService.removeById(3);
    }
//
//    /**
//     * 查询全部
//     */
    @Test
    void selectList() {
        System.out.println(loginService.list());
    }
//
//    /**
//     * 分页查询
//     */
    @Test
    void selectPage() {
        IPage<UserInfo> page = new Page<>(2, 5);
        loginService.page(page, null);
//        System.out.println(page.getCurrent());
//        System.out.println(page.getSize());
//        System.out.println(page.getRecords());
//        System.out.println(page.getTotal());
//
//
    }
//
//    /**
//     * 按条件查询
//     */
//    @Test
//    void selectByCondition() {
//        String companyname = "杨";
//        //用Lambda表达式进行语法的检查，防止查询的名字写错
//        LambdaQueryWrapper<Brand> lqw = new LambdaQueryWrapper<>();
//        //对传递进来的参数进行判断，当参数值不等于空时，再连接数据库进行查询
//        lqw.like(Strings.isNotEmpty(companyname), Brand::getCompanyName, companyname);
//        brandService.list(lqw);
//    }
//    @Test
//    void deleteByIds(){
//        List<Integer> ids=new ArrayList<>();
//        int[] x={1,2,3,4};
//
//        ids.add(10);
//        ids.add(20);
////        brandService.removeByIds(ids);
//        System.out.println(ids);
//        System.out.println(x);
//    }
}
