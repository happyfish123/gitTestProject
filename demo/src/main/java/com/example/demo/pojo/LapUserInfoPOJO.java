package com.example.demo.pojo;

import com.example.demo.common.AbstractVO;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class LapUserInfoPOJO extends AbstractVO {
    private static final long serialVersionUID = -8501973829292132896L;

    private String userId;

    private String userName;

    private String userPwd;

    private String userDescinfo;

    private String userImg;

}
