package com.example.calculator;

import android.os.Parcel;
import android.os.Parcelable;

public class Calculator implements Parcelable {

    public Calculator() {

    }

    protected Calculator(Parcel in) {
        firstOperand = in.readDouble();
        secondOperand = in.readDouble();
        action = in.readString();
    }

    public static final Creator<Calculator> CREATOR = new Creator<Calculator>() {
        @Override
        public Calculator createFromParcel(Parcel in) {
            return new Calculator(in);
        }

        @Override
        public Calculator[] newArray(int size) {
            return new Calculator[size];
        }
    };

    public double getFirstOperand() {
        return firstOperand;
    }

    public void setFirstOperand(double firstOperand) {
        this.firstOperand = firstOperand;
    }

    public double getSecondOperand() {
        return secondOperand;
    }

    public void setSecondOperand(double secondOperand) {
        this.secondOperand = secondOperand;
    }

    private double firstOperand = 0;
    private double secondOperand = 0;

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    private String action;

    public double division() {
        return firstOperand / secondOperand;
    }

    public double percent() {
        return (firstOperand * secondOperand) / 100;
    }

    public double multiplication() {
        return firstOperand * secondOperand;
    }

    public double addition() {
        return firstOperand + secondOperand;
    }

    public double subtraction() {
        return firstOperand - secondOperand;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeDouble(firstOperand);
        parcel.writeDouble(secondOperand);
        parcel.writeString(action);
    }
}
