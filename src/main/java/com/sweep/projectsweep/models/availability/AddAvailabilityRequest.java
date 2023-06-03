package com.sweep.projectsweep.models.availability;

import lombok.Getter;
import lombok.experimental.Delegate;

import java.util.List;

@Getter
public class AddAvailabilityRequest {
    private String mentorId;
    @Delegate
    private List<Availability> availability;

    @Getter
    public static class Availability {
        private String startTime;
        private String endTime;
    }
}