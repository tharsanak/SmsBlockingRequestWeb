package com.myproject.smsblock.services;

import com.myproject.smsblock.dto.SmsBlockMobileDto;
import com.myproject.smsblock.entity.SmsBlockMobile;

public interface SmsBlockMobileService {

    SmsBlockMobile saveSmsBlockMobile(SmsBlockMobileDto smsBlockMobileDto);
    SmsBlockMobile deactivateSmsBlockMobile(SmsBlockMobileDto smsBlockMobileDto);

}
