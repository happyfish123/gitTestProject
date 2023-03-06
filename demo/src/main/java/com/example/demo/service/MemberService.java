package com.example.demo.service;

import com.example.demo.common.ResponseEntity;
import com.example.demo.vo.member.ShowUserVO;
import com.example.demo.vo.member.UpdateUserVO;
import com.example.demo.vo.member.UserLoginVO;


public interface MemberService {

    ResponseEntity queryLogin(UserLoginVO vo);

    ResponseEntity showUserinfo(ShowUserVO vo);

    void  updateUserinfo(UpdateUserVO vo);



}
