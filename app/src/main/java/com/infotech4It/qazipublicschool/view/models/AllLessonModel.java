package com.infotech4It.qazipublicschool.view.models;

/**
 * Created by Bilal Zaman on 18/07/2020.
 */
public class AllLessonModel {
    private String lessonName;

    public AllLessonModel(String lessonName) {
        this.lessonName = lessonName;
    }

    public String getLessonName() {
        return lessonName;
    }

    public void setLessonName(String lessonName) {
        this.lessonName = lessonName;
    }
}
