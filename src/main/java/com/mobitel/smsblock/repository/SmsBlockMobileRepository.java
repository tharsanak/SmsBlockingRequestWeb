package com.mobitel.smsblock.repository;

import com.mobitel.smsblock.entity.SmsBlockBlacklist;
import com.mobitel.smsblock.entity.SmsBlockMobile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.math.BigInteger;
import java.util.List;

@Repository
public interface SmsBlockMobileRepository extends JpaRepository<SmsBlockMobile, Integer> {

    SmsBlockMobile findByMobileNo(String mobileNo);
    SmsBlockMobile findByMobileNoAndStatus(String mobileNo, String status);


}
