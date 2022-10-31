package com.lxk.enterprisecreditsystem.service;

import com.lxk.enterprisecreditsystem.domain.BlacklistRecord;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
* @author mia
* @description 针对表【blacklist_record_table(黑名单操作记录)】的数据库操作Service
* @createDate 2022-10-30 19:59:05
*/
public interface BlacklistRecordService extends IService<BlacklistRecord> {

    List<BlacklistRecord> getRecord(Integer page, Integer pageSize, String keyword);
}
