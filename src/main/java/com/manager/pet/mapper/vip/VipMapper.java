package com.manager.pet.mapper.vip;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;

/**
 * i
 * 2020 \ 12 \ 17
 */
@Mapper
public interface VipMapper {

    @Select("SELECT COUNT(1) FROM vip WHERE is_delete = 2")
    Integer selectVipCount();
}
