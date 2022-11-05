package com.lxk.enterprisecreditsystem.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * （个人、企业）信用行为评定列表（企业，县级，市级）
 *
 * @TableName credit_rate_table
 */
@TableName(value = "credit_rate_table")
@Data
public class CreditRate implements Serializable {
    /**
     *
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 名称
     */
    private String name;

    /**
     * 身份证号
     */
    private String idCard;

    /**
     * 评分分类
     */
    private String category;

    /**
     * 评分标准
     */
    private String norm;

    /**
     * 奖惩分数
     */
    private Integer score;

    /**
     * 处理人员
     */
    private String handler;

    /**
     * 处理部门
     */
    private String handleDep;

    /**
     * 行政区划
     */
    private String address;

    /**
     * 处理时间
     */
    private LocalDateTime handleTime;

    /**
     * 状态
     */
    private String status;

    /**
     * 规则id
     */
    private Long ruleId;

    /**
     * 1代表企业2代表县级3代表市级
     */
    private Integer flag;

    /**
     * 1代表个人2代表企业
     */
    private Integer role;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}