//package com.lhj.service.impl;
//
//import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
//import com.baomidou.mybatisplus.core.metadata.IPage;
//import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
//import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
//import com.lhj.dao.BrandDao;
//import com.lhj.pojo.Brand;
//import com.lhj.service.IBrandService;
//import org.apache.logging.log4j.util.Strings;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
///**
// * mp快速开发，继承ServiceImpl<M,T>，再实现对应的接口
// */
//@Transactional
//@Service
//public class BrandServiceImpl extends ServiceImpl<BrandDao, Brand> implements IBrandService {
//    @Autowired
//    private BrandDao brandDao;
//
//    @Override
//    public IPage<Brand> getPage( Integer currentPage, Integer pageSize ) {
//        IPage<Brand> page = new Page<>(currentPage, pageSize);
//        brandDao.selectPage(page, null);
//        return page;
//    }
//
//    @Override
//    public IPage<Brand> getPage( Integer currentPage, Integer pageSize, Brand brand ) {
//        LambdaQueryWrapper<Brand> lqw=new LambdaQueryWrapper<Brand>();
//        lqw.eq(brand.getStatus()!=null,Brand::getStatus,brand.getStatus());
//        lqw.like(Strings.isNotEmpty(brand.getBrandName()), Brand::getBrandName, brand.getBrandName());
//        lqw.like(Strings.isNotEmpty(brand.getCompanyName()), Brand::getCompanyName, brand.getCompanyName());
//        IPage<Brand> page = new Page<>(currentPage, pageSize);
//        brandDao.selectPage(page, lqw);
//        return page;
//    }
//
//    @Override
//    public Boolean modify( Brand brand ) {
//        return brandDao.updateById(brand)>0;
//    }
////
////    @Override
////    public Boolean deleteByIds( List<Integer> ids ) {
////        return brandDao.deleteBatchIds(ids)>0;
////    }
//
//
//}
