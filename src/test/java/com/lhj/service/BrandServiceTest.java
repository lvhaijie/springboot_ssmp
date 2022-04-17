package com.lhj.service;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lhj.pojo.Brand;
import org.apache.logging.log4j.util.Strings;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class BrandServiceTest {
    @Autowired
    private IBrandService brandService;

    /**
     * 查询单个
     */
    @Test
    void testGetById() {
        System.out.println(brandService.getById(10));
    }

    /**
     * 添加
     */
    @Test
    void insert() {
        Brand brand = new Brand();
        brand.setBrandName("杨老师");
        brand.setCompanyName("杨老师子");
        brand.setDescription("杨老师妞子大");
        brand.setStatus(1);
        brand.setOrdered(1000);
        brandService.save(brand);
    }

    /**
     * 修改
     */
    @Test
    void updateById() {
        Brand brand = new Brand();
        brand.setId(20);
        brand.setBrandName("杨老师");
        brand.setCompanyName("杨老师大妞子");
        brand.setDescription("杨老师妞子大");
        brand.setStatus(1);
        brand.setOrdered(1000);
        brandService.updateById(brand);
    }

    /**
     * 删除
     */
    @Test
    void deleteById() {
        brandService.removeById(21);
    }

    /**
     * 查询全部
     */
    @Test
    void selectList() {
        System.out.println(brandService.list());
    }

    /**
     * 分页查询
     */
    @Test
    void selectPage() {
        IPage<Brand> page = new Page<>(2, 5);
        brandService.page(page, null);
        System.out.println(page.getCurrent());
        System.out.println(page.getSize());
        System.out.println(page.getRecords());
        System.out.println(page.getTotal());


    }

    /**
     * 按条件查询
     */
    @Test
    void selectByCondition() {
        String companyname = "杨";
        //用Lambda表达式进行语法的检查，防止查询的名字写错
        LambdaQueryWrapper<Brand> lqw = new LambdaQueryWrapper<>();
        //对传递进来的参数进行判断，当参数值不等于空时，再连接数据库进行查询
        lqw.like(Strings.isNotEmpty(companyname), Brand::getCompanyName, companyname);
        brandService.list(lqw);
    }
    @Test
    void deleteByIds(){
        List<Integer> ids=new ArrayList<>();
        int[] x={1,2,3,4};

        ids.add(10);
        ids.add(20);
//        brandService.removeByIds(ids);
        System.out.println(ids);
        System.out.println(x);
    }
}
