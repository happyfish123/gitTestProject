package com.example.demo.vo.basticTable;

import com.example.demo.common.AbstractVO;
import com.example.demo.common.Assert;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class DeleteMemberVO extends AbstractVO {
    private static final long serialVersionUID = 664036728960617634L;

    private String uuid;

    @Override
    public void checkParam() {
        Assert.nonNullStr(uuid, "主键id不能为空");
    }

}
