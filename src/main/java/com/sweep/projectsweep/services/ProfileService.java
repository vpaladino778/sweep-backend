package com.sweep.projectsweep.services;
import com.sweep.projectsweep.jooq.tables.pojos.Profile;
import com.sweep.projectsweep.repositories.ProfileRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProfileService {

    @Autowired
    ProfileRepo profileRepo;

    public void createProfile(Profile profile) {
        profileRepo.createProfile(profile);
    }
}
