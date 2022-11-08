package com.lxk.enterprisecreditsystem.service.searchStrategy;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lxk.enterprisecreditsystem.enums.SearchStrategyEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * 查询策略上下文
 */
@Slf4j
@Component
public class SearchStrategyContext {
    @Resource
    private SearchStrategyFactory searchStrategyFactory;

    /**
     * 根据对应策略执行查询
     *
     * @param searchStrategyEnum 查询策略
     * @param page               页码
     * @param pageSize           页大小
     * @param keyword            查询关键词
     * @param service            数据库操作服务
     * @param <T>                查询对象实体类型
     * @return 查询结果
     */
    public <T> List<T> searchHandle(SearchStrategyEnum searchStrategyEnum, Integer page, Integer pageSize, String keyword, Integer role, Long ruleId, IService<T> service) {
        SearchStrategy searchStrategy = searchStrategyFactory.getSearchStrategy(searchStrategyEnum);
        return searchStrategy.getList(page, pageSize, keyword, role, ruleId, service);
    }
}
