package com.lxk.enterprisecreditsystem.controller;

import com.lxk.enterprisecreditsystem.domain.RateNorm;
import com.lxk.enterprisecreditsystem.domain.RateRule;
import com.lxk.enterprisecreditsystem.service.RateNormService;
import com.lxk.enterprisecreditsystem.service.RateRuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RateNormController {
    @Autowired
    private RateNormService rateNormService;
    @Autowired
    private RateRuleService rateRuleService;

    /**
     * 获取信用评价标准管理列表
     *
     * @param page
     * @param pageSize
     * @param keyword
     * @return
     */
    @GetMapping("/RateNorm/getData")
    public List<RateNorm> getNormData(Integer page, Integer pageSize, String keyword) {
        return rateNormService.getData(page, pageSize, keyword);
    }

    /**
     * 获取信用评价规则设定列表
     *
     * @param page
     * @param pageSize
     * @param keyword
     * @return
     */
    @GetMapping("/RateRule/getData")
    public List<RateRule> getRuleData(Integer page, Integer pageSize, String keyword) {
        return rateRuleService.getData(page, pageSize, keyword);
    }
}
