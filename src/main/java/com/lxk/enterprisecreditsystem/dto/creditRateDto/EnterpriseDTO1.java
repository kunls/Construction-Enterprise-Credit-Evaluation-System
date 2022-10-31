package com.lxk.enterprisecreditsystem.dto.creditRateDto;

import com.lxk.enterprisecreditsystem.domain.CreditRate;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class EnterpriseDTO1 extends CreditRate {
    private String name;
    private String idCard;
    private String category;
    private String norm;
    private Integer score;
    private LocalDateTime handleTime;
    private String status;
}
