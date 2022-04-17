package com.lhj.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.lhj.controller.utils.R;
import com.lhj.pojo.Brand;
import com.lhj.service.IBrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/brands")
public class BrandController {
    @Autowired
    private IBrandService brandService;

    //查询所有
    @GetMapping
    public R selectAll() {
        return new R(true, brandService.list());

    }


    //删除
    @DeleteMapping("{id}")
    public R delete( @PathVariable Integer id ) {
        return new R(brandService.removeById(id));
    }


    //修改
    @PutMapping
    public R updata( @RequestBody Brand brand ) {
        return new R(brandService.modify(brand));
    }


    //添加
    @PostMapping
    public R save( @RequestBody Brand brand ) {
        return new R(brandService.save(brand));
    }


    //查询单个
    @GetMapping("{id}")
    public R getById( @PathVariable Integer id ) {

        return new R(true, brandService.getById(id));
    }


    ////    //条件查询&分页查询
    @GetMapping("{currentPage}/{pageSize}")
    public R getPage( @PathVariable Integer currentPage, @PathVariable Integer pageSize, Brand brand ) {
        IPage<Brand> page = brandService.getPage(currentPage, pageSize, brand);
        if (currentPage > page.getPages()) {
            //判断如果当前页码值大于总页码值，则当前页码值设为第一页
            page = brandService.getPage(1, pageSize, brand);
        }
        return new R(true, page);
    }

    //批量删除
    @DeleteMapping
    public R deleteByIds( @RequestBody List<Integer> ids ) {
        return new R(brandService.removeByIds(ids));
    }


//    //    //分页查询
//    @GetMapping("{currentPage}/{pageSize}")
//    public R getPage( @PathVariable Integer currentPage, @PathVariable Integer pageSize ) {
//        IPage<Brand> page = brandService.getPage(currentPage, pageSize);
//        if(currentPage>page.getPages()){
//            //判断如果当前页码值大于总页码值，则当前页码值设为第一页
//            page = brandService.getPage(1,pageSize);
//        }
//        return new R(true,brandService.getPage(currentPage,pageSize));
//    }
}
