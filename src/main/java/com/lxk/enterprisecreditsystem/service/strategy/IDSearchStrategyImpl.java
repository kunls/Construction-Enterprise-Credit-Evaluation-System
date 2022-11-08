package com.lxk.enterprisecreditsystem.service.strategy;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("idSearchStrategy")
public class IDSearchStrategyImpl implements SearchStrategy {
    @Override
    public <T> List<T> getList(Integer page, Integer pageSize, String keyword, Integer role, IService<T> service) {
        QueryWrapper<T> wrapper = new QueryWrapper<>();
        //1.准备分页
        Page<T> tPage = new Page<>(page, pageSize);
        //2.根据id模糊查询
        wrapper.like("id_card", keyword);
        //3.查询结果
        Page<T> result = service.page(tPage, wrapper);
        return result.getRecords();
    }
}
