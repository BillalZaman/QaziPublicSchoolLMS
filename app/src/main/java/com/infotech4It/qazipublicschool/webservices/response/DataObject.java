package com.infotech4It.qazipublicschool.webservices.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.infotech4It.qazipublicschool.view.models.AllLessonModel;
import com.infotech4It.qazipublicschool.view.models.BranchModel;
import com.infotech4It.qazipublicschool.view.models.RecentAssessmentModel;
import com.infotech4It.qazipublicschool.view.models.StudentModel;
import com.infotech4It.qazipublicschool.view.models.StudentSubjectModel;

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
    private List<AllLessonModel> allLessons = null;
    @SerializedName("RecentAssessments")
    @Expose
    private List<RecentAssessmentModel> recentAssessments = null;
    @SerializedName("AllAssessments")
    @Expose
    private List<RecentAssessmentModel> allAssessments = null;


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

    public List<AllLessonModel> getAllLessons() {
        return allLessons;
    }

    public void setAllLessons(List<AllLessonModel> allLessons) {
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
}
