package com.example.demo.pojo;

import com.example.demo.common.AbstractVO;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class LapMemberPOJO extends AbstractVO {
    private static final long serialVersionUID = -8501973829292132896L;

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

}
