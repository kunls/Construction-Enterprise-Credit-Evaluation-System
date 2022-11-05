package com.lxk.enterprisecreditsystem.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * （个人、企业）信用行为评定记录
 *
 * @TableName credit_record_table
 */
@TableName(value = "credit_record_table")
@Data
public class CreditRecord implements Serializable {
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
     * 身份证号or统一社会信用代码
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
     * 办结日期
     */
    private Date finishDate;

    /**
     * 状态
     */
    private String status;

    /**
     * 1个人2企业
     */
    private Integer role;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}