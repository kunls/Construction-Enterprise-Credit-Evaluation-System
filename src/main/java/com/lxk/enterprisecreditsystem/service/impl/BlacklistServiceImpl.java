package com.lxk.enterprisecreditsystem.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lxk.enterprisecreditsystem.domain.Blacklist;
import com.lxk.enterprisecreditsystem.enums.SearchStrategyEnum;
import com.lxk.enterprisecreditsystem.mapper.BlacklistMapper;
import com.lxk.enterprisecreditsystem.service.BlacklistService;
import com.lxk.enterprisecreditsystem.service.searchStrategy.SearchStrategyContext;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author mia
 * @description 针对表【blacklist_table(（个人、企业）黑名单列表、（个人、企业）黑名单历史记录)】的数据库操作Service实现
 * @createDate 2022-10-30 19:59:05
 */
@Service
public class BlacklistServiceImpl extends ServiceImpl<BlacklistMapper, Blacklist>
        implements BlacklistService {
    @Resource
    private SearchStrategyContext searchStrategyContext;

    @Override
    public List<Blacklist> getPersonBlacklist(Integer page, Integer pageSize, String keyword) {
        return searchStrategyContext.searchHandle(SearchStrategyEnum.SEARCH_BY_ID_OR_NAME, page, pageSize, keyword, 1, null, this);
    }

    @Override
    public List<Blacklist> getEnterpriseBlacklist(Integer page, Integer pageSize, String keyword) {
        return searchStrategyContext.searchHandle(SearchStrategyEnum.SEARCH_BY_ID_OR_NAME, page, pageSize, keyword, 2, null, this);
    }

    @Override
    public List<Blacklist> getPersonHistory(Integer page, Integer pageSize, String keyword) {
        return searchStrategyContext.searchHandle(SearchStrategyEnum.SEARCH_BY_ID_OR_NAME, page, pageSize, keyword, 1, null, this);
    }

    @Override
    public List<Blacklist> getEnterpriseHistory(Integer page, Integer pageSize, String keyword) {
        return searchStrategyContext.searchHandle(SearchStrategyEnum.SEARCH_BY_ID_OR_NAME, page, pageSize, keyword, 2, null, this);
    }

    @Override
    public Boolean addPersonData(Blacklist form) {
        if (form == null) {
            return false;
        }
        return this.save(form);
    }

    @Override
    public Boolean addEnterpriseData(Blacklist form) {
        if (form == null) {
            return false;
        }
        return this.save(form);
    }
}




