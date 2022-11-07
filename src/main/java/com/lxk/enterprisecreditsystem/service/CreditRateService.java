package com.lxk.enterprisecreditsystem.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lxk.enterprisecreditsystem.domain.CreditRate;

import java.util.List;

/**
 * @author mia
 * @description 针对表【credit_rate_table(（个人、企业）信用行为评定列表（企业，县级，市级）)】的数据库操作Service
 * @createDate 2022-10-30 19:59:05
 */
public interface CreditRateService extends IService<CreditRate> {

    List<CreditRate> getEnterpriseData(Integer page, Integer pageSize, String keyword, String ruleId);

    List<CreditRate> getPersonData(Integer page, Integer pageSize, String keyword, String ruleId);

    Boolean addPersonData(CreditRate form);

    Boolean addEnterpriseData(CreditRate form);
}
