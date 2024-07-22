package com.myproject.smsblock.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "sms_block_blacklisted_mobile")
public class SmsBlockBlacklist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "sms_block_mobile_id", referencedColumnName = "id")
    private SmsBlockMobile smsBlockMobile;

    @Column(name = "blacklist_mobile" ,columnDefinition = "VARCHAR(15)")
    private String blacklistMobile;

    @Column(name = "status" ,columnDefinition = "VARCHAR(5)")
    private String status;

    @Column(name = "comment",columnDefinition = "VARCHAR(100)")
    private String comment;

    @Column(name = "activated_on", columnDefinition = "TIMESTAMP")
    private Timestamp activatedOn;

    @Column(name = "added_by", columnDefinition = "VARCHAR(30)")
    private String addedBy;

    @Column(name = "deactivated_on",columnDefinition = "TIMESTAMP")
    private Timestamp deactivatedOn;

    @Column(name = "deactivated_by", columnDefinition = "VARCHAR(30)")
    private String deactivatedBy;


    public SmsBlockMobile getSmsBlockMobile() {
        return smsBlockMobile;
    }

    public void setSmsBlockMobile(SmsBlockMobile smsBlockMobile) {
        this.smsBlockMobile = smsBlockMobile;
    }

    public String getBlacklistMobile() {
        return blacklistMobile;
    }

    public void setBlacklistMobile(String blacklistMobile) {
        this.blacklistMobile = blacklistMobile;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Timestamp getActivatedOn() {
        return activatedOn;
    }

    public void setActivatedOn(Timestamp activatedOn) {
        this.activatedOn = activatedOn;
    }

    public String getAddedBy() {
        return addedBy;
    }

    public void setAddedBy(String addedBy) {
        this.addedBy = addedBy;
    }

    public Timestamp getDeactivatedOn() {
        return deactivatedOn;
    }

    public void setDeactivatedOn(Timestamp deactivatedOn) {
        this.deactivatedOn = deactivatedOn;
    }

    public String getDeactivatedBy() {
        return deactivatedBy;
    }

    public void setDeactivatedBy(String deactivatedBy) {
        this.deactivatedBy = deactivatedBy;
    }



}