package com.sweep.projectsweep.models;

import lombok.Data;

@Data
public class CreateProfileRequest {


    String profileName;
    String profileDesc;

}


/**
 * {
 *     profileName: 'Vincent Paladino',
 *     profileDesc: 'Profile descrption!!'
 * }
 *
 */