package com.infotech4It.qazipublicschool.webservices.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.infotech4It.qazipublicschool.view.models.StudentModel;

import java.io.Serializable;

/**
 * Created by Bilal Zaman on 03/08/2020.
 */
public class DataObject implements Serializable {
    @SerializedName("data")
    @Expose
    StudentModel studentModel;

    public StudentModel getStudentModel() {
        return studentModel;
    }

    public void setStudentModel(StudentModel studentModel) {
        this.studentModel = studentModel;
    }
}
