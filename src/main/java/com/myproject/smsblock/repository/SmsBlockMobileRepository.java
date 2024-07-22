package com.myproject.smsblock.repository;

import com.myproject.smsblock.entity.SmsBlockMobile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SmsBlockMobileRepository extends JpaRepository<SmsBlockMobile, Integer> {

    SmsBlockMobile findByMobileNo(String mobileNo);
    SmsBlockMobile findByMobileNoAndStatus(String mobileNo, String status);


}
