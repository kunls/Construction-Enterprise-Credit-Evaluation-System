package com.lxk.enterprisecreditsystem.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * （个人、企业）黑名单列表、（个人、企业）黑名单历史记录
 *
 * @TableName blacklist_table
 */
@TableName(value = "blacklist_table")
@Data
public class Blacklist implements Serializable {
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
     * 统一社会信用代码or身份证
     */
    private String idCard;

    /**
     * 失信行为
     */
    private String content;

    /**
     * 执行时间
     */
    private Date execTime;

    /**
     * 结束时间
     */
    private Date finishTime;

    /**
     * 列入部门
     */
    private String passDep;

    /**
     * 列入人员
     */
    private String passPerson;

    /**
     * 行政区划
     */
    private String address;

    /**
     * 列入时间
     */
    private Date passTime;

    /**
     * 1个人2企业
     */
    private Integer role;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}