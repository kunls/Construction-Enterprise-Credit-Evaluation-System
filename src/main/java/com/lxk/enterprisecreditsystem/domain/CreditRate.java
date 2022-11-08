package com.lxk.enterprisecreditsystem.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * （个人、企业）信用行为评定列表（企业，县级，市级）
 * @TableName credit_rate_table
 */
@TableName(value ="credit_rate_table")
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
     * 完结时间
     */
    private Date finishDate;

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
    private Date handleTime;

    /**
     * 状态
     */
    private String status;

    /**
     * 行为描述
     */
    private String content;

    /**
     * 备注
     */
    private String remark;

    /**
     * 行为时间
     */
    private Date behaviorTime;

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

    /**
     * 附件地址
     */
    private String annexFile;

    /**
     * 企业是否知晓
     */
    private String hasKnown;

    /**
     * 企业是否有异议
     */
    private String hasDissent;

    /**
     * 企业异议备注
     */
    private String entRemark;

    /**
     * 企业异议附件
     */
    private String entAnnexFile;

    /**
     * 办理部门
     */
    private String reviewDep;

    /**
     * 办理人员
     */
    private String reviewPerson;

    /**
     * 县级异议复核结果
     */
    private String reviewResult;

    /**
     * 复核时间
     */
    private Date reviewTime;

    /**
     * 县级异议复核备注
     */
    private String reviewRemark;

    /**
     * 县级初审部门
     */
    private String countyDep;

    /**
     * 县级初审人员
     */
    private String countyPerson;

    /**
     * 县级初审结果
     */
    private String countyVerifyResult;

    /**
     * 县级初审时间
     */
    private Date countyVerifyTime;

    /**
     * 县级初审备注
     */
    private String countyRemark;

    /**
     * 市级审核部门
     */
    private String cityDep;

    /**
     * 市级审核人员
     */
    private String cityPerson;

    /**
     * 市级审核结果
     */
    private String cityVerifyResult;

    /**
     * 市级审核时间
     */
    private Date cityVerifyTime;

    /**
     * 市级审核备注
     */
    private String cityRemark;

    /**
     * 1良好行为2不良行为
     */
    private Integer behaviorType;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}