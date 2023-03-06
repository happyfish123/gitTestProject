package com.example.demo.vo.basticTable;

import com.example.demo.common.AbstractVO;
import com.example.demo.common.Assert;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class AddMemberVO extends AbstractVO {
    private static final long serialVersionUID = -8750264854024839252L;

    private String name;

    private String age;

    private String sex;

    private String birthdate;

    private String address;

    private String img;

    private String marriage;

    @Override
    public void checkParam() {
        Assert.nonNullStr(name, "姓名不能为空");
    }

}
