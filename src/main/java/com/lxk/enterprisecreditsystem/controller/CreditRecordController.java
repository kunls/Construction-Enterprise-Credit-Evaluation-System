package com.lxk.enterprisecreditsystem.controller;

import com.lxk.enterprisecreditsystem.domain.CreditRecord;
import com.lxk.enterprisecreditsystem.service.CreditRecordService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class CreditRecordController {
    @Resource
    private CreditRecordService recordService;

    /**
     * 获取个人信用评定列表
     *
     * @param page     页码
     * @param pageSize 页大小
     * @param keyword  搜索关键词
     * @return 个人信用评定列表
     */
    @GetMapping("/PersonalCreditRateRecord/getData")
    public List<CreditRecord> getPersonData(Integer page, Integer pageSize, String keyword) {
        return recordService.getPersonData(page, pageSize, keyword);
    }

    /**
     * 企业信用评定列表
     *
     * @param page     页码
     * @param pageSize 页大小
     * @param keyword  搜索关键词
     * @return 企业信用评定列表
     */
    @GetMapping("/EnterpriseCreditRateRecord/getData")
    public List<CreditRecord> getEnterpriseData(Integer page, Integer pageSize, String keyword) {
        return recordService.getEnterpriseData(page, pageSize, keyword);
    }
}
