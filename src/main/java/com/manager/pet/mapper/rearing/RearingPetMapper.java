package com.manager.pet.mapper.rearing;

import com.manager.pet.model.dto.RearingPetDTO;
import com.manager.pet.model.vo.RearingPetVO;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * i
 * 2020 \ 12 \ 16
 */
@Mapper
public interface RearingPetMapper {
    void insertRearingPet(@Param("rearing") com.manager.pet.model.dto.RearingPetDTO rearing);

    @Select("SELECT * FROM rearing WHERE is_delete = 2")
    @ResultMap("rearingPet")
    List<RearingPetVO> selectAllRearingPet();

    @Select("SELECT * FROM rearing WHERE id = #{id}")
    @ResultMap("rearingPet")
    RearingPetVO selectRearingPetById(@Param("id") Integer id);

    void updateRearingPet(@Param("pet") RearingPetDTO rearingPet);

    @Update("UPDATE rearing SET is_delete = 1 WHERE id = #{id}")
    void delRearingPet(@Param("id") Integer id);

    @Select("SELECT COUNT(1) FROM rearing WHERE is_delete = 2")
    Integer selectRearingPetCount();

    @Update("UPDATE rearing SET pet_photo = #{photo} WHERE id = #{id}")
    void uploadPetPhoto(@Param(value = "photo")String photo, @Param(value = "id")String id);
}
