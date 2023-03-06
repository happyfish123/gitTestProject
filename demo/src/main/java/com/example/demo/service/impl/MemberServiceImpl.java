package com.example.demo.service.impl;

import com.example.demo.common.Assert;
import com.example.demo.common.ResponseEntity;
import com.example.demo.mapper.MemberMapper;
import com.example.demo.pojo.LapUserInfoPOJO;
import com.example.demo.service.MemberService;
import com.example.demo.vo.member.ShowUserVO;
import com.example.demo.vo.member.UpdateUserVO;
import com.example.demo.vo.member.UserLoginVO;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("memberService")
public class MemberServiceImpl implements MemberService {

    @Resource
    MemberMapper memberMapper;

    ModelMapper modelMapper = new ModelMapper();

    @Override
    public ResponseEntity queryLogin(UserLoginVO vo) {
        ResponseEntity responseEntity = new ResponseEntity();
        LapUserInfoPOJO pojo = modelMapper.map(vo, LapUserInfoPOJO.class);
        List<LapUserInfoPOJO> list = memberMapper.queryLogin(pojo);
        Assert.isFalse(list.size()==0, "账号或密码错误！");
        UserLoginVO  resVO  = modelMapper.map(list.get(0),UserLoginVO.class);
        responseEntity.setData(resVO);
        return responseEntity;
    }

    @Override
    public ResponseEntity showUserinfo(ShowUserVO vo) {
        ResponseEntity responseEntity = new ResponseEntity();
        LapUserInfoPOJO pojo = modelMapper.map(vo, LapUserInfoPOJO.class);
        List<LapUserInfoPOJO> list = memberMapper.queryLogin(pojo);
        Assert.isFalse(list.size()==0, "当前用户不存在！");
        LapUserInfoPOJO resVo = list.get(0);
        responseEntity.setData(resVo);
        return responseEntity;
    }


    @Override
    public void updateUserinfo(UpdateUserVO vo) {
        LapUserInfoPOJO pojo = modelMapper.map(vo, LapUserInfoPOJO.class);
        memberMapper.updateUserinfo(pojo);
    }

}
