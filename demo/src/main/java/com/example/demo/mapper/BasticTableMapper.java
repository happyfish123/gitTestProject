package com.example.demo.mapper;

import com.example.demo.pojo.LapMemberPOJO;
import com.example.demo.vo.basticTable.DeleteMemberVO;
import com.example.demo.vo.basticTable.LoadMemberVO;
import com.example.demo.vo.basticTable.UpdateMemberVO;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

@Mapper
public interface BasticTableMapper {

    List<LapMemberPOJO> loadMember(LoadMemberVO vo);

    int addMemberInfo(LapMemberPOJO pojo);

    void updateMemberInfo(UpdateMemberVO vo);

    void deleteMemberInfo(DeleteMemberVO vo);

}
