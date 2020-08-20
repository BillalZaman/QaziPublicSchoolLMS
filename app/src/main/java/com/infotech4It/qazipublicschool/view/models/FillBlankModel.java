package com.infotech4It.qazipublicschool.view.models;

/**
 * Created by Bilal Zaman on 29/07/2020.
 */
public class FillBlankModel {
    private String question;
    private String answer;

    public FillBlankModel(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }
}
