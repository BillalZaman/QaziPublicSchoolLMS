package com.infotech4It.qazipublicschool.view.models;

/**
 * Created by Bilal Zaman on 18/07/2020.
 */
public class RecentLessonModel {
    private String lessonName;
    private String lessonData;

    public RecentLessonModel(String lessonName, String lessonData) {
        this.lessonName = lessonName;
        this.lessonData = lessonData;
    }

    public String getLessonName() {
        return lessonName;
    }

    public void setLessonName(String lessonName) {
        this.lessonName = lessonName;
    }

    public String getLessonData() {
        return lessonData;
    }

    public void setLessonData(String lessonData) {
        this.lessonData = lessonData;
    }
}
