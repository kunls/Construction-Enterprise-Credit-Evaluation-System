package com.lxk.enterprisecreditsystem.service;

import com.lxk.enterprisecreditsystem.domain.RateRule;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
* @author mia
* @description 针对表【rate_rule_table(信用评价标准设定)】的数据库操作Service
* @createDate 2022-10-30 19:59:05
*/
public interface RateRuleService extends IService<RateRule> {

    List<RateRule> getData(Integer page, Integer pageSize, String keyword);
}
