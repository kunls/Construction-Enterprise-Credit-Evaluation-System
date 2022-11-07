package com.lxk.enterprisecreditsystem.controller;

import com.lxk.enterprisecreditsystem.domain.CreditRate;
import com.lxk.enterprisecreditsystem.service.CreditRateService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class CreditRateController {
    @Resource
    private CreditRateService rateService;

    /**
     * 获取企业信用评定列表
     *
     * @param page     页码
     * @param pageSize 页大小
     * @param keyword  搜索关键词
     * @param ruleId   规则id
     * @return 企业信用评定列表
     */
    @GetMapping("/EnterpriseCreditRateList/getData")
    public List<CreditRate> getEnterpriseData(Integer page, Integer pageSize, String keyword, String ruleId) {
        return rateService.getEnterpriseData(page, pageSize, keyword, ruleId);
    }

    /**
     * 获取个人信用评定列表
     *
     * @param page     页码
     * @param pageSize 页大小
     * @param keyword  搜索关键词
     * @param ruleId   规则id
     * @return 个人信用评定列表
     */
    @GetMapping("/PersonalCreditRateList/getData")
    public List<CreditRate> getPersonData(Integer page, Integer pageSize, String keyword, String ruleId) {
        return rateService.getPersonData(page, pageSize, keyword, ruleId);
    }

    @PostMapping("/PersonalCreditRateList/addData")
    public Boolean addPersonData(@RequestBody CreditRate form) {
        return rateService.addPersonData(form);
    }

    @PostMapping("/EnterpriseCreditRateList/addData")
    public Boolean addEnterpriseData(@RequestBody CreditRate form) {
        return rateService.addEnterpriseData(form);
    }
}
