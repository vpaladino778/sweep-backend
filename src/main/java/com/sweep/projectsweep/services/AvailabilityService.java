package com.sweep.projectsweep.services;

import com.sweep.projectsweep.jooq.tables.pojos.Availability;
import com.sweep.projectsweep.jooq.tables.pojos.Profile;
import com.sweep.projectsweep.repositories.AvailabilityRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AvailabilityService {
    @Autowired
    AvailabilityRepo availabilityRepo;
    public void addAvailability(List<Availability> availability){
        availabilityRepo.addAvailability(availability);
    }

    public List<Availability> getAvailability(Integer mentorId) {
        return availabilityRepo.getAvailability(mentorId);
    }
}
