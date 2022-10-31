package com.lxk.enterprisecreditsystem.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lxk.enterprisecreditsystem.domain.RateNorm;
import com.lxk.enterprisecreditsystem.service.RateNormService;
import com.lxk.enterprisecreditsystem.mapper.RateNormMapper;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author mia
* @description 针对表【rate_norm_table(信用评价标准管理)】的数据库操作Service实现
* @createDate 2022-10-30 19:59:05
*/
@Service
public class RateNormServiceImpl extends ServiceImpl<RateNormMapper, RateNorm>
    implements RateNormService{
    /**
     * 获取信用评价标准管理列表
     * @param page
     * @param pageSize
     * @param keyword
     * @return
     */
    @Override
    public List<RateNorm> getData(Integer page, Integer pageSize, String keyword) {
        LambdaQueryWrapper<RateNorm> wrapper = new LambdaQueryWrapper<>();
        //1.准备分页
        Page<RateNorm> pages = new Page<>();
        //2.是否携带关键字
        if (keyword != null && keyword != "") {
            //2.根据评价指标和评分分类查询
            wrapper.like(RateNorm::getNorm, keyword).or().like(RateNorm::getClassification, keyword);
        }
        //3.查询
        Page<RateNorm> result = this.page(pages, wrapper);
        return result.getRecords();
    }
}




