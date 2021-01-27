package com.manager.pet.controller.fostercare;

import com.manager.pet.model.dto.FosterCareDTO;
import com.manager.pet.model.dto.RearingPetDTO;
import com.manager.pet.model.vo.FosterCareVO;
import com.manager.pet.model.vo.RearingPetVO;
import com.manager.pet.model.vo.Result;
import com.manager.pet.service.fostercare.FosterCareService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.annotation.Resource;
import java.util.List;

/**
 * i
 * 2020 \ 12 \ 17
 */
@Controller
@CrossOrigin
public class FosterCareController {

    @Resource
    private FosterCareService fosterCareService;

    @PostMapping("/addFosterCare")
    public String addFosterCare(FosterCareDTO fosterCare, RedirectAttributes redirect) {
        this.fosterCareService.addFosterCarePet(fosterCare);
        redirect.addFlashAttribute("code", 200);
        redirect.addFlashAttribute("codeType", 1);
        return "redirect:/toFosterCarePet";
    }

    @RequestMapping("/fosterCarePet")
    @ResponseBody
    public Result rearingPet() {
        List<FosterCareVO> allFosterCare = this.fosterCareService.getAllFosterCare();
        Result result = new Result();
        if (allFosterCare != null) {
            result.setCode(0);
            result.setData(allFosterCare);
            if (allFosterCare.size() > 0) {
                result.setCode(0);
                result.setData(allFosterCare);
            } else {
                result.setCode(0);
                result.setData(null);
            }
        } else {
            result.setCode(500);
            result.setMessage("暂无数据");
        }
        return result;
    }

    @PostMapping("/modifyFosterCarePet")
    public String modifyRearingPet(FosterCareDTO fosterCare, RedirectAttributes redirect) {
        this.fosterCareService.modifyFosterCare(fosterCare);
        redirect.addFlashAttribute("code", 200);
        redirect.addFlashAttribute("codeType", 2);
        return "redirect:/toFosterCarePet";
    }

    @RequestMapping("/delFosterCarePet")
    @ResponseBody
    public Result delRearingPet(@RequestParam("id") Integer id, Model model) {
        this.fosterCareService.delFosterCare(id);
        Result result = new Result();
        model.addAttribute("delCode", 200);
        result.setCode((200));
        result.setMessage("删除成功");
        return result;
    }
}
