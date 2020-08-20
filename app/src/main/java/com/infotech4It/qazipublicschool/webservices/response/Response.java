package com.infotech4It.qazipublicschool.webservices.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by Bilal Zaman on 03/08/2020.
 */
public class Response implements Serializable {
    @SerializedName("code")
    @Expose
    private int code;
    @SerializedName("data")
    @Expose
    private DataObject dataObject;
    @SerializedName("status")
    @Expose
    private Boolean status;
    @SerializedName("messages")
    @Expose
    private String message;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public DataObject getDataObject() {
        return dataObject;
    }

    public void setDataObject(DataObject dataObject) {
        this.dataObject = dataObject;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
