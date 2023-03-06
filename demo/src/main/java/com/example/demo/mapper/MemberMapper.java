package com.example.demo.mapper;

import com.example.demo.pojo.LapUserInfoPOJO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface MemberMapper {

    List<LapUserInfoPOJO> queryLogin(LapUserInfoPOJO pojo);

    void  updateUserinfo(LapUserInfoPOJO pojo);

}
