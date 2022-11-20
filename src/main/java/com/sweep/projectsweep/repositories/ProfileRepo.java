package com.sweep.projectsweep.repositories;

import com.sweep.projectsweep.errors.ApiException;
import com.sweep.projectsweep.errors.ErrorCode;
import com.sweep.projectsweep.jooq.tables.pojos.Profile;
import com.sweep.projectsweep.jooq.tables.records.ProfileRecord;
import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import static com.sweep.projectsweep.jooq.Tables.PROFILE;

@Repository
public class ProfileRepo {

    @Autowired
    DSLContext context;

    public void createProfile(Profile profile) {
        context.insertInto(PROFILE).set(PROFILE.NAME, profile.getName()).set(PROFILE.DESCRIPTION, profile.getDescription()).set(PROFILE.LINKEDIN_LINK, profile.getLinkedinLink()).set(PROFILE.COUNTRY_ID, profile.getCountryId()).set(PROFILE.STATE_PROVINCE, profile.getStateProvince()).set(PROFILE.PROFILE_IMAGE_LINK, profile.getProfileImageLink()).execute(); // TODO: Finish adding other fields
    }

    @Transactional(readOnly = true)
    public Profile getProfile(Integer id) {
        ProfileRecord result = context.selectFrom(PROFILE).where(PROFILE.ID.eq(id)).fetchOne();

        if (result == null) {
            throw new ApiException(ErrorCode.PROFILE_001, String.valueOf(id));
        }

        return result.into(Profile.class);
    }

}
