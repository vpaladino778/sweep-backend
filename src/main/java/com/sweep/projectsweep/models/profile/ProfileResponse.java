package com.sweep.projectsweep.models.profile;


import com.sweep.projectsweep.jooq.tables.pojos.Profile;
import lombok.Data;

@Data
public class ProfileResponse {

    private String id;
    private String name;
    private String description;
    private String linkedinLink;
    private String countryId;
    private String stateProvince;
    private String profileImageLink;

    public ProfileResponse(Profile profile) {
        this.id = profile.getUserUid();
        this.name = profile.getName();
        this.description = profile.getDescription();
        this.linkedinLink = profile.getLinkedinLink();
        this.countryId = profile.getCountryId();
        this.stateProvince = profile.getStateProvince();
        this.profileImageLink = profile.getProfileImageLink();

    }
}
