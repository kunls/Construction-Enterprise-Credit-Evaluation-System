package com.lxk.enterprisecreditsystem.dto.creditListDto;

import lombok.Data;

@Data
public class EnterpriseDTO {
    private String name;
    private String creditId;
    private String address;
    private String legalPerson;
    private Integer score;
    private String level;
}
