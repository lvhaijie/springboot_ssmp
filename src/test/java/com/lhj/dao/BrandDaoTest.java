package com.lhj.dao;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lhj.pojo.Brand;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
public class BrandDaoTest {
    @Autowired
    private BrandDao brandDao;


    /**
     * 查询单个
     */
    @Test
    void selectById() {
        System.out.println(brandDao.selectById(2));
    }

    /**
     * 添加
     */
    @Test
    void insert() {
        Brand brand = new Brand();
        brand.setBrandName("杨老师");
        brand.setCompanyName("杨老师大妞子");
        brand.setDescription("杨老师妞子大");
        brand.setStatus(1);
        brand.setOrdered(1000);
        brandDao.insert(brand);
    }

    /**
     * 修改
     */
    @Test
    void updateById() {
        Brand brand = new Brand();
        brand.setId(48);
        brand.setBrandName("杨老师");
        brand.setCompanyName("杨老师大妞子");
        brand.setDescription("杨老师妞子大");
        brand.setStatus(1);
        brand.setOrdered(1000);
        brandDao.updateById(brand);
    }

    /**
     * 删除
     */
    @Test
    void deleteById() {
        brandDao.deleteById(48);
    }

    /**
     * 查询全部
     */
    @Test
    void selectList() {
        brandDao.selectList(null);
    }

    /**
     * 分页查询
     */
    @Test
    void selectPage() {
        IPage page = new Page(1, 5);
        brandDao.selectPage(page, null);
    }

    /**
     * 按条件查询
     */
    @Test
    void selectByCondition() {
        QueryWrapper<Brand> qw = new QueryWrapper<>();
        qw.like("brand_name", "小米");
        brandDao.selectList(qw);
    }

    /**
     * 按条件查询
     */
    @Test
    void selectByCondition2() {
        String companyname = "小米";
        //用Lambda表达式进行语法的检查，防止查询的名字写错
        LambdaQueryWrapper<Brand> lqw = new LambdaQueryWrapper<>();
        //对传递进来的参数进行判断，当参数值不等于空时，再连接数据库进行查询
        lqw.like(companyname != null, Brand::getCompanyName, companyname);
        brandDao.selectList(lqw);
    }

}
