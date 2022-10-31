package com.lxk.enterprisecreditsystem.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lxk.enterprisecreditsystem.domain.BlacklistRecord;
import com.lxk.enterprisecreditsystem.service.BlacklistRecordService;
import com.lxk.enterprisecreditsystem.mapper.BlacklistRecordMapper;
import org.springframework.stereotype.Service;

/**
* @author mia
* @description 针对表【blacklist_record_table(黑名单操作记录)】的数据库操作Service实现
* @createDate 2022-10-30 19:59:05
*/
@Service
public class BlacklistRecordServiceImpl extends ServiceImpl<BlacklistRecordMapper, BlacklistRecord>
    implements BlacklistRecordService{

}




