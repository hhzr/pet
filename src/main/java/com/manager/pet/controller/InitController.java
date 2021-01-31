package com.manager.pet.controller;

import com.manager.pet.model.vo.FosterCareVO;
import com.manager.pet.model.vo.RearingPetVO;
import com.manager.pet.model.vo.Result;
import com.manager.pet.service.fostercare.FosterCareService;
import com.manager.pet.service.rearing.RearingPetService;

import javax.annotation.Resource;

import com.manager.pet.service.vip.VipService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Controller
@CrossOrigin
public class InitController {
    @Resource
    private RearingPetService rearingPetService;

    @Resource
    private FosterCareService fosterCareService;

    @Resource
    private VipService vipService;

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/toAddRearingPet")
    public String toAddPetInfo() {
        return "rearing/addpetinfo";
    }

    @GetMapping("/indexInfo")
    @ResponseBody
    public Result indexInfo() {
        Result result = new Result();
        Integer rearingPetCount = rearingPetService.getRearingPetCount();
        Integer fosterCareCount = fosterCareService.getFosterCareCount();
        Integer vipCount = vipService.getVipCount();
        Map<String, Integer> map = new HashMap<>();
        map.put("rearingCount", rearingPetCount);
        map.put("fosterCareCount", fosterCareCount);
        map.put("vipCount", vipCount);
        result.setCode(200);
        result.setData(map);
        return result;
    }

    @GetMapping("/toRearingPet")
    public String toRearingPet(@ModelAttribute("code") String code, @ModelAttribute("codeType") String codeType, Model model) {
        if (codeType.equals("1")) {
            model.addAttribute("addCode", code);
        }
        if (codeType.equals("2")) {
            model.addAttribute("modifyCode", code);
        }
        if (codeType.equals("3")) {
            model.addAttribute("delCode", code);
        }
        return "rearing/rearinginfo";
    }

    @GetMapping("/toModifyRearingPet")
    public String toModifyRearingPet(@RequestParam("id") Integer id, Model model) {
        RearingPetVO rearingPet = this.rearingPetService.getRearingPetById(id);
        String photo = rearingPet.getPhoto();
        if (photo != null && photo != "") {
            String[] split = photo.split(",");
            rearingPet.setPhotos(new ArrayList<>(Arrays.asList(split)));
        }
        model.addAttribute("rearingPet", rearingPet);
        return "rearing/modifyrear";
    }

    @GetMapping("/toFosterCare")
    public String toFosterCare() {
        return "fostercare/fostercareinfo";
    }

    @GetMapping("/toAddFosterCare")
    public String toAddFosterCare() {
        return "fostercare/addpetinfo";
    }

    @GetMapping("/toFosterCarePet")
    public String toFosterCarePet(@ModelAttribute("code") String code, @ModelAttribute("codeType") String codeType, Model model) {
        if (codeType.equals("1")) {
            model.addAttribute("addCode", code);
        }
        if (codeType.equals("2")) {
            model.addAttribute("modifyCode", code);
        }
        if (codeType.equals("3")) {
            model.addAttribute("delCode", code);
        }
        return "fostercare/fostercareinfo";
    }

    @GetMapping("/toModifyFosterCarePet")
    public String toModifyFosterCarePet(@RequestParam("id") Integer id, Model model) {
        FosterCareVO fosterCare = this.fosterCareService.getFosterCareById(id);
        model.addAttribute("fosterCare", fosterCare);
        return "fostercare/modifyfostercare";
    }
}
