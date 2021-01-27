package com.manager.pet.service.fostercare.impl;

import com.manager.pet.mapper.fostercare.FosterCareMapper;
import com.manager.pet.model.dto.FosterCareDTO;
import com.manager.pet.model.dto.RearingPetDTO;
import com.manager.pet.model.vo.FosterCareVO;
import com.manager.pet.model.vo.RearingPetVO;
import com.manager.pet.service.fostercare.FosterCareService;
import javafx.scene.input.DataFormat;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * i
 * 2020 \ 12 \ 17
 */
@Service
public class FosterCareServiceImpl implements FosterCareService {

    @Resource
    private FosterCareMapper fosterCareMapper;

    @Override
    public Integer getFosterCareCount() {
        return fosterCareMapper.selectFosterCareCount();
    }

    @Override
    public void addFosterCarePet(FosterCareDTO fosterCare) {
        long time = System.currentTimeMillis();
        fosterCare.setCreateTime(time);
        fosterCare.setUpdateTime(time);
        Integer qc = fosterCare.getQc();
        Integer kq = fosterCare.getKq();
        if (null != qc && null != kq) {
            fosterCare.setPetHealth(1);
        } else if (null != qc && null == kq) {
            fosterCare.setPetHealth(2);
        } else if (null == qc && null != kq) {
            fosterCare.setPetHealth(3);
        } else if (null == qc && null == kq) {
            fosterCare.setPetHealth(4);
        }
        this.fosterCareMapper.insertFosterCarePet(fosterCare);
    }

    @Override
    public List<FosterCareVO> getAllFosterCare() {
        List<FosterCareVO> fosterCarePet = this.fosterCareMapper.selectAllFosterCare();
        fosterCarePet.forEach(item -> {
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
            Date date = new Date(item.getCreateTime());
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd ahh:mm");
            item.setStareTime(simpleDateFormat.format(date));
        });
        return fosterCarePet;
    }

    @Override
    public FosterCareVO getFosterCareById(Integer id) {
        return fosterCareMapper.selectFosterCareById(id);
    }

    public void modifyFosterCare(FosterCareDTO fosterCare) {
        System.out.println(fosterCare);
        long time = System.currentTimeMillis();
        Integer qc = fosterCare.getQc();
        Integer kq = fosterCare.getKq();
        if (null != qc && null != kq) {
            fosterCare.setPetHealth((1));
        } else if (null != qc && null == kq) {
            fosterCare.setPetHealth((2));
        } else if (null == qc && null != kq) {
            fosterCare.setPetHealth((3));
        } else if (null == qc && null == kq) {
            fosterCare.setPetHealth((4));
        }
        fosterCare.setUpdateTime((time));
        this.fosterCareMapper.modifyFosterCarePet(fosterCare);
    }

    @Override
    public void delFosterCare(Integer id) {
        this.fosterCareMapper.delFosterCarePet(id);
    }
}
