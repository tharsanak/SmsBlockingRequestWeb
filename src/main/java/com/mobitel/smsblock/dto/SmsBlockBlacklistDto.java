package com.mobitel.smsblock.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.sql.Timestamp;

public class SmsBlockBlacklistDto {
    @Id

    private Integer smsBlockMobileId;

    private String blacklistMobile;

    private String status;
    private String comment;

    private Timestamp activatedOn;

    private String addedBy;

    private Timestamp deactivatedOn;
    private String deactivatedBy;



    public SmsBlockBlacklistDto(String blacklistMobile, Integer smsBlockMobileId, String comment, Timestamp activatedOn, String addedBy) {
        this.blacklistMobile = blacklistMobile;
        this.smsBlockMobileId = smsBlockMobileId;
        this.comment = comment;
        this.activatedOn = activatedOn;
        this.addedBy = addedBy;
    }

    public Integer getSmsBlockMobileId() {
        return smsBlockMobileId;
    }

    public void setSmsBlockMobileId(Integer smsBlockMobileId) {
        this.smsBlockMobileId = smsBlockMobileId;
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
