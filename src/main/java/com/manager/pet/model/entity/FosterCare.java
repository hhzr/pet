package com.manager.pet.model.entity;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class FosterCare {

  private Long id;
  private Long vipId;
  private String theHostName;
  private String phone;
  private String petName;
  private Integer petAge;
  private String petVariety;
  private BigDecimal petWeight;
  private String petColour;
  private String petLike;
  private Long petGender;
  private Long petHealth;
  private String petCharacter;
  private String petFosterCareTime;
  private Long createTime;
  private Long updateTime;
  private Integer isDelete;
}
