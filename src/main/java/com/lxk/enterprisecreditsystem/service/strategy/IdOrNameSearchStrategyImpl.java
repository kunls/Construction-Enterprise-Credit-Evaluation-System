package com.lxk.enterprisecreditsystem.service.strategy;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("idOrNameSearchStrategy")
public class IdOrNameSearchStrategyImpl implements SearchStrategy {
    /**
     * 根据id和名称模糊查询
     *
     * @param page     页码
     * @param pageSize 页大小
     * @param keyword  查询关键词
     * @param service  数据库操作对象
     * @param <T>      查询对象实体类型
     * @return 查询结果
     */
    @Override
    public <T> List<T> getList(Integer page, Integer pageSize, String keyword, Integer role, IService<T> service) {
        QueryWrapper<T> wrapper = new QueryWrapper<>();
        //1.准备分页
        Page<T> tPage = new Page<>(page, pageSize);
        //2.根据角色查询
        wrapper.eq("role", role);
        //2.1根据id和名称模糊查询
        wrapper.like("id_card", keyword);
        //3.查询结果
        Page<T> result = service.page(tPage, wrapper);
        return result.getRecords();
    }
}
