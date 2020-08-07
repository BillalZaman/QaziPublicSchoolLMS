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
    @SerializedName("password")
    @Expose
    private String password;
    @SerializedName("medium")
    @Expose
    private Integer medium;
    @SerializedName("subject_group")
    @Expose
    private Integer subjectGroup;
    @SerializedName("image")
    @Expose
    private String image;
    @SerializedName("father_profession")
    @Expose
    private String fatherProfession;
    @SerializedName("deatil")
    @Expose
    private String deatil;
    @SerializedName("created_at")
    @Expose
    private String createdAt;
    @SerializedName("updated_at")
    @Expose
    private String updatedAt;
    @SerializedName("deleted_at")
    @Expose
    private Object deletedAt;

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getMedium() {
        return medium;
    }

    public void setMedium(Integer medium) {
        this.medium = medium;
    }

    public Integer getSubjectGroup() {
        return subjectGroup;
    }

    public void setSubjectGroup(Integer subjectGroup) {
        this.subjectGroup = subjectGroup;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getFatherProfession() {
        return fatherProfession;
    }

    public void setFatherProfession(String fatherProfession) {
        this.fatherProfession = fatherProfession;
    }

    public String getDeatil() {
        return deatil;
    }

    public void setDeatil(String deatil) {
        this.deatil = deatil;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Object getDeletedAt() {
        return deletedAt;
    }

    public void setDeletedAt(Object deletedAt) {
        this.deletedAt = deletedAt;
    }
}
