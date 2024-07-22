package com.mobitel.smsblock.services;

import com.mobitel.smsblock.dto.SmsBlockMobileDto;
import com.mobitel.smsblock.entity.SmsBlockMobile;

public interface SmsBlockMobileService {

    SmsBlockMobile saveSmsBlockMobile(SmsBlockMobileDto smsBlockMobileDto);
    SmsBlockMobile deactivateSmsBlockMobile(SmsBlockMobileDto smsBlockMobileDto);

}
