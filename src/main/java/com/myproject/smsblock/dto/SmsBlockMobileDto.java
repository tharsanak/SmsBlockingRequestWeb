package com.myproject.smsblock.dto;
import java.sql.Timestamp;

public class SmsBlockMobileDto {
    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    private String mobileNo;

    private  String status;

    private String comment;



    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
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

    private Timestamp activatedOn;
    private String addedBy;

    private Timestamp deactivatedOn;

    private String deactivatedBy;



}
