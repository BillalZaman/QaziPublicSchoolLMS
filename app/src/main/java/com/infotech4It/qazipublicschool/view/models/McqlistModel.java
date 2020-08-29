package com.infotech4It.qazipublicschool.view.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Bilal Zaman on 28/08/2020.
 */
public class McqlistModel implements Serializable {
    @SerializedName("user_id")
    @Expose
    private Integer userId;
    @SerializedName("test_id")
    @Expose
    private Integer testId;
    @SerializedName("answer")
    @Expose
    private List<MCQsAnswerModel> answer = null;

    public McqlistModel(Integer userId, Integer testId, List<MCQsAnswerModel> answer) {
        this.userId = userId;
        this.testId = testId;
        this.answer = answer;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getTestId() {
        return testId;
    }

    public void setTestId(Integer testId) {
        this.testId = testId;
    }

    public List<MCQsAnswerModel> getAnswer() {
        return answer;
    }

    public void setAnswer(List<MCQsAnswerModel> answer) {
        this.answer = answer;
    }
}

