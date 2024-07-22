package com.mobitel.smsblock.dto;

import java.sql.Timestamp;

public class SmsBlockBlacklistViewDto {
    private String blacklistMobile;

    private Integer smsBlockMobile;
    private String comment;
    private Timestamp activatedOn;
    private String addedBy;

    private String status;
    public SmsBlockBlacklistViewDto(String blacklistMobile, Integer smsBlockMobile, String comment, Timestamp activatedOn, String addedBy) {
        this.blacklistMobile = blacklistMobile;
        this.smsBlockMobile = smsBlockMobile;
        this.comment = comment;
        this.activatedOn = activatedOn;
        this.addedBy = addedBy;
    }
    public String getBlacklistMobile() {
        return blacklistMobile;
    }

    public void setBlacklistMobile(String blacklistMobile) {
        this.blacklistMobile = blacklistMobile;
    }

    public Integer getSmsBlockMobile() {
        return smsBlockMobile;
    }

    public void setSmsBlockMobile(Integer smsBlockMobile) {
        this.smsBlockMobile = smsBlockMobile;
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



    public SmsBlockBlacklistViewDto(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
