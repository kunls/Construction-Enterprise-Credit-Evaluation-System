package com.lxk.enterprisecreditsystem.controller;

import com.lxk.enterprisecreditsystem.domain.CreditRate;
import com.lxk.enterprisecreditsystem.service.CreditRateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CreditRateController {
    @Autowired
    private CreditRateService rateService;

    /**
     * 获取企业信用评定列表
     *
     * @param page
     * @param pageSize
     * @param keyword
     * @param ruleId
     * @return
     */
    @GetMapping("/EnterpriseCreditRateList/getData")
    public List<CreditRate> getEnterpriseData(Integer page, Integer pageSize, String keyword, String ruleId) {
        return rateService.getEnterpriseData(page, pageSize, keyword, ruleId);
    }

    @GetMapping("/PersonalCreditRateList/getData")
    public List<CreditRate> getPersonData(Integer page, Integer pageSize, String keyword, String ruleId) {
        return rateService.getPersonData(page, pageSize, keyword, ruleId);
    }
    
}
