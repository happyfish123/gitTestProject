package com.example.demo.vo.member;

import com.example.demo.common.AbstractVO;
import com.example.demo.common.Assert;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class UserLoginVO extends AbstractVO {

    private static final long serialVersionUID = 8809069774203452590L;

    private String userId;

    private String userPwd;

    private String userName;

    @Override
    public void checkParam() {
        Assert.nonNullStr(userId, "账号不能为空");
        Assert.nonNullStr(userPwd, "密码不能为空");
    }
}
