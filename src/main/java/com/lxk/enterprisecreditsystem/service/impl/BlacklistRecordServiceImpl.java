package com.lxk.enterprisecreditsystem.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lxk.enterprisecreditsystem.domain.BlacklistRecord;
import com.lxk.enterprisecreditsystem.enums.SearchStrategyEnum;
import com.lxk.enterprisecreditsystem.mapper.BlacklistRecordMapper;
import com.lxk.enterprisecreditsystem.service.BlacklistRecordService;
import com.lxk.enterprisecreditsystem.service.searchStrategy.SearchStrategyContext;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author mia
 * @description 针对表【blacklist_record_table(黑名单操作记录)】的数据库操作Service实现
 * @createDate 2022-10-30 19:59:05
 */
@Service
public class BlacklistRecordServiceImpl extends ServiceImpl<BlacklistRecordMapper, BlacklistRecord>
        implements BlacklistRecordService {
    @Resource
    private SearchStrategyContext searchStrategyContext;

    /**
     * 获取黑名单操作记录
     *
     * @param page     页码
     * @param pageSize 页大小
     * @param keyword  搜索关键词
     * @return 黑名单操作记录列表
     */
    @Override
    public List<BlacklistRecord> getRecord(Integer page, Integer pageSize, String keyword) {
        //根据名称查询
        return searchStrategyContext.searchHandle(SearchStrategyEnum.SEARCH_BY_NAME, page, pageSize, keyword, null, null, this);
    }
}




