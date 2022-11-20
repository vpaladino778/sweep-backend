package com.sweep.projectsweep.controllers;

import com.sweep.projectsweep.errors.ApiException;
import com.sweep.projectsweep.errors.ErrorCode;
import com.sweep.projectsweep.jooq.tables.pojos.Availability;
import com.sweep.projectsweep.models.availability.AddAvailabilityRequest;
import com.sweep.projectsweep.models.availability.AvailabilityResponse;
import com.sweep.projectsweep.models.profile.ProfileResponse;
import com.sweep.projectsweep.services.AvailabilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/availability")
public class AvailabilityController {
    @Autowired
    AvailabilityService availabilityService;
    @PostMapping("/")
    public AvailabilityResponse addAvailability(@RequestBody AddAvailabilityRequest req){
        List<Availability> availabilityListPojos = new ArrayList<Availability>();
        List<AddAvailabilityRequest.Availability> availabilityList = req.getAvailabilityList();
        for (AddAvailabilityRequest.Availability availability : availabilityList) {
            LocalDateTime start_time = LocalDateTime.parse(availability.getStartTime());
            LocalDateTime end_time = LocalDateTime.parse(availability.getEndTime());
            availabilityListPojos.add(new Availability(null,
                                                      req.getMentorId(),
                                                      start_time,
                                                      end_time));
        }
        availabilityService.addAvailability(availabilityListPojos);
        return new AvailabilityResponse(req.getMentorId(), availabilityListPojos);
    }

    @GetMapping("/{mentorId}")
    public AvailabilityResponse getAvailability(@PathVariable String mentorId){
        int mentorIdParsed;
        try {
            mentorIdParsed = Integer.parseInt(mentorId);
        } catch (NumberFormatException e) {
            throw new ApiException(ErrorCode.AVAILABILITY_001, mentorId, e);
        }
        return new AvailabilityResponse(mentorIdParsed, availabilityService.getAvailability(mentorIdParsed));
    }

}
