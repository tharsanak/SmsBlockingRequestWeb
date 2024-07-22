package com.mobitel.smsblock.controller;
import com.mobitel.smsblock.dto.SmsBlockBlacklistDto;
import com.mobitel.smsblock.dto.SmsBlockBlacklistViewDto;
import com.mobitel.smsblock.entity.SmsBlockBlacklist;
import com.mobitel.smsblock.entity.SmsBlockMobile;
import com.mobitel.smsblock.services.SmsBlockBlacklistService;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RequestMapping
@RestController

public class SmsBlockBlacklistController {
//    Logger logger = LoggerFactory.getLogger(SmsBlockBlacklistController.class);

    @Autowired
    private final SmsBlockBlacklistService smsBlockBlacklistService;

    public SmsBlockBlacklistController(SmsBlockBlacklistService smsBlockBlacklistService) {
        this.smsBlockBlacklistService = smsBlockBlacklistService;
    }
    @Autowired
    private ModelMapper modelMapper;

    @PostMapping("/createBlockMobile/{smsBlockMobileId}")
    public ResponseEntity<String> saveSmsBlockBlacklist(@RequestBody SmsBlockBlacklistDto smsBlockBlacklistDto, @PathVariable SmsBlockMobile smsBlockMobileId) {
//        logger.info("[Adding the blacklistlist mobile number] info message");
        try {
            SmsBlockBlacklist savedBlockedMobilenumber = smsBlockBlacklistService.saveSmsBlockBlacklist(smsBlockBlacklistDto,smsBlockMobileId);

            if (savedBlockedMobilenumber != null) {
                return new ResponseEntity<>("Saved", HttpStatus.CREATED);
            } else {
                return new ResponseEntity<>("Saved", HttpStatus.CREATED);
            }
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
        }
    }



    @PutMapping("/deleteBlacklistMobile/{blacklistMobile}")
    public ResponseEntity<String> deactivateSmsBlacklistMobile(@RequestBody SmsBlockBlacklistDto blacklistDto) {
        try {
            SmsBlockBlacklist deactivatedBlacklistMobile = smsBlockBlacklistService.deleteSmsBlacklistMobile(blacklistDto);
            return new ResponseEntity<>("Deactivated", HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }


    @GetMapping("/mobile/{smsBlockMobile}")
    public ResponseEntity<List<SmsBlockBlacklistDto>> getBlocklistBySmsBlockMobile(@PathVariable Integer smsBlockMobile) {
        List<SmsBlockBlacklistDto> dtos = smsBlockBlacklistService.findAllBySmsBlockMobile(smsBlockMobile);
        return new ResponseEntity<>(dtos, HttpStatus.OK);
    }

}
