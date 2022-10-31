package com.lxk.enterprisecreditsystem.dto.creditRateDto;

import com.lxk.enterprisecreditsystem.domain.CreditRate;
import lombok.Data;

import java.time.LocalDateTime;
@Data
public class PersonDTO1 extends CreditRate {
    private String name;
    private String idCard;
    private String category;
    private String norm;
    private Integer score;
    private LocalDateTime finishDate;
    private String status;
}
