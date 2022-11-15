package com.sweep.projectsweep.repositories;

import com.sweep.projectsweep.jooq.tables.pojos.Profile;
import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import static com.sweep.projectsweep.jooq.Tables.PROFILE;

@Repository
public class ProfileRepo {

    @Autowired
    DSLContext context;

    public void createProfile(Profile profile) {
        context.insertInto(PROFILE)
                .set(PROFILE.NAME, profile.getName())
                .set(PROFILE.COUNTRY_ID, profile.getCountryId())
                .execute(); // TODO: Finish adding other fields
    }

}
