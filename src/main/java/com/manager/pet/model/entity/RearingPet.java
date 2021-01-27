package com.manager.pet.model.entity;

import lombok.Data;

import java.math.BigDecimal;

/**
 * i
 * 2020 \ 12 \ 16
 */
@Data
public class RearingPet {
    private Integer id;
    private String petFather;
    private String petMother;
    private String petBirthday;
    private String petColour;
    private BigDecimal petWeight;
    private String petSpouse;
    private String petCharacter;
    private Integer petGender;
    private Integer petHealth;
    private String petPs;
    private Long createTime;
    private Long updateTime;
    private Integer isDelete;
}
