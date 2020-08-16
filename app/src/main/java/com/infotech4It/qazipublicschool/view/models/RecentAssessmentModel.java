package com.infotech4It.qazipublicschool.view.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by Bilal Zaman on 18/07/2020.
 */
public class RecentAssessmentModel implements Serializable {
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("test_name")
    @Expose
    private String testName;
    @SerializedName("detail")
    @Expose
    private String detail;
    @SerializedName("overview")
    @Expose
    private String overview;
    @SerializedName("user_id")
    @Expose
    private String userId;
    @SerializedName("class_is")
    @Expose
    private Integer classIs;
    @SerializedName("subject_id")
    @Expose
    private Integer subjectId;
    @SerializedName("chapter_id")
    @Expose
    private Integer chapterId;
    @SerializedName("total_marks")
    @Expose
    private Integer totalMarks;
    @SerializedName("lectuer_id")
    @Expose
    private Integer lectuerId;
    @SerializedName("publish")
    @Expose
    private Integer publish;
    @SerializedName("time")
    @Expose
    private String time;
    @SerializedName("test_date")
    @Expose
    private String testDate;
    @SerializedName("created_by")
    @Expose
    private Integer createdBy;
    @SerializedName("created_by_name")
    @Expose
    private String createdByName;
    @SerializedName("created_at")
    @Expose
    private String createdAt;
    @SerializedName("updated_at")
    @Expose
    private String updatedAt;
    @SerializedName("deleted_at")
    @Expose
    private Object deletedAt;
    @SerializedName("subject")
    @Expose
    private Subject subject;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTestName() {
        return testName;
    }

    public void setTestName(String testName) {
        this.testName = testName;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Integer getClassIs() {
        return classIs;
    }

    public void setClassIs(Integer classIs) {
        this.classIs = classIs;
    }

    public Integer getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(Integer subjectId) {
        this.subjectId = subjectId;
    }

    public Integer getChapterId() {
        return chapterId;
    }

    public void setChapterId(Integer chapterId) {
        this.chapterId = chapterId;
    }

    public Integer getTotalMarks() {
        return totalMarks;
    }

    public void setTotalMarks(Integer totalMarks) {
        this.totalMarks = totalMarks;
    }

    public Integer getLectuerId() {
        return lectuerId;
    }

    public void setLectuerId(Integer lectuerId) {
        this.lectuerId = lectuerId;
    }

    public Integer getPublish() {
        return publish;
    }

    public void setPublish(Integer publish) {
        this.publish = publish;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getTestDate() {
        return testDate;
    }

    public void setTestDate(String testDate) {
        this.testDate = testDate;
    }

    public Integer getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Integer createdBy) {
        this.createdBy = createdBy;
    }

    public String getCreatedByName() {
        return createdByName;
    }

    public void setCreatedByName(String createdByName) {
        this.createdByName = createdByName;
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

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }
}
