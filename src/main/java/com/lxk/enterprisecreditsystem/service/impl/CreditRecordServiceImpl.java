package com.lxk.enterprisecreditsystem.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lxk.enterprisecreditsystem.domain.CreditRecord;
import com.lxk.enterprisecreditsystem.enums.SearchStrategyEnum;
import com.lxk.enterprisecreditsystem.mapper.CreditRecordMapper;
import com.lxk.enterprisecreditsystem.service.CreditRecordService;
import com.lxk.enterprisecreditsystem.service.searchStrategy.SearchStrategyContext;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author mia
 * @description 针对表【credit_record_table(（个人、企业）信用行为评定记录)】的数据库操作Service实现
 * @createDate 2022-10-30 19:59:05
 */
@Service
public class CreditRecordServiceImpl extends ServiceImpl<CreditRecordMapper, CreditRecord>
        implements CreditRecordService {
    @Resource
    private SearchStrategyContext searchStrategyContext;

    /**
     * 获取个人信用记录
     *
     * @param page     页码
     * @param pageSize 页大小
     * @param keyword  查询关键词
     * @return 查询结果
     */
    @Override
    public List<CreditRecord> getPersonData(Integer page, Integer pageSize, String keyword) {
        return searchStrategyContext.searchHandle(SearchStrategyEnum.SEARCH_BY_ID_OR_NAME, page, pageSize, keyword, 1, null, this);
    }

    /**
     * 获取企业信用记录
     *
     * @param page     页码
     * @param pageSize 页大小
     * @param keyword  查询关键词
     * @return 查询结果
     */
    @Override
    public List<CreditRecord> getEnterpriseData(Integer page, Integer pageSize, String keyword) {
        return searchStrategyContext.searchHandle(SearchStrategyEnum.SEARCH_BY_ID_OR_NAME, page, pageSize, keyword, 2, null, this);
    }

    /**
     * 获取记录列表
     *
     * @param page     页码
     * @param pageSize 页大小
     * @param keyword  搜索关键词
     * @param role     企业or个人
     * @return 企业or个人信用评定记录列表
     */
    private List<CreditRecord> getRecordList(Integer page, Integer pageSize, String keyword, Integer role) {
        LambdaQueryWrapper<CreditRecord> wrapper = new LambdaQueryWrapper<>();
        //1.准备分页
        Page<CreditRecord> pages = new Page<>(page, pageSize);
        //2.是否携带关键字
        if (keyword != null && !keyword.equals("")) {
            wrapper.like(CreditRecord::getName, keyword).or().like(CreditRecord::getIdCard, keyword);
        }
        wrapper.eq(CreditRecord::getRole, role);
        //3.检查用户身份
        //Todo 不确定哪层身份可见
        //4.查询
        Page<CreditRecord> result = this.page(pages, wrapper);
        return result.getRecords();
    }
}




