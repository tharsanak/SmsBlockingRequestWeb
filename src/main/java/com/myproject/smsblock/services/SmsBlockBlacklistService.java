package com.myproject.smsblock.services;

import com.myproject.smsblock.dto.SmsBlockBlacklistDto;
import com.myproject.smsblock.entity.SmsBlockBlacklist;
import com.myproject.smsblock.entity.SmsBlockMobile;

import java.util.List;

public interface SmsBlockBlacklistService {

    SmsBlockBlacklist saveSmsBlockBlacklist(SmsBlockBlacklistDto smsBlockBlacklistDto, SmsBlockMobile smsBlockMobileId);

    SmsBlockBlacklist deleteSmsBlacklistMobile(SmsBlockBlacklistDto blacklistDto);

    List<SmsBlockBlacklistDto> findAllBySmsBlockMobile(Integer smsBlockMobile);

}
