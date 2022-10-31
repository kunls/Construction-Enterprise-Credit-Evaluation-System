package com.lxk.enterprisecreditsystem.controller;

import com.lxk.enterprisecreditsystem.domain.Blacklist;
import com.lxk.enterprisecreditsystem.service.BlacklistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BlacklistController {
    @Autowired
    private BlacklistService blacklistService;

    /**
     * 获取个人黑名单列表
     * @param page
     * @param pageSize
     * @param keyword
     * @param idCard
     * @return
     */
    @GetMapping("/PersonalBlacklist/getData")
    public List<Blacklist> getPersonBlacklist(Integer page, Integer pageSize, String keyword, String idCard) {
        return blacklistService.getPersonBlacklist(page, pageSize, keyword, idCard);
    }

    /**
     * 获取企业黑名单列表
     * @param page
     * @param pageSize
     * @param keyword
     * @param idCard
     * @return
     */
    @GetMapping("/EnterpriseBlacklist/getData")
    public List<Blacklist> getEnterpriseBlacklist(Integer page, Integer pageSize, String keyword, String idCard) {
        return blacklistService.getEnterpriseBlacklist(page, pageSize, keyword, idCard);
    }

    /**
     * 获取个人黑名单历史记录
     * @param page
     * @param pageSize
     * @param keyword
     * @param idCard
     * @return
     */
    @GetMapping("/PersonalBlacklistHistory/getData")
    public List<Blacklist> getPersonHistory(Integer page, Integer pageSize, String keyword, String idCard) {
        return blacklistService.getPersonHistory(page, pageSize, keyword, idCard);
    }

    /**
     * 获取企业黑名单历史记录
     * @param page
     * @param pageSize
     * @param keyword
     * @param idCard
     * @return
     */
    @GetMapping("/EnterpriseBlacklistHistory/getData")
    public List<Blacklist> getEnterpriseHistory(Integer page, Integer pageSize, String keyword, String idCard) {
        return blacklistService.getEnterpriseHistory(page, pageSize, keyword, idCard);
    }
}