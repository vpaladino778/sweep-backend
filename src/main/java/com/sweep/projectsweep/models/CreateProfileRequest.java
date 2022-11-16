package com.sweep.projectsweep.models;

import lombok.Getter;
import lombok.experimental.Delegate;

import java.util.List;

@Getter
public class CreateProfileRequest {
    private String profileName;
    private String profileDesc;
    private String github;
    private String linkedin;
    private String personal;
    private String twitter;
    private String country;
    private String stateProvince;
    private String profileImageLink;
    @Delegate
    private List<UserSkills> skills;

    @Getter
    static class UserSkills {
        private String name;
        private String description;
    }


}

