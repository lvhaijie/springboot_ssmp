package com.lhj.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lhj.pojo.Brand;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface BrandDao extends BaseMapper<Brand> {
}
