package com.lxk.enterprisecreditsystem.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 总黑名单列表
 *
 * @TableName total_blacklist_table
 */
@TableName(value = "total_blacklist_table")
@Data
public class TotalBlacklist implements Serializable {
    /**
     *
     */
    @TableId
    private Long id;

    /**
     * 单位名称
     */
    private String name;

    /**
     * 统一社会信用代码
     */
    private String creditCode;

    /**
     * 处罚方式
     */
    private String punish;

    /**
     * 执法人员
     */
    private String passPerson;

    /**
     * 执法部门
     */
    private String passDepartment;

    /**
     * 行政区划
     */
    private String address;

    /**
     * 处罚日期
     */
    private Date punishDate;

    /**
     * 行为描述
     */
    private String content;

    /**
     * 备注
     */
    private String remark;

    /**
     * 规则Id
     */
    private Long ruleId;

    /**
     * 细则Id
     */
    private Long rateNormId;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}