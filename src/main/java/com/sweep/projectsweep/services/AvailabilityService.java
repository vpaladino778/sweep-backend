package com.sweep.projectsweep.services;

import com.sweep.projectsweep.jooq.tables.pojos.Availability;
import com.sweep.projectsweep.jooq.tables.pojos.Profile;
import com.sweep.projectsweep.jooq.tables.records.AvailabilityRecord;
import com.sweep.projectsweep.repositories.AvailabilityRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.sweep.projectsweep.jooq.Tables.AVAILABILITY;

@Service
public class AvailabilityService {
    @Autowired
    AvailabilityRepo availabilityRepo;
    public void addAvailability(List<Availability> availability){
        availabilityRepo.addAvailability(availability);
    }

    public void setAvailability(String mentorId, List<Availability> availability) {
        List<AvailabilityRecord> recordList = availability.stream().map(AvailabilityRecord::new).toList();

        availabilityRepo.setAvailability(mentorId, recordList);
    }

    public List<Availability> getAvailability(String mentorId) {
        return availabilityRepo.getAvailability(mentorId);
    }
}
