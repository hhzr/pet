package com.manager.pet.service.fostercare;

import com.manager.pet.model.dto.FosterCareDTO;
import com.manager.pet.model.entity.FosterCare;
import com.manager.pet.model.vo.FosterCareVO;

import java.util.List;

/**
 * i
 * 2020 \ 12 \ 17
 */

public interface FosterCareService {

    Integer getFosterCareCount();

    void addFosterCarePet(FosterCareDTO fosterCare);

    List<FosterCareVO> getAllFosterCare();

    FosterCareVO getFosterCareById(Integer id);

    void modifyFosterCare(FosterCareDTO fosterCare);

    void delFosterCare(Integer id);
}
