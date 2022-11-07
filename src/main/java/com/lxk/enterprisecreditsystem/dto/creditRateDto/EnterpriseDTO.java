package com.lxk.enterprisecreditsystem.dto.creditRateDto;

import com.lxk.enterprisecreditsystem.domain.CreditRate;
import lombok.Data;

import java.util.Date;

@Data
public class EnterpriseDTO extends CreditRate {
    private String name;
    private String idCard;
    private String category;
    private String norm;
    private Integer score;
    private Date handleTime;
    private String status;
}
