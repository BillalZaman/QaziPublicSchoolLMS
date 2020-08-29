package com.infotech4It.qazipublicschool.view.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by Bilal Zaman on 27/07/2020.
 */
public class MCQsAnswerModel implements Serializable {
    @SerializedName("Id")
    @Expose
    private Integer id;
    @SerializedName("Ans")
    @Expose
    private String ans;

    public MCQsAnswerModel(Integer id, String ans) {
        this.id = id;
        this.ans = ans;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAns() {
        return ans;
    }

    public void setAns(String ans) {
        this.ans = ans;
    }
}
