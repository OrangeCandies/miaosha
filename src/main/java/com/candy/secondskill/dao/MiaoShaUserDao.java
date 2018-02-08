package com.candy.secondskill.dao;

import com.candy.secondskill.domain.MiaoShaUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface MiaoShaUserDao {

    @Select("SELECT * FROM miaoshauser WHERE id = #{id}")
    public MiaoShaUser getById(@Param("id") long id);
}
