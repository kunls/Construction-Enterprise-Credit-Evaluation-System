package com.lxk.enterprisecreditsystem.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lxk.enterprisecreditsystem.domain.RateNorm;
import com.lxk.enterprisecreditsystem.domain.RateRule;
import com.lxk.enterprisecreditsystem.service.RateRuleService;
import com.lxk.enterprisecreditsystem.mapper.RateRuleMapper;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author mia
* @description 针对表【rate_rule_table(信用评价标准设定)】的数据库操作Service实现
* @createDate 2022-10-30 19:59:05
*/
@Service
public class RateRuleServiceImpl extends ServiceImpl<RateRuleMapper, RateRule>
    implements RateRuleService{
    /**
     * 获取信用评价规则设定列表
     * @param page
     * @param pageSize
     * @param keyword
     * @return
     */
    @Override
    public List<RateRule> getData(Integer page, Integer pageSize, String keyword) {
        LambdaQueryWrapper<RateRule> wrapper = new LambdaQueryWrapper<>();
        //1.准备分页
        Page<RateRule> pages = new Page<>();
        //2.是否携带关键字
        if (keyword != null && keyword != "") {
            //2.根据规则名称和信用类型查询
            wrapper.like(RateRule::getName, keyword).or().like(RateRule::getType, keyword);
        }
        //Todo 不确定对哪层可见
        //3.查询
        Page<RateRule> result = this.page(pages, wrapper);
        return result.getRecords();
    }
}




