package com.manager.pet.service.rearing.impl;

import com.manager.pet.mapper.rearing.RearingPetMapper;
import com.manager.pet.model.dto.RearingPetDTO;
import com.manager.pet.model.vo.RearingPetVO;
import com.manager.pet.service.rearing.RearingPetService;

import java.util.List;
import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class RearingPetServiceImpl implements RearingPetService {
    @Resource
    private RearingPetMapper rearingPetMapper;

    public void addRearingPet(RearingPetDTO rearingPet) {
        long time = System.currentTimeMillis();
        rearingPet.setCreateTime(time);
        rearingPet.setUpdateTime(time);
        Integer qc = rearingPet.getQc();
        Integer kq = rearingPet.getKq();
        if (null != qc && null != kq) {
            rearingPet.setPetHealth(1);
        } else if (null != qc && null == kq) {
            rearingPet.setPetHealth(2);
        } else if (null == qc && null != kq) {
            rearingPet.setPetHealth(3);
        } else if (null == qc && null == kq) {
            rearingPet.setPetHealth(4);
        }
        this.rearingPetMapper.insertRearingPet(rearingPet);
    }

    public List<RearingPetVO> getAllRearingPet() {
        List<RearingPetVO> rearingPet = this.rearingPetMapper.selectAllRearingPet();
        rearingPet.forEach(item -> {
            Integer petHealth = item.getPetHealth();
            Integer petGender = item.getPetGender();
            if (petGender == 1)
                item.setGender("公");
            if (petGender == 2)
                item.setGender("母");
            if (petHealth != null) {
                if (petHealth == 1)
                    item.setHealth("正常");
                if (petHealth == 2)
                    item.setHealth("驱虫未打狂犬疫苗");
                if (petHealth == 3)
                    item.setHealth("未驱虫打狂犬疫苗");
                if (petHealth == 4)
                    item.setHealth("未驱虫未打狂犬疫苗");
            }
        });
        return rearingPet;
    }

    public RearingPetVO getRearingPetById(Integer id) {
        return this.rearingPetMapper.selectRearingPetById(id);
    }

    public void modifyRearingPet(RearingPetDTO rearingPet) {
        long time = System.currentTimeMillis();
        Integer qc = rearingPet.getQc();
        Integer kq = rearingPet.getKq();
        if (null != qc && null != kq) {
            rearingPet.setPetHealth((1));
        } else if (null != qc && null == kq) {
            rearingPet.setPetHealth((2));
        } else if (null == qc && null != kq) {
            rearingPet.setPetHealth((3));
        } else if (null == qc && null == kq) {
            rearingPet.setPetHealth((4));
        }
        rearingPet.setUpdateTime((time));
        this.rearingPetMapper.updateRearingPet(rearingPet);
    }

    public void delRearingPet(Integer id) {
        this.rearingPetMapper.delRearingPet(id);
    }

    @Override
    public Integer getRearingPetCount() {
        return rearingPetMapper.selectRearingPetCount();
    }

    @Override
    public void uploadPetPhoto(String photo, String id) {
        RearingPetVO rearingPetVO = rearingPetMapper.selectRearingPetById(Integer.valueOf(id));
        String petPhoto = rearingPetVO.getPhoto();
        StringBuffer p = new StringBuffer();
        if (petPhoto != null && petPhoto != "") {
            p.append(petPhoto).append(",").append(photo);
            rearingPetMapper.uploadPetPhoto(p.toString(), id);
        } else {
            rearingPetMapper.uploadPetPhoto(photo, id);
        }
    }
}
