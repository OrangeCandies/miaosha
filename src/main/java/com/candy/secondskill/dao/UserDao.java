package com.candy.secondskill.dao;

import com.candy.secondskill.domain.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserDao {

    @Select("SELECT * FROM user WHERE id = #{id}")
    public User getById(@Param("id")int id);

    @Insert("INSERT INTO user(?,?) VALUES(#{id},#{name})")
    public int insertUser(User user);
}
