package com.sweep.projectsweep.services;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.auth.AuthErrorCode;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.UserRecord;
import com.sweep.projectsweep.errors.ApiException;
import com.sweep.projectsweep.errors.ErrorCode;
import com.sweep.projectsweep.jooq.tables.pojos.Mentor;
import com.sweep.projectsweep.jooq.tables.pojos.User;
import com.sweep.projectsweep.repositories.MentorRepository;
import com.sweep.projectsweep.repositories.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
@Slf4j
public class UserManagementService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    MentorRepository mentorRepository;

    @PostConstruct
    private void initializeFirebase() {
        try {
            FileInputStream serviceAccount =
                    new FileInputStream("service-account-file.json");

            FirebaseOptions options =  FirebaseOptions.builder()
                    .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                    .build();
            FirebaseApp.initializeApp(options);

        } catch (Exception e) {
            log.error("Error initializing firebase in AdminService", e);
        }
    }

    public Mentor createMentor(String email, UserRecord.CreateRequest createRequest) {
        UserRecord record = null;
        try {
            record = FirebaseAuth.getInstance().createUser(createRequest);
            setCustomClaims(record.getUid(), "mentor");
        } catch (FirebaseAuthException e) {

            throw new ApiException(ErrorCode.USER_MANAGEMENT_001, email, e);
        }
        Mentor createMentorRequest = new Mentor(record.getUid(), record.getEmail());

        return mentorRepository.createOrUpdateMentor(createMentorRequest);
    }

    public User createUser(String email, UserRecord.CreateRequest createRequest) {
        UserRecord record = null;
        try {
            record = FirebaseAuth.getInstance().createUser(createRequest);
        } catch (FirebaseAuthException e) {
            throw new ApiException(ErrorCode.USER_MANAGEMENT_001, email);
        }
        User createUserRequest = new User(record.getUid(), record.getEmail());

        return userRepository.createOrUpdateUser(createUserRequest);
    }


    private void setCustomClaims(String userId, String claim) throws FirebaseAuthException {
        Map<String, Object> claims = new HashMap<>();
        claims.put(claim, true);

        FirebaseAuth.getInstance().setCustomUserClaims(userId, claims);
    }

}
