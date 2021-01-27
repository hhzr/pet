package com.manager.pet.mapper.fostercare;

import com.manager.pet.model.dto.FosterCareDTO;
import com.manager.pet.model.entity.FosterCare;
import com.manager.pet.model.vo.FosterCareVO;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * i
 * 2020 \ 12 \ 17
 */
@Mapper
public interface FosterCareMapper {

    @Select("SELECT COUNT(1) FROM fostercare WHERE is_delete = 2")
    Integer selectFosterCareCount();

    void insertFosterCarePet(@Param("fosterCare") FosterCareDTO fosterCare);

    @Select("SELECT * FROM fostercare")
    @ResultMap("fostercare")
    List<FosterCareVO> selectAllFosterCare();

    @Select("SELECT * FROM fostercare WHERE id = #{id} ")
    @ResultMap("fostercare")
    FosterCareVO selectFosterCareById(@Param("id")Integer id);

    void modifyFosterCarePet(@Param(value = "fosterCare") FosterCareDTO fosterCare);

    @Update("UPDATE fostercare SET is_delete = 1 WHERE id = #{id}")
    void delFosterCarePet(@Param("id") Integer id);
}
