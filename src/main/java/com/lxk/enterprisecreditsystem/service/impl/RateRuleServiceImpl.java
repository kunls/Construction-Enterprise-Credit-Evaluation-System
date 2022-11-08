package com.lxk.enterprisecreditsystem.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lxk.enterprisecreditsystem.domain.RateRule;
import com.lxk.enterprisecreditsystem.enums.SearchStrategyEnum;
import com.lxk.enterprisecreditsystem.mapper.RateRuleMapper;
import com.lxk.enterprisecreditsystem.service.RateRuleService;
import com.lxk.enterprisecreditsystem.service.searchStrategy.SearchStrategyContext;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author mia
 * @description 针对表【rate_rule_table(信用评价标准设定)】的数据库操作Service实现
 * @createDate 2022-10-30 19:59:05
 */
@Service
public class RateRuleServiceImpl extends ServiceImpl<RateRuleMapper, RateRule>
        implements RateRuleService {
    @Resource
    private SearchStrategyContext searchStrategyContext;

    /**
     * 获取信用评价规则设定列表
     *
     * @param page     页码
     * @param pageSize 页大小
     * @param keyword  搜索关键词
     * @return 信用评价规则设定列表
     */
    @Override
    public List<RateRule> getData(Integer page, Integer pageSize, String keyword) {
        return searchStrategyContext.searchHandle(SearchStrategyEnum.SEARCH_BY_NAME, page, pageSize, keyword, null, null, this);
    }
}




