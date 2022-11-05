package com.lxk.enterprisecreditsystem.service;

import com.lxk.enterprisecreditsystem.domain.Blacklist;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
* @author mia
* @description 针对表【blacklist_table(（个人、企业）黑名单列表、（个人、企业）黑名单历史记录)】的数据库操作Service
* @createDate 2022-10-30 19:59:05
*/
public interface BlacklistService extends IService<Blacklist> {

    List<Blacklist> getPersonBlacklist(Integer page, Integer pageSize, String keyword);

    List<Blacklist> getEnterpriseBlacklist(Integer page, Integer pageSize, String keyword);

    List<Blacklist> getPersonHistory(Integer page, Integer pageSize, String keyword, String idCard);

    List<Blacklist> getEnterpriseHistory(Integer page, Integer pageSize, String keyword, String idCard);
}
