package com.manager.pet.service.vip.impl;

import com.manager.pet.mapper.vip.VipMapper;
import com.manager.pet.service.vip.VipService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * i
 * 2020 \ 12 \ 17
 */
@Service
public class VipServiceImpl implements VipService {

    @Resource
    private VipMapper vipMapper;

    @Override
    public Integer getVipCount() {
        return vipMapper.selectVipCount();
    }
}
