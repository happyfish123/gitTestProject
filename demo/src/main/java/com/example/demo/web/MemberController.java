package com.example.demo.web;

import com.example.demo.common.ResponseEntity;
import com.example.demo.service.MemberService;
import com.example.demo.vo.member.ShowUserVO;
import com.example.demo.vo.member.UpdateUserVO;
import com.example.demo.vo.member.UserLoginVO;
import com.google.common.base.Throwables;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Slf4j
@Controller
@CrossOrigin
@RequestMapping("/member")
@Api(value = "MemberController", tags = {"用户和成员控制器"})
public class MemberController {

    @Autowired
    private MemberService memberService;

    @ApiOperation("登录信息")
    @PostMapping(value = "/login")
    @ResponseBody
    public ResponseEntity<Object> login(@RequestBody UserLoginVO vo) {
        ResponseEntity<Object> responseEntity = new ResponseEntity<>();
        try {
            responseEntity = memberService.queryLogin(vo);
            responseEntity.success("登录成功！");
        } catch (Exception e) {
            log.error("登录信息失败，原因：{}", Throwables.getStackTraceAsString(e));
            responseEntity.failure("登录信息失败, 原因：" + e.getMessage(), e);
        }
        return responseEntity;
    }

    @ApiOperation("根据账号名称展示用户信息")
    @PostMapping(value = "/showUserinfo")
    @ResponseBody
    public ResponseEntity showUserinfo(@RequestBody ShowUserVO vo) {
        ResponseEntity responseEntity = new ResponseEntity<>();
        try {
            responseEntity = memberService.showUserinfo(vo);
            responseEntity.success("查询成功！");
        } catch (Exception e) {
            log.error("根据账号名称展示用户信息，原因：{}", Throwables.getStackTraceAsString(e));
            responseEntity.failure("查询失败, 原因：" + e.getMessage(), e);
        }
        return responseEntity;
    }


    @ApiOperation("修改账号密码，个人签名,头像信息")
    @PostMapping(value = "/updateUserinfo")
    @ResponseBody
    public ResponseEntity updateUserinfo(@RequestBody UpdateUserVO vo) {
        ResponseEntity responseEntity = new ResponseEntity<>();
        try {
            memberService.updateUserinfo(vo);
            responseEntity.success("查询成功！");
        } catch (Exception e) {
            log.error("修改账号密码，个人签名,头像信息失败，原因：{}", Throwables.getStackTraceAsString(e));
            responseEntity.failure("修改账号密码，个人签名,头像信息失败, 原因：" + e.getMessage(), e);
        }
        return responseEntity;
    }



}
