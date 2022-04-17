package com.lhj.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.lhj.pojo.Brand;

/**
 * mp快速开发，继承IService<T>
 */

public interface IBrandService extends IService<Brand> {
    IPage<Brand> getPage(Integer currentPage,Integer pageSize);
    IPage<Brand> getPage(Integer currentPage,Integer pageSize,Brand brand);
    //修改
    Boolean modify(Brand brand);
//    Boolean deleteByIds(List<Integer> ids);
}
