package com.manager.pet.controller.rearing;

import com.manager.pet.model.dto.RearingPetDTO;
import com.manager.pet.model.vo.RearingPetVO;
import com.manager.pet.model.vo.Result;
import com.manager.pet.service.rearing.RearingPetService;

import java.io.IOException;
import java.util.List;
import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import sun.misc.BASE64Encoder;

@Controller
@CrossOrigin
public class RearingPetController {

    @Resource
    private RearingPetService rearingPetService;

    @PostMapping("/addRearingPet")
    public String addRearingPet(RearingPetDTO rearing, RedirectAttributes redirect) {
        this.rearingPetService.addRearingPet(rearing);
        redirect.addFlashAttribute("code", 200);
        redirect.addFlashAttribute("codeType", 1);
        return "redirect:/toRearingPet";
    }

    @RequestMapping("/rearingPet")
    @ResponseBody
    public Result rearingPet() {
        List<RearingPetVO> allRearingPet = this.rearingPetService.getAllRearingPet();
        Result result = new Result();
        if (allRearingPet != null) {
            result.setCode(0);
            result.setData(allRearingPet);
            if (allRearingPet.size() > 0) {
                result.setCode(0);
                result.setData(allRearingPet);
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

    @PostMapping("/modifyRearingPet")
    public String modifyRearingPet(RearingPetDTO rearing, RedirectAttributes redirect) {
        this.rearingPetService.modifyRearingPet(rearing);
        redirect.addFlashAttribute("code", 200);
        redirect.addFlashAttribute("codeType", 2);
        return "redirect:/toRearingPet";
    }

    @RequestMapping("/delRearingPet")
    @ResponseBody
    public Result delRearingPet(@RequestParam("id") Integer id, Model model) {
        this.rearingPetService.delRearingPet(id);
        Result result = new Result();
        model.addAttribute("delCode", 200);
        result.setCode((200));
        result.setMessage("删除成功");
        return result;
    }


    @PostMapping("/uploadRearingPhoto")
    @ResponseBody
    public Result uploadRearingPhoto(MultipartFile file) {
        try {
            BASE64Encoder base64Encoder =new BASE64Encoder();
            String base64EncoderImg = base64Encoder.encode(file.getBytes());
            System.out.println(base64EncoderImg);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new Result(200);
    }
}
