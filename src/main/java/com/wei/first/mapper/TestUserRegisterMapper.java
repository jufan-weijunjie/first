package com.wei.first.mapper;

import com.wei.first.bean.TestUserRegister;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface TestUserRegisterMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TestUserRegister record);

    int insertSelective(TestUserRegister record);

    TestUserRegister selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TestUserRegister record);

    int updateByPrimaryKey(TestUserRegister record);
}