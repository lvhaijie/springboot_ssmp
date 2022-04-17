package com.lhj.dao;

import com.lhj.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface LoginDao {

    @Select("select * from tb_user where username=#{username} and password=#{password}")
    User user( @Param("username")String username, @Param("password")String password);

    @Select("select * from tb_user where username=#{username}" )
    User selectByName( @Param("username")String username);
}
