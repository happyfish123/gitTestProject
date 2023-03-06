package com.example.demo.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.Map;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PageParams extends AbstractVO {
    private static final long serialVersionUID = 5129105591350826840L;

    private Integer pageNum = 1;
    private Integer pageSize = 10;
    private Map<String, Object> searchParams;

}
