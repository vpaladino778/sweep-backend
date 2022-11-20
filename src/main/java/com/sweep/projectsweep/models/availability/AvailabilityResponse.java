package com.sweep.projectsweep.models.availability;

import com.sweep.projectsweep.jooq.tables.pojos.Availability;
import lombok.Data;

import java.util.List;

@Data
public class AvailabilityResponse {
    private Integer mentorId;
    private List<Availability> availabilityList;
    public AvailabilityResponse(Integer mentorId, List<Availability> availabilityList){
        this.mentorId = mentorId;
        this.availabilityList = availabilityList;
    }
}
