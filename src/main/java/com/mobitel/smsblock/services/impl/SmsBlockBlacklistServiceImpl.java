package com.mobitel.smsblock.services.impl;

import com.mobitel.smsblock.dto.SmsBlockBlacklistDto;
import com.mobitel.smsblock.entity.SmsBlockBlacklist;
import com.mobitel.smsblock.entity.SmsBlockMobile;
import com.mobitel.smsblock.repository.SmsBlockBlacklistRepository;
import com.mobitel.smsblock.repository.SmsBlockMobileRepository;
import com.mobitel.smsblock.services.SmsBlockBlacklistService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class SmsBlockBlacklistServiceImpl implements SmsBlockBlacklistService {



    @Autowired
    private final SmsBlockBlacklistRepository smsBlockBlacklistRepository;

    public SmsBlockBlacklistServiceImpl(SmsBlockBlacklistRepository smsBlockBlacklistRepository) {
        this.smsBlockBlacklistRepository = smsBlockBlacklistRepository;
    }
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public SmsBlockBlacklist saveSmsBlockBlacklist(SmsBlockBlacklistDto smsBlockBlacklistDto, SmsBlockMobile smsBlockMobileId) {
        String blacklistMobile = smsBlockBlacklistDto.getBlacklistMobile();

        if (blacklistMobile == null || blacklistMobile.trim().isEmpty()) {
            throw new IllegalArgumentException("Phone number cannot be null or empty");
        }
        List<SmsBlockBlacklist> existingBlocknumbers = smsBlockBlacklistRepository.findAllByBlacklistMobile(blacklistMobile);

        boolean isExistingActiveEntry = existingBlocknumbers.stream()
                .anyMatch(entry -> "ACT".equals(entry.getStatus()));

        if (isExistingActiveEntry) {
            throw new RuntimeException("Phone number already exists");
        }
        SmsBlockBlacklist smsBlockBlacklist = new SmsBlockBlacklist();
        smsBlockBlacklist.setActivatedOn(Timestamp.valueOf(LocalDateTime.now()));
        smsBlockBlacklist.setStatus("ACT");
        smsBlockBlacklist.setBlacklistMobile(blacklistMobile);
        smsBlockBlacklist.setComment(smsBlockBlacklistDto.getComment());
        smsBlockBlacklist.setAddedBy(smsBlockBlacklistDto.getAddedBy());
        smsBlockBlacklist.setSmsBlockMobile(smsBlockMobileId);
        return smsBlockBlacklistRepository.save(smsBlockBlacklist);
    }




    @Override
    public SmsBlockBlacklist deleteSmsBlacklistMobile(SmsBlockBlacklistDto blacklistDto) {
        if (blacklistDto.getBlacklistMobile() == null || blacklistDto.getBlacklistMobile().trim().isEmpty()) {
            throw new IllegalArgumentException("Phone number cannot be null or empty");
        }
        List<SmsBlockBlacklist> existingEntries = smsBlockBlacklistRepository.findAllByBlacklistMobile(blacklistDto.getBlacklistMobile());

        if (existingEntries.isEmpty()) {
            throw new RuntimeException("Phone number does not exist");
        }
        Optional<SmsBlockBlacklist> activeEntry = existingEntries.stream()
                .filter(entry -> "ACT".equals(entry.getStatus()))
                .findFirst();

        if (activeEntry.isPresent()) {
            SmsBlockBlacklist existingMobileNumber = activeEntry.get();
            existingMobileNumber.setDeactivatedOn(Timestamp.valueOf(LocalDateTime.now()));
            existingMobileNumber.setDeactivatedBy(blacklistDto.getDeactivatedBy());
            existingMobileNumber.setStatus("DEACT");
            return smsBlockBlacklistRepository.save(existingMobileNumber);
        } else {
            throw new RuntimeException("Phone number does not exist");
        }
    }



    @Override
    public List<SmsBlockBlacklistDto> findAllBySmsBlockMobile(Integer smsBlockMobile) {
        return smsBlockBlacklistRepository.findAllBySmsBlockMobile(smsBlockMobile);
    }



}
