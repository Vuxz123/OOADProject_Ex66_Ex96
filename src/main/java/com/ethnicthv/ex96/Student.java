package com.ethnicthv.ex96;

import com.ethnicthv.ex96.classification.Classification;
import com.ethnicthv.ex96.classification.FulltimeClassification;
import com.ethnicthv.ex96.classification.ParttimeClassification;

@SuppressWarnings("CanBeFinal")
public class Student {
    public String name;
    public String address;
    public String studentID;

    private Classification classification;
    private ResidentInformation residentInformation = null;

    public Student(String name, String address, String studentID, Classification classification) {
        this.name = name;
        this.address = address;
        this.studentID = studentID;
        this.classification = classification;
    }

    public Student(String name, String address, String studentID, Classification classification, ResidentInformation residentInformation) {
        this(name, address, studentID, classification);
        this.residentInformation = residentInformation;
    }

    public boolean isFulltime() {
        return classification instanceof FulltimeClassification;
    }

    public boolean isParttime() {
        return classification instanceof ParttimeClassification;
    }

    public void setClassification(Classification classification) {
        this.classification = classification;
    }

    public Classification getClassification() {
        return classification;
    }

    public ResidentInformation getResidentInformation() {
        return residentInformation;
    }

    public void setResidentInformation(ResidentInformation residentInformation) {
        this.residentInformation = residentInformation;
    }
}
