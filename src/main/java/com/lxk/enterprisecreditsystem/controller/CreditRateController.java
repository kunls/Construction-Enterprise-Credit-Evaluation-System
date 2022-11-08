package com.lxk.enterprisecreditsystem.controller;

import com.lxk.enterprisecreditsystem.domain.CreditRate;
import com.lxk.enterprisecreditsystem.service.CreditRateService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class CreditRateController {
    @Resource
    private CreditRateService rateService;

    /**
     * 获取企业信用评定列表
     *
     * @param page     页码
     * @param pageSize 页大小
     * @param keyword  搜索关键词
     * @param ruleId   规则id
     * @return 企业信用评定列表
     */
    @GetMapping("/EnterpriseCreditRateList/getData")
    public List<CreditRate> getEnterpriseData(Integer page, Integer pageSize, String keyword, Long ruleId) {
        return rateService.getEnterpriseData(page, pageSize, keyword, ruleId);
    }

    /**
     * 获取个人信用评定列表
     *
     * @param page     页码
     * @param pageSize 页大小
     * @param keyword  搜索关键词
     * @param ruleId   规则id
     * @return 个人信用评定列表
     */
    @GetMapping("/PersonalCreditRateList/getData")
    public List<CreditRate> getPersonData(Integer page, Integer pageSize, String keyword, Long ruleId) {
        return rateService.getPersonData(page, pageSize, keyword, ruleId);
    }

    /**
     * 新增个人良好行为评定数据(企业)
     *
     * @param form 个人良好行为表单
     * @return 是否成功
     */
    @PostMapping("/PersonalCreditRateList/enterprise/goodBehavior/addData")
    public Boolean addPersonData(@RequestBody CreditRate form) {
        return rateService.addPersonData(form);
    }

    /**
     * 新增企业良好行为评定数据(企业)
     *
     * @param form 企业良好行为表单
     * @return 是否成功
     */
    @PostMapping("/EnterpriseCreditRateList/enterprise/goodBehavior/addData")
    public Boolean addEnterpriseData(@RequestBody CreditRate form) {
        return rateService.addEnterpriseData(form);
    }

    /**
     * 编辑县级初审个人良好行为数据(县级)
     *
     * @param form 个人良好行为表单
     * @param id   此表单数据id
     * @return 是否成功
     */
    @PutMapping("/PersonalCreditRateList/county/goodBehavior/addData")
    public Boolean addGoodPersonData(@RequestBody CreditRate form, Long id) {
        return rateService.addGoodPersonData(form, id);
    }

    /**
     * 编辑县级初审企业良好行为数据(县级)
     *
     * @param form 企业良好行为表单
     * @param id   此表单数据id
     * @return 是否成功
     */
    @PutMapping("/EnterpriseCreditRateList/county/goodBehavior/addData")
    public Boolean addGoodEnterpriseData(@RequestBody CreditRate form, Long id) {
        return rateService.addGoodEnterpriseData(form, id);
    }

    /**
     * 新增个人不良行为评定数据(企业)
     *
     * @param form 个人不良行为表单
     * @param id   此表单id
     * @return 是否成功
     */
    @PutMapping("/PersonalCreditRateList/enterprise/badBehavior/addData")
    public Boolean addBadPersonData(@RequestBody CreditRate form, Long id) {
        return rateService.addBadPersonData(form, id);
    }

    /**
     * 新增企业不良行为评定数据(企业)
     *
     * @param form 企业不良行为表单
     * @param id   此表单id
     * @return 是否成功
     */
    @PutMapping("/EnterpriseCreditRateList/enterprise/badBehavior/addData")
    public Boolean addBadEnterpriseData(@RequestBody CreditRate form, Long id) {
        return rateService.addBadEnterpriseData(form, id);
    }

    /**
     * 新增个人不良行为评定数据(县级)
     *
     * @param form 个人不良行为表单
     * @return 是否成功
     */
    @PostMapping("/PersonalCreditRateList/county/badBehavior/addData/1")
    public Boolean addCountyBadPersonData(@RequestBody CreditRate form) {
        return rateService.addCountyBadPersonData(form);
    }

    /**
     * 新增企业不良行为评定数据(县级)
     *
     * @param form 企业不良行为表单
     * @return 是否成功
     */
    @PostMapping("/EnterpriseCreditRateList/county/badBehavior/addData/1")
    public Boolean addCountyBadEnterpriseData(@RequestBody CreditRate form) {
        return rateService.addCountyBadEnterpriseData(form);
    }

    /**
     * 新增个人不良行为复审数据(县级)
     *
     * @param form 个人不良行为复审表单
     * @param id   此表单id
     * @return 是否成功
     */
    @PutMapping("/PersonalCreditRateList/county/badBehavior/addData/2")
    public Boolean addCountyReviewPersonData(@RequestBody CreditRate form, Long id) {
        return rateService.addCountyReviewPersonData(form, id);
    }

    /**
     * 新增企业不良行为复审数据(县级)
     *
     * @param form 企业不良行为复审表单
     * @param id   此表单id
     * @return 是否成功
     */
    @PutMapping("/EnterpriseCreditRateList/county/badBehavior/addData/2")
    public Boolean addCountyReviewEnterpriseData(@RequestBody CreditRate form, Long id) {
        return rateService.addCountyReviewEnterpriseData(form, id);
    }

    /**
     * 新增个人不良行为初审(县级)
     *
     * @param form 个人不良行为初审表单
     * @param id   此表单id
     * @return 是否成功
     */
    @PutMapping("/PersonalCreditRateList/county/badBehavior/addData/3")
    public Boolean addCountyVerifyPersonData(@RequestBody CreditRate form, Long id) {
        return rateService.addCountyVerifyPersonData(form, id);
    }

    /**
     * 新增企业不良行为初审(县级)
     *
     * @param form 企业不良行为初审表单
     * @param id   此表单id
     * @return 是否成功
     */
    @PutMapping("/EnterpriseCreditRateList/county/badBehavior/addData/3")
    public Boolean addCountyVerifyEnterpriseData(@RequestBody CreditRate form, Long id) {
        return rateService.addCountyVerifyEnterpriseData(form, id);
    }
}
