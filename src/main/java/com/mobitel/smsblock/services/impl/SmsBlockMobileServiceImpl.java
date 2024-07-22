package com.mobitel.smsblock.services.impl;
import com.mobitel.smsblock.dto.SmsBlockMobileDto;
import com.mobitel.smsblock.entity.SmsBlockBlacklist;
import com.mobitel.smsblock.entity.SmsBlockMobile;
import com.mobitel.smsblock.repository.SmsBlockMobileRepository;
import com.mobitel.smsblock.services.SmsBlockMobileService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class SmsBlockMobileServiceImpl implements SmsBlockMobileService {
@Autowired
   private SmsBlockMobileRepository smsBlockMobileRepository;

@Autowired
    private ModelMapper modelMapper;
    @Override
    public SmsBlockMobile saveSmsBlockMobile(SmsBlockMobileDto smsBlockMobileDto) {
        String mobileNo = smsBlockMobileDto.getMobileNo();
        if (mobileNo == null || mobileNo.trim().isEmpty()) {
            throw new IllegalArgumentException("Phone number cannot be null or empty");
        }
        SmsBlockMobile existingActiveMobile = smsBlockMobileRepository.findByMobileNoAndStatus(mobileNo, "ACT");

        if (existingActiveMobile != null) {
            throw new RuntimeException("An active record already exists for this mobile number");
        }
        SmsBlockMobile smsBlockMobile = new SmsBlockMobile();
        smsBlockMobile.setActivatedOn(Timestamp.valueOf(LocalDateTime.now()));
        smsBlockMobile.setStatus("ACT");
        smsBlockMobile.setMobileNo(mobileNo);
        smsBlockMobile.setComment(smsBlockMobileDto.getComment());
        smsBlockMobile.setAddedBy(smsBlockMobileDto.getAddedBy());
        SmsBlockMobile savedSmsBlockMobile = smsBlockMobileRepository.save(smsBlockMobile);
        return savedSmsBlockMobile;
    }



    @Override
    public SmsBlockMobile deactivateSmsBlockMobile(SmsBlockMobileDto smsBlockMobileDto) {
        if (smsBlockMobileDto.getMobileNo() == null || smsBlockMobileDto.getMobileNo().trim().isEmpty()) {
            throw new IllegalArgumentException("Phone number cannot be null or empty");
        }
        SmsBlockMobile existingMobileNumber = smsBlockMobileRepository.findByMobileNoAndStatus(smsBlockMobileDto.getMobileNo(), "ACT");
        if (existingMobileNumber == null) {
            throw new RuntimeException("Phone number does not exist");
        }
        existingMobileNumber.setDeactivatedOn(Timestamp.valueOf(LocalDateTime.now()));
        existingMobileNumber.setDeactivatedBy(smsBlockMobileDto.getDeactivatedBy());
        existingMobileNumber.setStatus("DEACT");
        return smsBlockMobileRepository.save(existingMobileNumber);
    }
}
