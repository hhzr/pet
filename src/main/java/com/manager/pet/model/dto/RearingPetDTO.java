package com.manager.pet.model.dto;

import lombok.Data;

import java.math.BigDecimal;

/**
 * i
 * 2020 \ 12 \ 16
 */
@Data
public class RearingPetDTO {

    private Integer id;
    private String petFather;
    private String petMother;
    private String petName;
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
    private Integer qc;
    private Integer kq;
}
