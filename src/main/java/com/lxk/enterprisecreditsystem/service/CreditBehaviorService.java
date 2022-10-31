package com.lxk.enterprisecreditsystem.service;

import com.lxk.enterprisecreditsystem.domain.CreditBehavior;
import com.baomidou.mybatisplus.extension.service.IService;
import com.lxk.enterprisecreditsystem.dto.creditListDto.EnterpriseDTO;
import com.lxk.enterprisecreditsystem.dto.creditListDto.PersonDTO;

import java.util.List;

/**
* @author mia
* @description 针对表【credit_behavior_table(（个人、企业）信用行为列表（县级、市级）)】的数据库操作Service
* @createDate 2022-10-30 19:59:05
*/
public interface CreditBehaviorService extends IService<CreditBehavior> {

    List<PersonDTO> getPersonData(Integer page, Integer pageSize,String keyword);

    List<EnterpriseDTO> getEnterpriseData(Integer page, Integer pageSize, String keyword);
}
