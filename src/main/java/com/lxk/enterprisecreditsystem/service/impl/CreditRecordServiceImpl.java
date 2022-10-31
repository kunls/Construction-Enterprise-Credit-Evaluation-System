package com.lxk.enterprisecreditsystem.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lxk.enterprisecreditsystem.domain.CreditRecord;
import com.lxk.enterprisecreditsystem.service.CreditRecordService;
import com.lxk.enterprisecreditsystem.mapper.CreditRecordMapper;
import org.springframework.stereotype.Service;

/**
* @author mia
* @description 针对表【credit_record_table(（个人、企业）信用行为评定记录)】的数据库操作Service实现
* @createDate 2022-10-30 19:59:05
*/
@Service
public class CreditRecordServiceImpl extends ServiceImpl<CreditRecordMapper, CreditRecord>
    implements CreditRecordService{

}




