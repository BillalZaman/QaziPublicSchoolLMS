package com.infotech4It.qazipublicschool.view.models;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Bilal Zaman on 27/07/2020.
 */
public class MCQsModel {
    private String mcqsQuestion;
    private List<MCQsAnswerModel> answerModelList = new ArrayList<>();

    public MCQsModel(String mcqsQuestion, List<MCQsAnswerModel> answerModelList) {
        this.mcqsQuestion = mcqsQuestion;
        this.answerModelList = answerModelList;
    }

    public String getMcqsQuestion() {
        return mcqsQuestion;
    }

    public void setMcqsQuestion(String mcqsQuestion) {
        this.mcqsQuestion = mcqsQuestion;
    }

    public List<MCQsAnswerModel> getAnswerModelList() {
        return answerModelList;
    }

    public void setAnswerModelList(List<MCQsAnswerModel> answerModelList) {
        this.answerModelList = answerModelList;
    }
}
