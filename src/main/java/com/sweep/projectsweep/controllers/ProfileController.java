package com.sweep.projectsweep.controllers;

import com.sweep.projectsweep.errors.ApiException;
import com.sweep.projectsweep.errors.ErrorCode;
import com.sweep.projectsweep.jooq.tables.pojos.Profile;
import com.sweep.projectsweep.models.profile.CreateProfileRequest;
import com.sweep.projectsweep.models.profile.ProfileResponse;
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
    public ProfileResponse createProfile(@RequestBody CreateProfileRequest req) {
        Profile profile = new Profile(null, req.getProfileName(), req.getProfileDesc(), req.getLinkedin(), req.getCountry(), req.getStateProvince(), req.getProfileImageLink());
        profileService.createProfile(profile);
        return new ProfileResponse(profile);
    }

    @GetMapping("/{profileId}")
    public ProfileResponse getProfile(@PathVariable String profileId) {
        int profileIdParsed;
        try {
            profileIdParsed = Integer.parseInt(profileId);
        } catch (NumberFormatException e) {
            throw new ApiException(ErrorCode.PROFILE_001, profileId, e);
        }
        return new ProfileResponse(profileService.getProfile(Integer.parseInt(profileId)));
    }
}
