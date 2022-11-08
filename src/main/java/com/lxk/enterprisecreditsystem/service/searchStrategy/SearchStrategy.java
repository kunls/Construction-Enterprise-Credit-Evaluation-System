package com.lxk.enterprisecreditsystem.service.searchStrategy;

import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

public interface SearchStrategy {
    <T> List<T> getList(Integer page, Integer pageSize, String keyword, Integer role, Long ruleId, IService<T> service);
}
