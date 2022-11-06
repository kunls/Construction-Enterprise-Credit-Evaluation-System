package com.lxk.enterprisecreditsystem.dto.blacklistDto;

import com.lxk.enterprisecreditsystem.domain.TotalBlacklist;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TotalBlacklistDTO extends TotalBlacklist {
    private String content;
    private String remark;
    private Long ruleId;
    private Long rateNormId;
}
