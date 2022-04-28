package com.lhj.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lhj.pojo.UserInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface LoginDao extends BaseMapper<UserInfo> {

    @Select("select * from tb_user_info where username=#{username} and password=#{password}")
    UserInfo user( @Param("username")String username, @Param("password")String password);

    @Select("select * from tb_user_info where username=#{username}" )
    UserInfo selectByName( @Param("username")String username);

//    @Select("select *  from tb_user_info ")
//    List<UserInfo> selectAll();
}
