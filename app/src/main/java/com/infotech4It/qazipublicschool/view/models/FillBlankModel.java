package com.infotech4It.qazipublicschool.view.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by Bilal Zaman on 29/07/2020.
 */
public class FillBlankModel implements Serializable {
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("q_eng")
    @Expose
    private String qEng;
    @SerializedName("q_urdu")
    @Expose
    private String qUrdu;
    @SerializedName("a_eng")
    @Expose
    private String aEng;
    @SerializedName("a_urdu")
    @Expose
    private String aUrdu;
    @SerializedName("option_1")
    @Expose
    private Object option1;
    @SerializedName("option_2")
    @Expose
    private Object option2;
    @SerializedName("option_3")
    @Expose
    private Object option3;
    @SerializedName("option_4")
    @Expose
    private Object option4;
    @SerializedName("test_id")
    @Expose
    private Integer testId;
    @SerializedName("q_type_id")
    @Expose
    private Integer qTypeId;
    @SerializedName("user_id")
    @Expose
    private Integer userId;
    @SerializedName("marks")
    @Expose
    private String marks;
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

    public String getqEng() {
        return qEng;
    }

    public void setqEng(String qEng) {
        this.qEng = qEng;
    }

    public String getqUrdu() {
        return qUrdu;
    }

    public void setqUrdu(String qUrdu) {
        this.qUrdu = qUrdu;
    }

    public String getaEng() {
        return aEng;
    }

    public void setaEng(String aEng) {
        this.aEng = aEng;
    }

    public String getaUrdu() {
        return aUrdu;
    }

    public void setaUrdu(String aUrdu) {
        this.aUrdu = aUrdu;
    }

    public Object getOption1() {
        return option1;
    }

    public void setOption1(Object option1) {
        this.option1 = option1;
    }

    public Object getOption2() {
        return option2;
    }

    public void setOption2(Object option2) {
        this.option2 = option2;
    }

    public Object getOption3() {
        return option3;
    }

    public void setOption3(Object option3) {
        this.option3 = option3;
    }

    public Object getOption4() {
        return option4;
    }

    public void setOption4(Object option4) {
        this.option4 = option4;
    }

    public Integer getTestId() {
        return testId;
    }

    public void setTestId(Integer testId) {
        this.testId = testId;
    }

    public Integer getqTypeId() {
        return qTypeId;
    }

    public void setqTypeId(Integer qTypeId) {
        this.qTypeId = qTypeId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getMarks() {
        return marks;
    }

    public void setMarks(String marks) {
        this.marks = marks;
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
