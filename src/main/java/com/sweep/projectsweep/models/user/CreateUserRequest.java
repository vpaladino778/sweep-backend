package com.sweep.projectsweep.models.user;

import com.google.firebase.auth.UserRecord;
import lombok.Getter;

@Getter
public class CreateUserRequest {

    String email;

    String displayName;

    String password;

    public UserRecord.CreateRequest toFirebaseCreateRequest() {
        UserRecord.CreateRequest firebaseCreateUserRequest = new UserRecord.CreateRequest();
        firebaseCreateUserRequest.setEmail(getEmail());
        firebaseCreateUserRequest.setDisplayName(getDisplayName());
        firebaseCreateUserRequest.setPassword(getPassword());
        return firebaseCreateUserRequest;
    }

}
