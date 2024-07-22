package com.myproject.smsblock.repository;

import com.myproject.smsblock.dto.SmsBlockBlacklistDto;
import com.myproject.smsblock.entity.SmsBlockBlacklist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SmsBlockBlacklistRepository extends JpaRepository<SmsBlockBlacklist, Integer> {
    SmsBlockBlacklist findByBlacklistMobile(String blacklistMobile);
    List<SmsBlockBlacklist> findAllByBlacklistMobile(String blacklistMobile);

@Query("SELECT new com.mobitel.smsblock.dto.SmsBlockBlacklistDto(s.blacklistMobile, s.smsBlockMobile.id, s.comment, s.activatedOn, s.addedBy) FROM SmsBlockBlacklist s WHERE s.smsBlockMobile.id = :smsBlockMobile AND s.status = 'ACT'")
List<SmsBlockBlacklistDto> findAllBySmsBlockMobile(@Param("smsBlockMobile") Integer smsBlockMobile);

}
