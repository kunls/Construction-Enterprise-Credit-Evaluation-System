package com.lxk.enterprisecreditsystem.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * 信用评价标准管理
 *
 * @TableName rate_norm_table
 */
@TableName(value = "rate_norm_table")
@Data
public class RateNorm implements Serializable {
    /**
     *
     */
    @TableId
    private Long id;

    /**
     * 评分分类
     */
    private String classification;

    /**
     * 评分标准
     */
    private String norm;

    /**
     * 输入方式
     */
    private String input;

    /**
     * 分数区间
     */
    private String scoreRange;

    /**
     * 分数上限
     */
    private Integer upperLimit;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}