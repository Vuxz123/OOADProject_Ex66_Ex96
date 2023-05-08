package com.ethnicthv.ex66;

import java.util.ArrayList;
import java.util.List;

public class CourseOffering {

    private final List<Schedule> schedules = new ArrayList<>();

    private String courseName = "";

    public CourseOffering(String courseName) {
        this.courseName = courseName;
    }

    public boolean hasAnySchedule() {
        return schedules.size() != 0;
    }

    public List<Schedule> getSchedules() {
        return schedules;
    }

    public String getCourseName() {
        return courseName;
    }

    public static class S {
        public static CourseOffering MATH = new CourseOffering("math");
        public static CourseOffering PHYSIC = new CourseOffering("physic");
    }

    public static class COList {
        private final List<CourseOffering> courseOfferingList = new ArrayList<>();

        public COList() {
        }

        public boolean addCO(Schedule schedule, CourseOffering courseOffering) {
            if(this.hasCO(courseOffering)) return true;
            if(courseOfferingList.size() >= 2) return false;
            this.courseOfferingList.add(courseOffering);
            courseOffering.schedules.add(schedule);
            return true;
        }

        public boolean hasAny() {
            return !this.courseOfferingList.isEmpty();
        }

        public boolean hasCO(CourseOffering courseOffering) {
            return this.courseOfferingList.contains(courseOffering);
        }
    }
}
