package com.sweep.projectsweep.controllers;

import com.sweep.projectsweep.jooq.tables.pojos.Availability;
import com.sweep.projectsweep.models.availability.AddAvailabilityRequest;
import com.sweep.projectsweep.models.availability.AvailabilityResponse;
import com.sweep.projectsweep.services.AvailabilityService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Slf4j
@RestController
@RequestMapping("/availability")
public class AvailabilityController {
    @Autowired
    AvailabilityService availabilityService;

    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.US);

    @PostMapping
    public AvailabilityResponse addAvailability(@RequestBody AddAvailabilityRequest req) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        List<Availability> availabilityListPojos = new ArrayList<>();
        List<AddAvailabilityRequest.Availability> availabilityList = req.getAvailability();

        for (AddAvailabilityRequest.Availability availability : availabilityList) {
            LocalDateTime startTime = LocalDateTime.parse(availability.getStartTime(), formatter);
            LocalDateTime endTime = LocalDateTime.parse(availability.getEndTime(), formatter);
            availabilityListPojos.add(new Availability(null,
                                                       authentication.getName(),
                                                       startTime,
                                                       endTime));
        }

        availabilityService.addAvailability(availabilityListPojos);
        return new AvailabilityResponse(authentication.getName(), availabilityListPojos);
    }

    @GetMapping
    public AvailabilityResponse getAvailability() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        AvailabilityResponse res =  new AvailabilityResponse(authentication.getName(), availabilityService.getAvailability(authentication.getName()));

        log.info(res.getAvailability().toString());
        return res;
    }

}
