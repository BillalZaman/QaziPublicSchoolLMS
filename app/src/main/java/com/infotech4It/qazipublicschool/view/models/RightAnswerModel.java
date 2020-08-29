package com.infotech4It.qazipublicschool.view.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by Bilal Zaman on 27/08/2020.
 */
public class RightAnswerModel implements Serializable {
    @SerializedName("question_id")
    @Expose
    private Integer questionId;
    @SerializedName("a_eng")
    @Expose
    private String aEng;
    @SerializedName("a_urdu")
    @Expose
    private String aUrdu;

    public Integer getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Integer questionId) {
        this.questionId = questionId;
    }

    public String getaEng() {
        return aEng;
    }

    public void setaEng(String aEng) {
        this.aEng = aEng;
    }

    public String getaUrdu() {
        return aUrdu;
    }

    public void setaUrdu(String aUrdu) {
        this.aUrdu = aUrdu;
    }
}
