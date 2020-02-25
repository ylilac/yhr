package com.yang.yhr.dao;

import com.yang.yhr.entity.Hr;
import com.yang.yhr.entity.Role;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface HrDao {

//    @Select("select * from hr where id=#{id}")
    Hr queryById(Integer id);

    int deleteByPrimaryKey(Integer id);

    int insert(Hr record);

    int insertSelective(Hr record);

    Hr selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Hr record);

    int updateByPrimaryKey(Hr record);

    Hr loadUserByUsername(String username);

    List<Role> getHrRolesById(Integer id);

    List<Hr> getAllHrs(@Param("hrid") Integer hrid, @Param("keywords") String keywords);

    List<Hr> getAllHrsExceptCurrentHr(Integer id);
}