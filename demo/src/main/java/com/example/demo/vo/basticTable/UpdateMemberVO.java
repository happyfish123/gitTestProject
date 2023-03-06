package com.example.demo.vo.basticTable;

import com.example.demo.common.AbstractVO;
import com.example.demo.common.Assert;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class UpdateMemberVO extends AbstractVO {

    private static final long serialVersionUID = -9088251924105648247L;

    private String uuid;

    private String memberid;

    private String name;

    private String age;

    private String sex;

    private String birthdate;

    private String address;

    private String img;

    private String marriage;

    private String enable;

    @Override
    public void checkParam() {
        Assert.nonNullStr(uuid, "主键id不能为空");
    }

}
