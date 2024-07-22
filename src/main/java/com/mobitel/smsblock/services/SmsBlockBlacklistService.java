package com.mobitel.smsblock.services;

import com.mobitel.smsblock.dto.SmsBlockBlacklistDto;
import com.mobitel.smsblock.entity.SmsBlockBlacklist;
import com.mobitel.smsblock.entity.SmsBlockMobile;

import java.util.List;

public interface SmsBlockBlacklistService {

    SmsBlockBlacklist saveSmsBlockBlacklist(SmsBlockBlacklistDto smsBlockBlacklistDto, SmsBlockMobile smsBlockMobileId);

    SmsBlockBlacklist deleteSmsBlacklistMobile(SmsBlockBlacklistDto blacklistDto);

    List<SmsBlockBlacklistDto> findAllBySmsBlockMobile(Integer smsBlockMobile);

}
