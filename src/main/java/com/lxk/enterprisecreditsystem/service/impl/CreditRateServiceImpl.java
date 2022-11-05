package com.lxk.enterprisecreditsystem.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lxk.enterprisecreditsystem.domain.CreditRate;
import com.lxk.enterprisecreditsystem.dto.creditRateDto.EnterpriseDTO;
import com.lxk.enterprisecreditsystem.dto.creditRateDto.PersonDTO;
import com.lxk.enterprisecreditsystem.mapper.CreditRateMapper;
import com.lxk.enterprisecreditsystem.service.CreditRateService;
import com.lxk.enterprisecreditsystem.utils.UserHolder;
import org.springframework.beans.BeanUtils;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

import static com.lxk.enterprisecreditsystem.utils.RedisConstant.USER_TYPE;

/**
 * @author mia
 * @description 针对表【credit_rate_table(（个人、企业）信用行为评定列表（企业，县级，市级）)】的数据库操作Service实现
 * @createDate 2022-10-30 19:59:05
 */
@Service
public class CreditRateServiceImpl extends ServiceImpl<CreditRateMapper, CreditRate>
        implements CreditRateService {
    @Resource
    private StringRedisTemplate stringRedisTemplate;

    @Override
    public List<CreditRate> getPersonData(Integer page, Integer pageSize, String keyword, String ruleId) {
        return getList(page, pageSize, keyword, ruleId, 1);
    }

    @Override
    public List<CreditRate> getEnterpriseData(Integer page, Integer pageSize, String keyword, String ruleId) {
        return getList(page, pageSize, keyword, ruleId, 2);
    }

    /**
     * 验证用户身份 1代表企业 2代表县级 3代表市级
     *
     * @return 返回用户身份
     */
    private Integer verifyFlag() {
        String flag = stringRedisTemplate.opsForValue().get(USER_TYPE + UserHolder.getUser().getEmail());
        if (flag != null) {
            return Integer.valueOf(flag);
        }
        return 0;
    }

    /**
     * 获取信用列表
     *
     * @param page     页码
     * @param pageSize 页大小
     * @param keyword  搜索关键词
     * @param ruleId   规则id
     * @param role     企业or个人
     * @return 企业or个人信用评定列表
     */
    private List<CreditRate> getList(Integer page, Integer pageSize, String keyword, String ruleId, Integer role) {
        LambdaQueryWrapper<CreditRate> wrapper = new LambdaQueryWrapper<>();
        //1.准备分页
        Page<CreditRate> pages = new Page<>(page, pageSize);
        //2.是否携带关键字
        if (keyword != null && !keyword.equals("")) {
            wrapper.like(CreditRate::getName, keyword).or().like(CreditRate::getIdCard, keyword);
        }
        wrapper.eq(CreditRate::getRole, role);
        //3.是否携带规则
        if (ruleId != null && !ruleId.equals("")) {
            wrapper.eq(CreditRate::getRuleId, ruleId);
        }
        //4.验证登陆者身份
        Integer flag = verifyFlag();
        wrapper.eq(CreditRate::getFlag, flag);
        //4.查询
        Page<CreditRate> result = this.page(pages, wrapper);
        //5.转成dto
        return trans2Dto(role, flag, result);
    }

    /**
     * 将数据库查出的实体对象转为Dto对象
     *
     * @param role   企业or个人
     * @param flag   企业or县级or市级
     * @param result 企业对象列表 or 个人对象列表
     * @return 企业Dto or 个人Dto
     */
    private List<CreditRate> trans2Dto(Integer role, Integer flag, Page<CreditRate> result) {
        ArrayList<CreditRate> dtoList = new ArrayList<>();
        //1.若是企业用户,查找个人
        if (flag.equals(1) && role.equals(1)) {
            for (CreditRate record : result.getRecords()) {
                PersonDTO dto1 = new PersonDTO();
                BeanUtils.copyProperties(record, dto1);
                dtoList.add(dto1);
            }
        }
        //2.若是企业用户,查找企业
        else if (flag.equals(1) && role.equals(2)) {
            for (CreditRate record : result.getRecords()) {
                EnterpriseDTO dto1 = new EnterpriseDTO();
                BeanUtils.copyProperties(record, dto1);
                dtoList.add(dto1);
            }
        }
        //3.若是县级以上用户
        else {
            return result.getRecords();
        }
        return dtoList;
    }
}




