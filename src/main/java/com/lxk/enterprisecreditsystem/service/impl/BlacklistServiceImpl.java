package com.lxk.enterprisecreditsystem.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lxk.enterprisecreditsystem.domain.Blacklist;
import com.lxk.enterprisecreditsystem.service.BlacklistService;
import com.lxk.enterprisecreditsystem.mapper.BlacklistMapper;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author mia
* @description 针对表【blacklist_table(（个人、企业）黑名单列表、（个人、企业）黑名单历史记录)】的数据库操作Service实现
* @createDate 2022-10-30 19:59:05
*/
@Service
public class BlacklistServiceImpl extends ServiceImpl<BlacklistMapper, Blacklist>
    implements BlacklistService{

    @Override
    public List<Blacklist> getPersonBlacklist(Integer page, Integer pageSize, String keyword, String idCard) {
        return getBlacklist(page, pageSize, keyword,1);
    }
    @Override
    public List<Blacklist> getEnterpriseBlacklist(Integer page, Integer pageSize, String keyword, String idCard) {
        return getBlacklist(page, pageSize, keyword, 2);
    }

    @Override
    public List<Blacklist> getPersonHistory(Integer page, Integer pageSize, String keyword, String idCard) {
        return getBlacklist(page, pageSize, keyword, 1);
    }

    @Override
    public List<Blacklist> getEnterpriseHistory(Integer page, Integer pageSize, String keyword, String idCard) {
        return getBlacklist(page, pageSize, keyword, 2);
    }

    /**
     * 获取黑名单
     * @param page
     * @param pageSize
     * @param keyword
     * @param val
     * @return List<Blacklist>
     */
    private List<Blacklist> getBlacklist(Integer page, Integer pageSize, String keyword,Integer val) {
        LambdaQueryWrapper<Blacklist> wrapper = new LambdaQueryWrapper<>();
        //1.准备分页
        Page<Blacklist> pages = new Page<>(page, pageSize);
        //2.是否携带关键字
        if (keyword != null && keyword != "") {
            wrapper.like(Blacklist::getName, keyword).or().like(Blacklist::getIdCard, keyword);
        }
        wrapper.eq(Blacklist::getRole, val);
        //3.查询
        Page<Blacklist> result = this.page(pages, wrapper);
        //4.返回结果
        return result.getRecords();
    }
}




