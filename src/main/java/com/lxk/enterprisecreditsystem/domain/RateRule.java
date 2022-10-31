package com.lxk.enterprisecreditsystem.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 信用评价标准设定
 * @TableName rate_rule_table
 */
@TableName(value ="rate_rule_table")
@Data
public class RateRule implements Serializable {
    /**
     * 
     */
    @TableId
    private Long id;

    /**
     * 规则名称
     */
    private String name;

    /**
     * 信用类型
     */
    private String type;

    /**
     * 适用地区
     */
    private String applicableArea;

    /**
     * 周期
     */
    private String period;

    /**
     * 周期分数上限
     */
    private String periodSocreUpper;

    /**
     * 管理对象
     */
    private String manageObject;

    /**
     * 对象类型
     */
    private String objectType;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}