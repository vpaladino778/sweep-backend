package com.sweep.projectsweep.controllers;

import com.sweep.projectsweep.jooq.tables.pojos.Profile;
import com.sweep.projectsweep.models.CreateProfileRequest;
import com.sweep.projectsweep.services.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/profile")
public class ProfileController {
    @Autowired
    ProfileService profileService;

    @PostMapping("/")
    public String createProfile(@RequestBody CreateProfileRequest req) {
        Profile profile = new Profile(null, req.getProfileName(), req.getProfileDesc(), req.getLinkedin(), req.getCountry(), req.getStateProvince(), req.getProfileImageLink());
        profileService.createProfile(profile);
        return "Greetings from Spring Boot!";
    }
}
