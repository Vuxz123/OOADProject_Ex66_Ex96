package com.ethnicthv.ex66;

import java.util.ArrayList;
import java.util.List;

public class PrimaryScheduleOfferingInfob {
    private int grade;
    private final CourseOffering theCourseOffering;
    private boolean enrolled = false;
    private boolean committed = false;

    private PrimaryScheduleOfferingInfob(CourseOffering theCourseOffering) {
        this.grade = 1;
        this.theCourseOffering = theCourseOffering;
    }

    private PrimaryScheduleOfferingInfob(int grade, CourseOffering theCourseOffering) {
        this.grade = grade;
        this.theCourseOffering = theCourseOffering;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public boolean isEnrolled() {
        return enrolled;
    }

    public void markEnrolled() {
        this.enrolled = true;
    }

    public boolean isCommitted() {
        return committed;
    }

    public void markCommitted() {
        this.committed = true;
    }

    public static class PSOIList {
        private final List<PrimaryScheduleOfferingInfob> primaryScheduleOfferingInfobList = new ArrayList<>();

        public PSOIList() {
        }

        public PrimaryScheduleOfferingInfob newPSOI(CourseOffering theCourseOffering) {
            if (primaryScheduleOfferingInfobList.size() >= 4) return null;
            var temp = new PrimaryScheduleOfferingInfob(theCourseOffering);
            primaryScheduleOfferingInfobList.add(temp);
            return temp;
        }

        public List<PrimaryScheduleOfferingInfob> getPSOIof(CourseOffering courseOffering) {
            return primaryScheduleOfferingInfobList.size() == 0 ?
                    null
                    :
                    primaryScheduleOfferingInfobList
                            .stream()
                            .filter(psoi -> psoi.theCourseOffering == courseOffering)
                            .toList();
        }

        public List<PrimaryScheduleOfferingInfob> getPrimaryScheduleOfferingInfobList() {
            return primaryScheduleOfferingInfobList;
        }
    }
}
