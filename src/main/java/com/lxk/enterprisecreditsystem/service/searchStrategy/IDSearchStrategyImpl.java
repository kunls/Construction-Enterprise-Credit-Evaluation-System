package com.lxk.enterprisecreditsystem.service.searchStrategy;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("idSearchStrategy")
public class IDSearchStrategyImpl implements SearchStrategy {
    @Override
    public <T> List<T> getList(Integer page, Integer pageSize, String keyword, Integer role, Long ruleId, IService<T> service) {
        QueryWrapper<T> wrapper = new QueryWrapper<>();
        //1.准备分页
        Page<T> tPage = new Page<>(page, pageSize);
        //2.根据角色查询
        if (role != null) {
            wrapper.eq("role", role);
        }
        //2.1根据规则id查询
        if (ruleId != null) {
            wrapper.eq("ruleId", ruleId);
        }
        //2.2根据id模糊查询
        if (keyword != null && !keyword.equals("")) {
            wrapper.like("id_card", keyword);
        }
        //3.查询结果
        Page<T> result = service.page(tPage, wrapper);
        return result.getRecords();
    }
}
