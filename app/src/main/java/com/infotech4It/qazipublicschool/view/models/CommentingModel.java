package com.infotech4It.qazipublicschool.view.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by Bilal Zaman on 28/07/2020.
 */
public class CommentingModel implements Serializable {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("student_id")
    @Expose
    private Integer studentId;
    @SerializedName("lec_id")
    @Expose
    private Integer lecId;
    @SerializedName("teacher_name")
    @Expose
    private String teacherName;
    @SerializedName("parent_msg_id")
    @Expose
    private Integer parentMsgId;
    @SerializedName("msg")
    @Expose
    private String msg;
    @SerializedName("published")
    @Expose
    private Integer published;
    @SerializedName("isseen")
    @Expose
    private Integer isseen;
    @SerializedName("created_at")
    @Expose
    private String createdAt;
    @SerializedName("updated_at")
    @Expose
    private String updatedAt;
    @SerializedName("deleted_at")
    @Expose
    private Object deletedAt;
    @SerializedName("student_name")
    @Expose
    private String studentName;

    public CommentingModel() {
    }

    public CommentingModel(Integer id, Integer studentId, Integer lecId, String teacherName, Integer parentMsgId, String msg,
                           Integer published, Integer isseen, String createdAt, String updatedAt, Object deletedAt,
                           String studentName) {
        this.id = id;
        this.studentId = studentId;
        this.lecId = lecId;
        this.teacherName = teacherName;
        this.parentMsgId = parentMsgId;
        this.msg = msg;
        this.published = published;
        this.isseen = isseen;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.deletedAt = deletedAt;
        this.studentName = studentName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public Integer getLecId() {
        return lecId;
    }

    public void setLecId(Integer lecId) {
        this.lecId = lecId;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public Integer getParentMsgId() {
        return parentMsgId;
    }

    public void setParentMsgId(Integer parentMsgId) {
        this.parentMsgId = parentMsgId;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Integer getPublished() {
        return published;
    }

    public void setPublished(Integer published) {
        this.published = published;
    }

    public Integer getIsseen() {
        return isseen;
    }

    public void setIsseen(Integer isseen) {
        this.isseen = isseen;
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

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }
}
