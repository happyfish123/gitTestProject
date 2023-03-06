package com.example.demo.service.impl;

import com.example.demo.common.PageResult;
import com.example.demo.common.ResponseEntity;
import com.example.demo.entity.LapMemberinfo;
import com.example.demo.mapper.BasticTableMapper;
import com.example.demo.pojo.LapMemberPOJO;
import com.example.demo.pojo.LapUserInfoPOJO;
import com.example.demo.service.BasticTableService;
import com.example.demo.util.BlobUtil;
import com.example.demo.util.UUIDUtil;
import com.example.demo.vo.basticTable.AddMemberVO;
import com.example.demo.vo.basticTable.DeleteMemberVO;
import com.example.demo.vo.basticTable.LoadMemberVO;
import com.example.demo.vo.basticTable.UpdateMemberVO;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.UnsupportedEncodingException;
import java.sql.Blob;
import java.sql.Timestamp;
import java.util.*;

@Service("baticTableService")
public class BaticTableServiceImpl implements BasticTableService {
    @Resource
    BasticTableMapper basticTableMapper ;

    ModelMapper modelMapper = new ModelMapper();

    @Override
    public ResponseEntity loadMember(LoadMemberVO vo) {
        ResponseEntity responseEntity = new ResponseEntity();
        PageHelper.startPage(vo.getPageNum(), vo.getPageSize());
        List<LapMemberPOJO>  list =  basticTableMapper.loadMember(vo);
        PageInfo<LapMemberPOJO> pageInfo = new PageInfo<>(list);
        PageResult pageResult = new PageResult();
        if (pageInfo.getList() != null  &&  pageInfo.getList().size() > 0) {
            pageResult = new PageResult<>(list, pageInfo.getTotal());
        }
        responseEntity.setData(pageResult);
        return responseEntity;
    }

    @Override
    public void addMemberInfo(AddMemberVO vo)  {
        LapMemberPOJO pojo = modelMapper.map(vo, LapMemberPOJO.class);
        pojo.setUuid(UUIDUtil.getUUID());
        pojo.setMemberid(UUIDUtil.getUUID());
        pojo.setEnable("1");
       int count =  basticTableMapper.addMemberInfo(pojo);
       System.out.println(count+"====121311");
    }

    @Override
    public void updateMemberInfo(UpdateMemberVO vo)  {
        basticTableMapper.updateMemberInfo(vo);
    }

    @Override
    public void deleteMemberInfo(DeleteMemberVO vo) {
        basticTableMapper.deleteMemberInfo(vo);
    }
}
