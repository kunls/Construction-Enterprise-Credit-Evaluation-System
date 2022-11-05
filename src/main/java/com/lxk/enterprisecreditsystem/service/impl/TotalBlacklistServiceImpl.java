package com.lxk.enterprisecreditsystem.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lxk.enterprisecreditsystem.domain.TotalBlacklist;
import com.lxk.enterprisecreditsystem.mapper.TotalBlacklistMapper;
import com.lxk.enterprisecreditsystem.service.TotalBlacklistService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author mia
 * @description 针对表【total_blacklist_table(总黑名单列表)】的数据库操作Service实现
 * @createDate 2022-10-30 19:59:05
 */
@Service
public class TotalBlacklistServiceImpl extends ServiceImpl<TotalBlacklistMapper, TotalBlacklist>
        implements TotalBlacklistService {
    /**
     * 获取总黑名单列表
     *
     * @param page     页码
     * @param pageSize 页大小
     * @param keyword  搜索关键词
     * @return 总黑名单列表
     */
    @Override
    public List<TotalBlacklist> getTotalBlacklist(Integer page, Integer pageSize, String keyword) {
        LambdaQueryWrapper<TotalBlacklist> wrapper = new LambdaQueryWrapper<>();
        //1.准备分页
        Page<TotalBlacklist> pages = new Page<>(page, pageSize);
        //2.是否携带关键字
        if (keyword != null && !keyword.equals("")) {
            wrapper.like(TotalBlacklist::getName, keyword).or().like(TotalBlacklist::getCreditCode, keyword);
        }
        //3.查询
        Page<TotalBlacklist> result = this.page(pages, wrapper);
        return result.getRecords();
    }
}




