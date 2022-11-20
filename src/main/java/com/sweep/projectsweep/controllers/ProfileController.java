package com.sweep.projectsweep.controllers;

import com.sweep.projectsweep.errors.ApiException;
import com.sweep.projectsweep.errors.ErrorCode;
import com.sweep.projectsweep.jooq.tables.pojos.Profile;
import com.sweep.projectsweep.models.profile.CreateProfileRequest;
import com.sweep.projectsweep.services.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;

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

    @GetMapping("/{profileId}")
    public Profile getProfile(@PathVariable String profileId) {
        Integer profileIdParsed;
        try {
            profileIdParsed = Integer.parseInt(profileId);
        } catch (NumberFormatException e) {
            throw new ApiException(ErrorCode.PROFILE_001, profileId, e);
        }

        return profileService.getProfile(Integer.parseInt(profileId));

    }
}
