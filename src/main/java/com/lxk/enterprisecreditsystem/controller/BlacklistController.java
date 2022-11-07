package com.lxk.enterprisecreditsystem.controller;

import com.lxk.enterprisecreditsystem.domain.Blacklist;
import com.lxk.enterprisecreditsystem.domain.BlacklistRecord;
import com.lxk.enterprisecreditsystem.domain.TotalBlacklist;
import com.lxk.enterprisecreditsystem.service.BlacklistRecordService;
import com.lxk.enterprisecreditsystem.service.BlacklistService;
import com.lxk.enterprisecreditsystem.service.TotalBlacklistService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class BlacklistController {
    @Resource
    private BlacklistService blacklistService;
    @Resource
    private TotalBlacklistService totalBlacklistService;
    @Resource
    private BlacklistRecordService blacklistRecordService;

    /**
     * 获取个人黑名单列表
     *
     * @param page     页码
     * @param pageSize 页大小
     * @param keyword  搜索关键词
     * @return 个人黑名单列表
     */
    @GetMapping("/PersonalBlacklist/getData")
    public List<Blacklist> getPersonBlacklist(Integer page, Integer pageSize, String keyword) {
        return blacklistService.getPersonBlacklist(page, pageSize, keyword);
    }

    /**
     * 获取企业黑名单列表
     *
     * @param page     页码
     * @param pageSize 页大小
     * @param keyword  搜索关键词
     * @return 企业黑名单列表
     */
    @GetMapping("/EnterpriseBlacklist/getData")
    public List<Blacklist> getEnterpriseBlacklist(Integer page, Integer pageSize, String keyword) {
        return blacklistService.getEnterpriseBlacklist(page, pageSize, keyword);
    }

    /**
     * 获取个人黑名单历史记录
     *
     * @param page     页码
     * @param pageSize 页大小
     * @param keyword  搜索关键词
     * @param idCard   身份证号
     * @return 个人黑名单历史记录
     */
    @GetMapping("/PersonalBlacklistHistory/getData")
    public List<Blacklist> getPersonHistory(Integer page, Integer pageSize, String keyword, String idCard) {
        return blacklistService.getPersonHistory(page, pageSize, keyword, idCard);
    }

    /**
     * 获取企业黑名单历史记录
     *
     * @param page     页码
     * @param pageSize 页大小
     * @param keyword  搜索关键词
     * @param idCard   统一社会信用代码
     * @return 企业黑名单历史记录
     */
    @GetMapping("/EnterpriseBlacklistHistory/getData")
    public List<Blacklist> getEnterpriseHistory(Integer page, Integer pageSize, String keyword, String idCard) {
        return blacklistService.getEnterpriseHistory(page, pageSize, keyword, idCard);
    }

    /**
     * 获取总黑名单列表
     *
     * @param page     页码
     * @param pageSize 页大小
     * @param keyword  搜索关键词
     * @return 总黑名单列表
     */
    @GetMapping("/Blacklist/getTotalBlacklist")
    public List<TotalBlacklist> getTotalBlacklist(Integer page, Integer pageSize, String keyword) {
        return totalBlacklistService.getTotalBlacklist(page, pageSize, keyword);
    }

    /**
     * 获取黑名单操作记录
     *
     * @param page     页码
     * @param pageSize 页大小
     * @param keyword  搜索关键词
     * @return 黑名单记录列表
     */
    @GetMapping("/BlacklistRecord/getRecord")
    public List<BlacklistRecord> getRecord(Integer page, Integer pageSize, String keyword) {
        return blacklistRecordService.getRecord(page, pageSize, keyword);
    }

    /**
     * 增加个人黑名单列表数据
     *
     * @param form 个人表单
     * @return 是否成功
     */
    @PostMapping("/PersonalBlacklist/addData")
    public Boolean addPersonData(@RequestBody Blacklist form) {
        return blacklistService.addPersonData(form);
    }

    /**
     * 增加企业黑名单列表数据
     *
     * @param form 企业表单
     * @return 是否成功
     */
    @PostMapping("/EnterpriseBlacklist/addData")
    public Boolean addEnterpriseData(@RequestBody Blacklist form) {
        return blacklistService.addEnterpriseData(form);
    }

    /**
     * 增加总黑名单数据
     *
     * @param form 表单
     * @return 是否成功
     */
    @PostMapping("/Blacklist/addData")
    public Boolean addBlacklistData(@RequestBody TotalBlacklist form) {
        return totalBlacklistService.addBlacklistData(form);
    }
}
