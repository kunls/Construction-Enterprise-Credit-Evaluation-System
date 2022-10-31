package com.lxk.enterprisecreditsystem.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * （个人、企业）信用行为列表（县级、市级）
 * @TableName credit_behavior_table
 */
@TableName(value ="credit_behavior_table")
@Data
public class CreditBehavior implements Serializable {
    /**
     * 
     */
    @TableId
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
     * 所在企业
     */
    private String fromEnterprise;

    /**
     * 统一社会信用代码
     */
    private String creditId;

    /**
     * 企业地址
     */
    private String address;

    /**
     * 评分分数
     */
    private Integer score;

    /**
     * 评分等级
     */
    private String level;

    /**
     * 企业法人
     */
    private String legalPerson;

    /**
     * 1个人2企业
     */
    private Integer role;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}