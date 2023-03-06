package com.example.demo.service;


import com.example.demo.common.ResponseEntity;
import com.example.demo.entity.LapMemberinfo;
import com.example.demo.vo.basticTable.AddMemberVO;
import com.example.demo.vo.basticTable.DeleteMemberVO;
import com.example.demo.vo.basticTable.LoadMemberVO;
import com.example.demo.vo.basticTable.UpdateMemberVO;

import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Map;

public interface BasticTableService {

    ResponseEntity loadMember(LoadMemberVO vo);

    void addMemberInfo(AddMemberVO vo);

    void updateMemberInfo(UpdateMemberVO vo) ;

    void deleteMemberInfo(DeleteMemberVO vo);

}
