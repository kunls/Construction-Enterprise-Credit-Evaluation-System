package com.lxk.enterprisecreditsystem.enums;

import lombok.Getter;

@Getter
public enum SearchStrategyEnum {
    SEARCH_BY_NAME("name", "nameSearchStrategy", "根据名称查询"),
    SEARCH_BY_ID("id", "idSearchStrategy", "根据id查询"),
    SEARCH_BY_ID_OR_NAME("id_or_name", "idOrNameSearchStrategy", "根据id或名称查询");
    /**
     * 查询策略code
     */
    private final String code;
    /**
     * bean名称
     */
    private final String className;

    /**
     * 信息
     */
    private final String info;

    SearchStrategyEnum(String code, String className, String info) {
        this.code = code;
        this.className = className;
        this.info = info;
    }
}
