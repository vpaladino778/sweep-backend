package com.sweep.projectsweep.controllers;

import com.sweep.projectsweep.errors.ApiException;
import com.sweep.projectsweep.errors.ErrorCode;
import com.sweep.projectsweep.jooq.tables.pojos.Profile;
import com.sweep.projectsweep.models.profile.CreateProfileRequest;
import com.sweep.projectsweep.models.profile.ProfileResponse;
import com.sweep.projectsweep.services.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;


@RestController
@RequestMapping("/profile")
public class ProfileController {
    @Autowired
    ProfileService profileService;

    @PostMapping("/")
    public ProfileResponse createOrUpdateProfile(@RequestBody CreateProfileRequest req) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String uid = authentication.getName();

        Profile profile = new Profile(uid,
                                      req.getProfileName(),
                                      req.getProfileDesc(),
                                      req.getLinkedin(),
                                      req.getCountry (),
                                      req.getStateProvince(),
                                      req.getProfileImageLink());

        profileService.createOrUpdateProfile(profile);
        return new ProfileResponse(profile);
    }

    @GetMapping("/{profileId}")
    public ProfileResponse getProfile(@PathVariable String profileId) {
        return new ProfileResponse(profileService.getProfile(profileId));
    }
}
