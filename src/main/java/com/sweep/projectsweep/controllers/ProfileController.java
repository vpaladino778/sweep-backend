package com.sweep.projectsweep.controllers;

import com.sweep.projectsweep.errors.ApiException;
import com.sweep.projectsweep.errors.ErrorCode;
import com.sweep.projectsweep.jooq.tables.pojos.Profile;
import com.sweep.projectsweep.models.CreateProfileRequest;
import com.sweep.projectsweep.repositories.ProfileRepo;
import com.sweep.projectsweep.services.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

        if(profileId.equals("1")) {
            throw new ApiException(ErrorCode.PROFILE_001, profileId);
        }

        return new Profile(2, "ExampleString", "exampleDesc", "linkedin.com", "USA", "NY", "https://ichef.bbci.co.uk/news/976/cpsprodpb/16620/production/_91408619_55df76d5-2245-41c1-8031-07a4da3f313f.jpg" );

    }
}
