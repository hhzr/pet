package com.manager.pet.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.math.BigDecimal;

/**
 * i
 * 2020 \ 12 \ 16
 */
@Data
public class Vip {
    private Integer id;
    private String vipName;
    private String vipPhone;
    private String vipBalance;
    @JsonIgnore
    private BigDecimal vipBalanceDB;
    private Long createTime;
    private Long updateTime;
    private Integer isDelete;
}
