package com.lxk.enterprisecreditsystem.dto.creditListDto;

import lombok.Data;

@Data
public class PersonDTO {
    private String name;
    private String idCard;
    private String fromEnterprise;
    private String creditId;
    private String address;
    private Integer score;
    private String level;
}
