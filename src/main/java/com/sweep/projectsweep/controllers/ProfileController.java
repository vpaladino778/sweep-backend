package com.sweep.projectsweep.controllers;

import com.sweep.projectsweep.models.CreateProfileRequest;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/profile")
public class ProfileController {

    @PostMapping("/")
    public String createProfile(@RequestBody CreateProfileRequest createProfileRequest) {
        System.out.println(createProfileRequest.profileName);
        return "Greetings from Spring Boot!";
    }
}
