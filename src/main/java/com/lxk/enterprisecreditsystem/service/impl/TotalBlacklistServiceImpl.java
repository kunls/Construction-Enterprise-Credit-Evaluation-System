package com.lxk.enterprisecreditsystem.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lxk.enterprisecreditsystem.domain.TotalBlacklist;
import com.lxk.enterprisecreditsystem.enums.SearchStrategyEnum;
import com.lxk.enterprisecreditsystem.mapper.TotalBlacklistMapper;
import com.lxk.enterprisecreditsystem.service.TotalBlacklistService;
import com.lxk.enterprisecreditsystem.service.searchStrategy.SearchStrategyContext;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author mia
 * @description 针对表【total_blacklist_table(总黑名单列表)】的数据库操作Service实现
 * @createDate 2022-10-30 19:59:05
 */
@Service
public class TotalBlacklistServiceImpl extends ServiceImpl<TotalBlacklistMapper, TotalBlacklist>
        implements TotalBlacklistService {
    @Resource
    private SearchStrategyContext searchStrategyContext;

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
        return searchStrategyContext.searchHandle(SearchStrategyEnum.SEARCH_BY_NAME, page, pageSize, keyword, null, null, this);
    }

    @Override
    public Boolean addBlacklistData(TotalBlacklist form) {
        if (form == null) {
            return false;
        }
        return this.save(form);
    }
}




