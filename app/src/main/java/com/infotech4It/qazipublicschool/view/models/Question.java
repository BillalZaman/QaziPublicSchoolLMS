package com.infotech4It.qazipublicschool.view.models;

public class Question {

    private String question;
    private String opA;
    private String opB;
    private String opC;
    private String opD;

    public Question(String question, String opA, String opB, String opC, String opD) {
        this.question = question;
        this.opA = opA;
        this.opB = opB;
        this.opC = opC;
        this.opD = opD;
    }


    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getOpA() {
        return opA;
    }

    public void setOpA(String opA) {
        this.opA = opA;
    }

    public String getOpB() {
        return opB;
    }

    public void setOpB(String opB) {
        this.opB = opB;
    }

    public String getOpC() {
        return opC;
    }

    public void setOpC(String opC) {
        this.opC = opC;
    }

    public String getOpD() {
        return opD;
    }

    public void setOpD(String opD) {
        this.opD = opD;
    }
}
