package com.sweep.projectsweep.models.availability;

import lombok.Getter;
import lombok.experimental.Delegate;

import java.util.List;

@Getter
public class AddAvailabilityRequest {
    private Integer mentorId;
    @Delegate
    private List<Availability> availabilityList;

    @Getter
    public static class Availability {
        private String startTime;
        private String endTime;
    }
}