package com.infotech4It.qazipublicschool.view.models;

/**
 * Created by Bilal Zaman on 18/07/2020.
 */
public class SubjectModel {
    private int subjectIcon;
    private String subjectName;

    public SubjectModel(int subjectIcon, String subjectName) {
        this.subjectIcon = subjectIcon;
        this.subjectName = subjectName;
    }

    public int getSubjectIcon() {
        return subjectIcon;
    }

    public void setSubjectIcon(int subjectIcon) {
        this.subjectIcon = subjectIcon;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }
}
