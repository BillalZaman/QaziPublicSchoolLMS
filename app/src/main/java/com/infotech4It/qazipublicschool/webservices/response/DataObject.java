package com.infotech4It.qazipublicschool.webservices.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.infotech4It.qazipublicschool.view.models.AllLessonModel;
import com.infotech4It.qazipublicschool.view.models.BranchModel;
import com.infotech4It.qazipublicschool.view.models.CommentingModel;
import com.infotech4It.qazipublicschool.view.models.FillBlankModel;
import com.infotech4It.qazipublicschool.view.models.MCQsModel;
import com.infotech4It.qazipublicschool.view.models.RecentAssessmentModel;
import com.infotech4It.qazipublicschool.view.models.RecentLessonModel;
import com.infotech4It.qazipublicschool.view.models.RightAnswerModel;
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
    private List<String> imageData = null;
    @SerializedName("TeacherData")
    @Expose
    private TeacherData teacherData;
    @SerializedName("TodoList")
    @Expose
    private String todoList;
    @SerializedName("HomeWork")
    @Expose
    private String homeWork;
    @SerializedName("QuestionsDataa")
    @Expose
    private List<FillBlankModel> questionsData = null;
    @SerializedName("CommentData")
    @Expose
    private List<CommentingModel> commentData = null;
    @SerializedName("QuestionsData")
    @Expose
    private List<MCQsModel> mcQsModelList = null;

    @SerializedName("totalMarks")
    @Expose
    private Integer totalMarks;
    @SerializedName("obtainedMarks")
    @Expose
    private Integer obtainedMarks;
    @SerializedName("rightAnswers")
    @Expose
    private List<RightAnswerModel> rightAnswers = null;

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

    public List<String> getImageData() {
        return imageData;
    }

    public void setImageData(List<String> imageData) {
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

    public List<MCQsModel> getMcQsModelList() {
        return mcQsModelList;
    }

    public void setMcQsModelList(List<MCQsModel> mcQsModelList) {
        this.mcQsModelList = mcQsModelList;
    }


    public List<CommentingModel> getCommentData() {
        return commentData;
    }

    public void setCommentData(List<CommentingModel> commentData) {
        this.commentData = commentData;
    }

    public Integer getTotalMarks() {
        return totalMarks;
    }

    public void setTotalMarks(Integer totalMarks) {
        this.totalMarks = totalMarks;
    }

    public Integer getObtainedMarks() {
        return obtainedMarks;
    }

    public void setObtainedMarks(Integer obtainedMarks) {
        this.obtainedMarks = obtainedMarks;
    }

    public List<RightAnswerModel> getRightAnswers() {
        return rightAnswers;
    }

    public void setRightAnswers(List<RightAnswerModel> rightAnswers) {
        this.rightAnswers = rightAnswers;
    }
}
