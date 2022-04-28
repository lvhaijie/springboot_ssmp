package com.lhj.dao;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lhj.pojo.UserInfo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class LoginDaoTest {
    @Autowired
    private LoginDao loginDao;


    /**
     * //     * 查询单个
     * //
     */
    @Test
    void testGetById() {
        System.out.println(loginDao.selectByName("zhangsan"));
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
        loginDao.insert(userInfo);
    }

    //
//    /**
//     * 修改
//     */
    @Test
    void updateById() {
        UserInfo userInfo = new UserInfo();
        userInfo.setId(3);
        userInfo.setNickname("王五");
        userInfo.setPassword("234");
        userInfo.setUsername("wangwu");
        userInfo.setRole("user");
        loginDao.updateById(userInfo);
    }

    //
//    /**
//     * 删除
//     */
    @Test
    void deleteById() {
        loginDao.deleteById(3);
    }

    //
//    /**
//     * 查询全部
//     */
//    @Test
//    void selectList() {
//        System.out.println(loginDao.selectAll());
//    }

    //
//    /**
//     * 分页查询
//     */
    @Test
    void selectPage() {
        IPage<UserInfo> page = new Page<>(2, 5);
        loginDao.selectPage(page, null);
//        System.out.println(page.getCurrent());
//        System.out.println(page.getSize());
//        System.out.println(page.getRecords());
//        System.out.println(page.getTotal());
//
//
    }
}
