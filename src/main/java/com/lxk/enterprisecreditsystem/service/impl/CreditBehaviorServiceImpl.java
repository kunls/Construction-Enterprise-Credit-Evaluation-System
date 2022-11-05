package com.lxk.enterprisecreditsystem.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lxk.enterprisecreditsystem.domain.CreditBehavior;
import com.lxk.enterprisecreditsystem.dto.creditListDto.EnterpriseDTO;
import com.lxk.enterprisecreditsystem.dto.creditListDto.PersonDTO;
import com.lxk.enterprisecreditsystem.mapper.CreditBehaviorMapper;
import com.lxk.enterprisecreditsystem.service.CreditBehaviorService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author mia
 * @description 针对表【credit_behavior_table(（个人、企业）信用行为列表（县级、市级）)】的数据库操作Service实现
 * @createDate 2022-10-30 19:59:05
 */
@Service
public class CreditBehaviorServiceImpl extends ServiceImpl<CreditBehaviorMapper, CreditBehavior>
        implements CreditBehaviorService {

    @Override
    public List<PersonDTO> getPersonData(Integer page, Integer pageSize, String keyword) {
        LambdaQueryWrapper<CreditBehavior> wrapper = new LambdaQueryWrapper<>();
        //1.分页
        Page<CreditBehavior> pages = new Page<>(page, pageSize);
        //2.是否携带关键字
        if (keyword != null && !keyword.equals("")) {
            wrapper.like(CreditBehavior::getCreditId, keyword).or().like(CreditBehavior::getFromEnterprise, keyword);
        }
        wrapper.eq(CreditBehavior::getRole, 1);
        //3.查询
        Page<CreditBehavior> result = this.page(pages, wrapper);
        //4.转成dto
        ArrayList<PersonDTO> dtoList = new ArrayList<>();
        for (CreditBehavior record : result.getRecords()) {
            PersonDTO personDTO = new PersonDTO();
            BeanUtils.copyProperties(record, personDTO);
            dtoList.add(personDTO);
        }
        //5.返回结果
        return dtoList;
    }

    @Override
    public List<EnterpriseDTO> getEnterpriseData(Integer page, Integer pageSize, String keyword) {
        LambdaQueryWrapper<CreditBehavior> wrapper = new LambdaQueryWrapper<>();
        //1.分页
        Page<CreditBehavior> pages = new Page<>(page, pageSize);
        //2.是否携带关键字
        if (keyword != null && !keyword.equals("")) {
            wrapper.like(CreditBehavior::getCreditId, keyword).or().like(CreditBehavior::getFromEnterprise, keyword);
        }
        wrapper.eq(CreditBehavior::getRole, 2);
        //3.查询
        Page<CreditBehavior> result = this.page(pages, wrapper);
        //4.转成dto
        ArrayList<EnterpriseDTO> dtoList = new ArrayList<>();
        for (CreditBehavior record : result.getRecords()) {
            EnterpriseDTO enterpriseDTO = new EnterpriseDTO();
            BeanUtils.copyProperties(record, enterpriseDTO);
            dtoList.add(enterpriseDTO);
        }
        //5.返回结果
        return dtoList;
    }
}




