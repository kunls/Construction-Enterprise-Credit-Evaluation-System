package com.lxk.enterprisecreditsystem.controller;

import com.lxk.enterprisecreditsystem.domain.RateNorm;
import com.lxk.enterprisecreditsystem.domain.RateRule;
import com.lxk.enterprisecreditsystem.service.RateNormService;
import com.lxk.enterprisecreditsystem.service.RateRuleService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class RateNormController {
    @Resource
    private RateNormService rateNormService;
    @Resource
    private RateRuleService rateRuleService;

    /**
     * 获取信用评价标准管理列表
     *
     * @param page     页码
     * @param pageSize 页大小
     * @param keyword  搜索关键词
     * @return 信用评价标准管理列表
     */
    @GetMapping("/RateNorm/getData")
    public List<RateNorm> getNormData(Integer page, Integer pageSize, String keyword) {
        return rateNormService.getData(page, pageSize, keyword);
    }

    /**
     * 获取信用评价规则设定列表
     *
     * @param page     页码
     * @param pageSize 页大小
     * @param keyword  搜索关键词
     * @return 信用评价规则设定列表
     */
    @GetMapping("/RateRule/getData")
    public List<RateRule> getRuleData(Integer page, Integer pageSize, String keyword) {
        return rateRuleService.getData(page, pageSize, keyword);
    }
}
