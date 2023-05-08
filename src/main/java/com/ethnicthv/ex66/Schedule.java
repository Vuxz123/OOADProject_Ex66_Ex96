package com.ethnicthv.ex66;

import java.util.List;
import java.util.UUID;

public class Schedule {
    private final PrimaryScheduleOfferingInfob.PSOIList primaryScheduleOfferingInfo = new PrimaryScheduleOfferingInfob.PSOIList();
    private final CourseOffering.COList alternateCourses = new CourseOffering.COList();

    @SuppressWarnings("FieldCanBeLocal")
    private final UUID uuid;

    public Schedule() {
        this.uuid = UUID.randomUUID();
    }

    public Schedule(CourseOffering courseOffering1, CourseOffering courseOffering2) {
        this();
        this.addCourseOffering(courseOffering1);
        this.addCourseOffering(courseOffering2);
    }

    public Schedule(CourseOffering courseOffering) {
        this();
        this.addCourseOffering(courseOffering);
    }

    public void addCourseOffering(CourseOffering courseOffering) {
        if (alternateCourses.addCO(this, courseOffering)) {
            var temp = primaryScheduleOfferingInfo.newPSOI(courseOffering);
            //push temp to controller for updating//
        }
    }

    public boolean hasAnyCourseOffering() {
        return this.alternateCourses.hasAny();
    }

    public boolean hasCourseOffering(CourseOffering courseOffering) {
        return this.alternateCourses.hasCO(courseOffering);
    }

    public List<PrimaryScheduleOfferingInfob> getPSOIOf(CourseOffering courseOffering) {
        if (!hasCourseOffering(courseOffering)) return null;
        return this.primaryScheduleOfferingInfo.getPSOIof(courseOffering);
    }
}
