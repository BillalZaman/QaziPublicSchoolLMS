package com.infotech4It.qazipublicschool.view.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by Bilal Zaman on 03/08/2020.
 */
public class StudentModel implements Serializable {
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("client_name")
    @Expose
    private String clientName;
    @SerializedName("detail")
    @Expose
    private String detail;
    @SerializedName("comp_id")
    @Expose
    private String compId;
    @SerializedName("father_name")
    @Expose
    private String fatherName;
    @SerializedName("ph_no")
    @Expose
    private String phNo;
    @SerializedName("offc_no")
    @Expose
    private String offcNo;
    @SerializedName("section")
    @Expose
    private String section;
    @SerializedName("class_id")
    @Expose
    private Integer classId;
    @SerializedName("branch_id")
    @Expose
    private Integer branchId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getCompId() {
        return compId;
    }

    public void setCompId(String compId) {
        this.compId = compId;
    }

    public String getFatherName() {
        return fatherName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    public String getPhNo() {
        return phNo;
    }

    public void setPhNo(String phNo) {
        this.phNo = phNo;
    }

    public String getOffcNo() {
        return offcNo;
    }

    public void setOffcNo(String offcNo) {
        this.offcNo = offcNo;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public Integer getClassId() {
        return classId;
    }

    public void setClassId(Integer classId) {
        this.classId = classId;
    }

    public Integer getBranchId() {
        return branchId;
    }

    public void setBranchId(Integer branchId) {
        this.branchId = branchId;
    }

}
