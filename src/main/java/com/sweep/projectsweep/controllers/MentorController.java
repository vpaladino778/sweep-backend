package com.sweep.projectsweep.controllers;

import com.google.firebase.auth.UserRecord;
import com.sweep.projectsweep.jooq.tables.pojos.Mentor;
import com.sweep.projectsweep.models.user.CreateUserRequest;
import com.sweep.projectsweep.services.UserManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/mentor")
public class MentorController {

    @Autowired
    UserManagementService userManagementService;

    @GetMapping("/mentors")
    public List<Mentor> getMentors() {
        return new ArrayList<>();
    }

    @GetMapping("/mentor/{user_uid}")
    public Mentor getMentor(@RequestParam String user_uid) {
        return null;
    }

    @PostMapping("/mentor")
    public Mentor createMentor(@RequestBody CreateUserRequest createUserRequest) {
        return userManagementService.createMentor(createUserRequest.getEmail(), createUserRequest.toFirebaseCreateRequest());
    }
}
