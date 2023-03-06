package com.example.demo.web;

import com.example.demo.common.ResponseEntity;
import com.example.demo.service.BasticTableService;
import com.example.demo.vo.basticTable.AddMemberVO;
import com.example.demo.vo.basticTable.DeleteMemberVO;
import com.example.demo.vo.basticTable.LoadMemberVO;
import com.example.demo.vo.basticTable.UpdateMemberVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 *基础表格界面
 * @param
 * @return
 */

@Slf4j
@Controller
@CrossOrigin
@RequestMapping("/basticTable")
@Api(value = "BasticTableController", tags = {"基础表格控制器"})
public class BasticTableController {

    @Autowired
    private BasticTableService basticTableService ;

    @ApiOperation("展示成员信息")
    @PostMapping(value = "/loadMember")
    @ResponseBody
    public ResponseEntity loadMember(@RequestBody LoadMemberVO vo) {
        ResponseEntity responseEntity = new ResponseEntity<>();
        try {
            responseEntity = basticTableService.loadMember(vo);
            responseEntity.success("查询成功");
        } catch (Exception e) {
            e.printStackTrace();
            responseEntity.failure("展示成员信息失败, 原因：" + e.getMessage(), e);
        }
        return responseEntity;
    }

    @ApiOperation("新增成员信息")
    @PostMapping(value = "/addMemberInfo")
    @ResponseBody
    public ResponseEntity addMemberInfo(@RequestBody AddMemberVO vo) {
        ResponseEntity responseEntity = new ResponseEntity<>();
        try {
            basticTableService.addMemberInfo(vo);
            responseEntity.success("新增成功");
        } catch (Exception e) {
            e.printStackTrace();
            responseEntity.failure("新增成员信息失败, 原因：" + e.getMessage(), e);
        }
        return responseEntity;
    }

    @ApiOperation("修改成员信息")
    @PostMapping(value = "/updateMemberInfo")
    @ResponseBody
    public ResponseEntity updateMemberInfo(@RequestBody UpdateMemberVO vo) {
        ResponseEntity responseEntity = new ResponseEntity<>();
        try {
            basticTableService.updateMemberInfo(vo);
            responseEntity.success("修改成功");
        } catch (Exception e) {
            e.printStackTrace();
            responseEntity.failure("修改成员信息失败, 原因：" + e.getMessage(), e);
        }
        return responseEntity;
    }

    @ApiOperation("删除成员信息")
    @PostMapping(value = "/deleteMemberInfo")
    @ResponseBody
    public ResponseEntity deleteMemberInfo(DeleteMemberVO vo) {
        ResponseEntity responseEntity = new ResponseEntity<>();
        try {
            basticTableService.deleteMemberInfo(vo);
            responseEntity.success("删除成功");
        } catch (Exception e) {
            e.printStackTrace();
            responseEntity.failure("删除成员信息失败, 原因：" + e.getMessage(), e);
        }
        return responseEntity;
    }
}
