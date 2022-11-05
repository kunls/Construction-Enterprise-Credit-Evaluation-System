package com.lxk.enterprisecreditsystem.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lxk.enterprisecreditsystem.domain.BlacklistRecord;
import com.lxk.enterprisecreditsystem.mapper.BlacklistRecordMapper;
import com.lxk.enterprisecreditsystem.service.BlacklistRecordService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author mia
 * @description 针对表【blacklist_record_table(黑名单操作记录)】的数据库操作Service实现
 * @createDate 2022-10-30 19:59:05
 */
@Service
public class BlacklistRecordServiceImpl extends ServiceImpl<BlacklistRecordMapper, BlacklistRecord>
        implements BlacklistRecordService {
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
        LambdaQueryWrapper<BlacklistRecord> wrapper = new LambdaQueryWrapper<>();
        //1.准备分页
        Page<BlacklistRecord> pages = new Page<>(page, pageSize);
        //2.是否携带关键字
        if (keyword != null && !keyword.equals("")) {
            //2.1根据名称和编号查询
            wrapper.like(BlacklistRecord::getName, keyword).or().like(BlacklistRecord::getOpId, keyword);
        }
        //3.查询
        Page<BlacklistRecord> result = this.page(pages, wrapper);
        return result.getRecords();
    }
}




