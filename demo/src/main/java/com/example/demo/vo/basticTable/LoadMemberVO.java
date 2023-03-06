package com.example.demo.vo.basticTable;

import com.example.demo.common.PageParams;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class LoadMemberVO extends PageParams {

    private static final long serialVersionUID = 3311395603993794914L;

    /*
    * 成员姓名
    * */
    private String name;

    /*
     * 成员地址
     * */
    private String address;

}
