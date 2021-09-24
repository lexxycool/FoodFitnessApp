package com.techelevator.dao;

import com.techelevator.model.Profile;
import org.springframework.stereotype.Component;

import java.util.List;


public interface ProfileDao{
    Profile saveProfile();
    Profile getProfile(int id);
    List<Profile> listOfProfiles();
    Profile updateProfile(int id);

}
