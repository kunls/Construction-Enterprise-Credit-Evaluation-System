package com.lxk.enterprisecreditsystem.controller;

import com.lxk.enterprisecreditsystem.dto.creditListDto.EnterpriseDTO;
import com.lxk.enterprisecreditsystem.dto.creditListDto.PersonDTO;
import com.lxk.enterprisecreditsystem.service.CreditBehaviorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class CreditBehaviorController {
    @Autowired
    private CreditBehaviorService behaviorService;

    /**
     * 获取个人信用列表
     * @param page
     * @param pageSize
     * @param keyword
     * @return
     */
    @GetMapping("/PersonalCreditList/getData")
    public List<PersonDTO> getPersonData(Integer page, Integer pageSize, String keyword) {
        return behaviorService.getPersonData(page, pageSize, keyword);
    }

    /**
     * 获取企业信用列表
     * @param page
     * @param pageSize
     * @param keyword
     * @return
     */
    @GetMapping("/EnterpriseCreditList/getData")
    public List<EnterpriseDTO> getEnterpriseData(Integer page, Integer pageSize, String keyword) {
        return behaviorService.getEnterpriseData(page, pageSize, keyword);
    }
}
