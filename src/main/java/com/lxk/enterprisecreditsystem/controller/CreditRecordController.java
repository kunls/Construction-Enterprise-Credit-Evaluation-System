package com.lxk.enterprisecreditsystem.controller;

import com.lxk.enterprisecreditsystem.domain.CreditRecord;
import com.lxk.enterprisecreditsystem.service.CreditRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CreditRecordController {
    @Autowired
    private CreditRecordService recordService;

    @GetMapping("/PersonalCreditRateRecord/getData")
    public List<CreditRecord> getPersonData(Integer page, Integer pageSize, String keyword) {
        return recordService.getPersonData(page, pageSize, keyword);
    }

    @GetMapping("/EnterpriseCreditRateRecord/getData")
    public List<CreditRecord> getEnterpriseData(Integer page, Integer pageSize, String keyword) {
        return recordService.getEnterpriseData(page, pageSize, keyword);
    }
}
