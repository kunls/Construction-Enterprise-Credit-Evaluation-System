package com.lxk.enterprisecreditsystem.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * 黑名单操作记录
 *
 * @TableName blacklist_record_table
 */
@TableName(value = "blacklist_record_table")
@Data
public class BlacklistRecord implements Serializable {
    /**
     *
     */
    @TableId
    private Long id;

    /**
     * 姓名
     */
    private String name;

    /**
     * 部门
     */
    private String department;

    /**
     * 操作
     */
    private String operation;

    /**
     * 模块
     */
    private String module;

    /**
     * 主体名称
     */
    private String mainName;

    /**
     * 编号
     */
    private String opId;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}