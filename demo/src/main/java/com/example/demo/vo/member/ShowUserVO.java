package com.example.demo.vo.member;

import com.example.demo.common.AbstractVO;
import com.example.demo.common.Assert;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class ShowUserVO extends AbstractVO {

    private static final long serialVersionUID = 8809069774203452590L;

    private String UserId;

    private String userName;

    private String userDescinfo;

    @Override
    public void checkParam() {
        Assert.nonNullStr(UserId, "用户名称不能为空");
    }
}
