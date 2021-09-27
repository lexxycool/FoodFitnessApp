package com.techelevator.dao;

import com.techelevator.model.Profile;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class JdbcProfileDao implements ProfileDao{
    private JdbcTemplate jdbcTemplate;

    public JdbcProfileDao(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

   @Override
    public Profile saveProfile() {
        Profile profile = null;
            String sql = "INSERT INTO profiles (profile_id, user_id, first_name, last_name, age, height, " +
                    "current_weight, goal_weight, birthday, profile_picture)" +
                    "VALUES (1, 1, ?, ?, ?, ?, ?, ?, ?, ?)";
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql);

            if(results.next()){
                profile = mapToRowProfiles(results);
            }
            return profile;
    }

    @Override
    public Profile getProfile(int id) {
        Profile profile = null;
        String sql = "SELECT * FROM profiles WHERE profile_id = ?";
        SqlRowSet result = jdbcTemplate.queryForRowSet(sql, id);

        if(result.next()){
            profile = mapToRowProfiles(result);
        }
        return profile;
    }

    @Override
    public List<Profile> listOfProfiles() {
        return null;
    }

    @Override
    public Profile updateProfile(int id) {
        Profile updatedProfile = getProfile(id);
        String sql = "UPDATE profiles SET first_name, last_name, age, height, current_weight, goal_weight, birthday, profile_picture =" +
                " ?, ?, ?, ?, ?, ?, ?, ? WHERE profile_id = ?";
        jdbcTemplate.update(sql, updatedProfile);
        return  updatedProfile;
    }

    private Profile mapToRowProfiles(SqlRowSet results){
        Profile profile = new Profile();
        profile.setProfile_id(results.getInt("profile_id"));
        profile.setUser_id(results.getInt("user_id"));
        profile.setFirstName(results.getString("first_name"));
        profile.setLastName(results.getString("last_name"));
        profile.setAge(results.getInt("age"));
        profile.setHeight(results.getString("height"));
        profile.setCurrentWeight(results.getDouble("current_weight"));
        profile.setGoalWeight(results.getDouble("goal_weight"));
        profile.setBirthday(results.getString("birthday"));
        profile.setProfilePicture(results.getString("profile_picture"));

        return profile;
    }


}
