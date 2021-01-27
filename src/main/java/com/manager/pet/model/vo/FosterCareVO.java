package com.manager.pet.model.vo;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class FosterCareVO {

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
  private Integer petGender;
  private Integer petHealth;
  private String petCharacter;
  private String petFosterCareTime;
  private Long createTime;
  private Long updateTime;
  private Integer isDelete;

  private String gender;
  private String health;
  private String stareTime;
}
