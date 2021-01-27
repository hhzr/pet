package com.manager.pet.model.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class FosterCareDTO {

  private Integer id;
  private String theHostName;
  private String phone;
  private String petName;
  private Integer petAge;
  private String petVariety;
  private BigDecimal petWeight;
  private String petColour;
  private String petLike;
  private Integer petGender;
  private String petCharacter;
  private Integer petHealth;
  private Integer qc;
  private Integer kq;
  private Long createTime;
  private Long updateTime;
  private String petFosterCareTime;
}
