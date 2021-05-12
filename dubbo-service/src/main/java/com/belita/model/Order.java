package com.belita.model;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Data
public class Order implements Serializable {

    private Long id;
    private Date createTime;
    private Date updateTime;
    private Long uid;
    private Long contentId;
    private BigDecimal amount;
    private Integer status;
    private String remark;
}
