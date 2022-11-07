package com.lxk.enterprisecreditsystem.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lxk.enterprisecreditsystem.domain.TotalBlacklist;

import java.util.List;

/**
 * @author mia
 * @description 针对表【total_blacklist_table(总黑名单列表)】的数据库操作Service
 * @createDate 2022-10-30 19:59:05
 */
public interface TotalBlacklistService extends IService<TotalBlacklist> {

    List<TotalBlacklist> getTotalBlacklist(Integer page, Integer pageSize, String keyword);

    Boolean addBlacklistData(TotalBlacklist form);
}
