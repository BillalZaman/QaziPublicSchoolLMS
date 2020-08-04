package com.infotech4It.qazipublicschool.webservices.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.infotech4It.qazipublicschool.view.models.BranchModel;
import com.infotech4It.qazipublicschool.view.models.StudentModel;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Bilal Zaman on 03/08/2020.
 */
public class DataObject implements Serializable {
    @SerializedName("UserData")
    @Expose
    StudentModel studentModel;

    public StudentModel getStudentModel() {
        return studentModel;
    }

    public void setStudentModel(StudentModel studentModel) {
        this.studentModel = studentModel;
    }

    @SerializedName("Brancheslist")
    @Expose
    private List<BranchModel> branchModelList = null;

    public List<BranchModel> getBranchModelList() {
        return branchModelList;
    }

    public void setBranchModelList(List<BranchModel> branchModelList) {
        this.branchModelList = branchModelList;
    }
}
