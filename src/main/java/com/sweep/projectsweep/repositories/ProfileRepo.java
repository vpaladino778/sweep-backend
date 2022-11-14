package com.sweep.projectsweep.repositories;

import com.sweep.projectsweep.jooq.tables.Profile;
import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;

public class ProfileRepo {

    @Autowired
    DSLContext context;

    public void createProfile(Profile profile) {
        context.insertInto(Profile.PROFILE)
                .set(Profile.PROFILE.NAME, profile.getName())
                .set(Profile.PROFILE.COUNTRY_ID,)
    }

}
