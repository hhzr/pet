package com.manager.pet.model.vo;

import lombok.Data;

import java.util.List;

/**
 * i
 * 2020 \ 12 \ 16
 */
@Data
public class RearingPetVO {
    private Integer id;
    private String petFather;
    private String petMother;
    private String petName;
    private String petBirthday;
    private String petColour;
    private String petWeight;
    private String petSpouse;
    private String petCharacter;
    private Integer petGender;
    private Integer petHealth;
    private String petPs;
    private Integer qc;
    private Integer kq;
    private String health;
    private String gender;
    private String photo;
    private List<String> photos;
}
