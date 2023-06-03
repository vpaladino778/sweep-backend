package com.sweep.projectsweep.controllers;


import com.sweep.projectsweep.jooq.tables.pojos.User;
import com.sweep.projectsweep.models.user.CreateUserRequest;
import com.sweep.projectsweep.services.UserManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserManagementService userManagementService;

    @GetMapping("/{user_uid}")
    public User getUser(@RequestParam String user_uid) {
        return null;
    }

    @PostMapping
    public User createUser(@RequestBody CreateUserRequest createUserRequest) {
        return userManagementService.createUser(createUserRequest.getEmail(), createUserRequest.toFirebaseCreateRequest());
    }

}
