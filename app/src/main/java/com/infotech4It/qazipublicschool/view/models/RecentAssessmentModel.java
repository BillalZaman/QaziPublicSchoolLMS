package com.infotech4It.qazipublicschool.view.models;

/**
 * Created by Bilal Zaman on 18/07/2020.
 */
public class RecentAssessmentModel {
    private String assessmentName;
    private String assessmentDate;
    private String assessmentMarks;

    public RecentAssessmentModel(String assessmentName, String assessmentDate, String assessmentMarks) {
        this.assessmentName = assessmentName;
        this.assessmentDate = assessmentDate;
        this.assessmentMarks = assessmentMarks;
    }

    public String getAssessmentName() {
        return assessmentName;
    }

    public void setAssessmentName(String assessmentName) {
        this.assessmentName = assessmentName;
    }

    public String getAssessmentDate() {
        return assessmentDate;
    }

    public void setAssessmentDate(String assessmentDate) {
        this.assessmentDate = assessmentDate;
    }

    public String getAssessmentMarks() {
        return assessmentMarks;
    }

    public void setAssessmentMarks(String assessmentMarks) {
        this.assessmentMarks = assessmentMarks;
    }
}
