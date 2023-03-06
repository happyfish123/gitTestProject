package com.example.demo.vo.member;

import com.example.demo.common.AbstractVO;
import com.example.demo.common.Assert;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class UpdateUserVO extends AbstractVO {

    private static final long serialVersionUID = 1253757818899446379L;

    private String UserId;

    private String userName;

    private String userPwd;

    private String userDescinfo;

    private String userImg;

    @Override
    public void checkParam() {
        Assert.nonNullStr(UserId, "UserId不能为空");
    }
}
