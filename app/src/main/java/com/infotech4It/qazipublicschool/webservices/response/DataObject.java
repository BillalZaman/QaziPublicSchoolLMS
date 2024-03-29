package com.infotech4It.qazipublicschool.webservices.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.infotech4It.qazipublicschool.view.models.AllLessonModel;
import com.infotech4It.qazipublicschool.view.models.BranchModel;
import com.infotech4It.qazipublicschool.view.models.FillBlankModel;
import com.infotech4It.qazipublicschool.view.models.RecentAssessmentModel;
import com.infotech4It.qazipublicschool.view.models.RecentLessonModel;
import com.infotech4It.qazipublicschool.view.models.StudentModel;
import com.infotech4It.qazipublicschool.view.models.StudentSubjectModel;
import com.infotech4It.qazipublicschool.view.models.TeacherData;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Bilal Zaman on 03/08/2020.
 */
public class DataObject implements Serializable {
    @SerializedName("UserData")
    @Expose
    StudentModel studentModel;

    @SerializedName("Brancheslist")
    @Expose
    private List<BranchModel> branchModelList = null;

    @SerializedName("StudentSubjects")
    @Expose
    private List<StudentSubjectModel> studentSubjects = null;

    @SerializedName("RecentLessons")
    @Expose
    private List<AllLessonModel> recentLessons = null;
    @SerializedName("AllLessons")
    @Expose
    private List<RecentLessonModel> allLessons = null;
    @SerializedName("RecentAssessments")
    @Expose
    private List<RecentAssessmentModel> recentAssessments = null;
    @SerializedName("AllAssessments")
    @Expose
    private List<RecentAssessmentModel> allAssessments = null;

    @SerializedName("VideoLinkData")
    @Expose
    private String videoLinkData;
    @SerializedName("ImageData")
    @Expose
    private List<Object> imageData = null;
    @SerializedName("TeacherData")
    @Expose
    private TeacherData teacherData;
    @SerializedName("TodoList")
    @Expose
    private String todoList;
    @SerializedName("HomeWork")
    @Expose
    private String homeWork;

    @SerializedName("QuestionsData")
    @Expose
    private List<FillBlankModel> questionsData = null;


    public StudentModel getStudentModel() {
        return studentModel;
    }

    public void setStudentModel(StudentModel studentModel) {
        this.studentModel = studentModel;
    }

    public List<BranchModel> getBranchModelList() {
        return branchModelList;
    }

    public void setBranchModelList(List<BranchModel> branchModelList) {
        this.branchModelList = branchModelList;
    }

    public List<StudentSubjectModel> getStudentSubjects() {
        return studentSubjects;
    }

    public void setStudentSubjects(List<StudentSubjectModel> studentSubjects) {
        this.studentSubjects = studentSubjects;
    }

    public List<AllLessonModel> getRecentLessons() {
        return recentLessons;
    }

    public void setRecentLessons(List<AllLessonModel> recentLessons) {
        this.recentLessons = recentLessons;
    }

    public List<RecentLessonModel> getAllLessons() {
        return allLessons;
    }

    public void setAllLessons(List<RecentLessonModel> allLessons) {
        this.allLessons = allLessons;
    }

    public List<RecentAssessmentModel> getRecentAssessments() {
        return recentAssessments;
    }

    public void setRecentAssessments(List<RecentAssessmentModel> recentAssessments) {
        this.recentAssessments = recentAssessments;
    }

    public List<RecentAssessmentModel> getAllAssessments() {
        return allAssessments;
    }

    public void setAllAssessments(List<RecentAssessmentModel> allAssessments) {
        this.allAssessments = allAssessments;
    }

    public String getVideoLinkData() {
        return videoLinkData;
    }

    public void setVideoLinkData(String videoLinkData) {
        this.videoLinkData = videoLinkData;
    }

    public List<Object> getImageData() {
        return imageData;
    }

    public void setImageData(List<Object> imageData) {
        this.imageData = imageData;
    }

    public TeacherData getTeacherData() {
        return teacherData;
    }

    public void setTeacherData(TeacherData teacherData) {
        this.teacherData = teacherData;
    }

    public String getTodoList() {
        return todoList;
    }

    public void setTodoList(String todoList) {
        this.todoList = todoList;
    }

    public String getHomeWork() {
        return homeWork;
    }

    public void setHomeWork(String homeWork) {
        this.homeWork = homeWork;
    }

    public List<FillBlankModel> getQuestionsData() {
        return questionsData;
    }

    public void setQuestionsData(List<FillBlankModel> questionsData) {
        this.questionsData = questionsData;
    }
}
