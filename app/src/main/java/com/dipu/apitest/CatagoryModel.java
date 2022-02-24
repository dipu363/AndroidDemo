package com.dipu.apitest;

public class CatagoryModel {


    String l1Name;

    public CatagoryModel() {
    }

    public CatagoryModel(String l1Name) {

        this.l1Name = l1Name;
    }

    public String getL1Name() {
        return l1Name;
    }

    public void setL1Name(String l1Name) {
        this.l1Name = l1Name;
    }

    @Override
    public String toString() {
        return "CatagoryModel{" +
                ", l1Name='" + l1Name + '\'' +
                '}';
    }
}
