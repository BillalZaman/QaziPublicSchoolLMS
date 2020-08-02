package com.infotech4It.qazipublicschool.view.models;

/**
 * Created by Bilal Zaman on 28/07/2020.
 */
public class CommentingModel {
    private String commentDate;
    private String commentTeacher;
    private String commentStudent;

    public CommentingModel(String commentDate, String commentTeacher, String commentStudent) {
        this.commentDate = commentDate;
        this.commentTeacher = commentTeacher;
        this.commentStudent = commentStudent;
    }

    public String getCommentDate() {
        return commentDate;
    }

    public void setCommentDate(String commentDate) {
        this.commentDate = commentDate;
    }

    public String getCommentTeacher() {
        return commentTeacher;
    }

    public void setCommentTeacher(String commentTeacher) {
        this.commentTeacher = commentTeacher;
    }

    public String getCommentStudent() {
        return commentStudent;
    }

    public void setCommentStudent(String commentStudent) {
        this.commentStudent = commentStudent;
    }
}
