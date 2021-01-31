package com.manager.pet.service.rearing;

import com.manager.pet.model.dto.RearingPetDTO;
import com.manager.pet.model.vo.RearingPetVO;

import java.util.List;

/**
 * i
 * 2020 \ 12 \ 16
 */

public interface RearingPetService {
    void addRearingPet(RearingPetDTO rearingPetDTO);

    List<RearingPetVO> getAllRearingPet();

    RearingPetVO getRearingPetById(Integer id);

    void modifyRearingPet(RearingPetDTO rearingPet);

    void delRearingPet(Integer id);

    Integer getRearingPetCount();

    void uploadPetPhoto(String photo, String id);
}
