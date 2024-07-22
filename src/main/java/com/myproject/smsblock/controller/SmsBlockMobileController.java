package com.myproject.smsblock.controller;

import com.myproject.smsblock.dto.SmsBlockMobileDto;
import com.myproject.smsblock.entity.SmsBlockMobile;
import com.myproject.smsblock.services.SmsBlockMobileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping
public class SmsBlockMobileController {

    @Autowired
    private SmsBlockMobileService smsBlockMobileService;
    @PostMapping("/createMobile")
    public ResponseEntity<?> saveSmsBlockMobile(@RequestBody SmsBlockMobileDto smsBlockMobileDto) {
        try {
            SmsBlockMobile savedMobilenumber = smsBlockMobileService.saveSmsBlockMobile(smsBlockMobileDto);

            if (savedMobilenumber != null) {
                return new ResponseEntity<>(savedMobilenumber, HttpStatus.CREATED);
            } else {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>("Phone number cannot be null or empty", HttpStatus.BAD_REQUEST);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
    }

    @PutMapping("/deactivateMobile/{mobileNo}")
    public ResponseEntity<String> deactivateSmsBlockMobile(@RequestBody SmsBlockMobileDto smsBlockMobileDto, @PathVariable String mobileNo) {
        try {
            SmsBlockMobile deactivatedMobile = smsBlockMobileService.deactivateSmsBlockMobile(smsBlockMobileDto);
            return new ResponseEntity<>("Deactivated", HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
    

}
