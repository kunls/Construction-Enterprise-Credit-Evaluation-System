package com.lxk.enterprisecreditsystem.service.searchStrategy;

import com.lxk.enterprisecreditsystem.enums.SearchStrategyEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Map;

/**
 * 查询策略的工厂
 */

@Slf4j
@Component
public class SearchStrategyFactory {
    /**
     * 根据Spring容器自动注入
     */
    @Resource
    private Map<String, SearchStrategy> searchStrategyMap;

    /**
     * 获取对应查询策略
     *
     * @param searchStrategyEnum 查询策略枚举
     * @return 对应查询策略
     */
    public SearchStrategy getSearchStrategy(SearchStrategyEnum searchStrategyEnum) {
        if (!searchStrategyMap.containsKey(searchStrategyEnum.getClassName())) {
            log.error("没有这种查询策略");
            return null;
        }
        return searchStrategyMap.get(searchStrategyEnum.getClassName());
    }
}


