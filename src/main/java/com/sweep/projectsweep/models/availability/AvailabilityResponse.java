package com.sweep.projectsweep.models.availability;

import com.sweep.projectsweep.jooq.tables.pojos.Availability;
import lombok.Data;

import java.util.List;

@Data
public class AvailabilityResponse {
    private String mentorId;
    private List<Availability> availability;
    public AvailabilityResponse(String mentorId, List<Availability> availabilityList){
        this.mentorId = mentorId;
        this.availability = availabilityList;
    }
}
