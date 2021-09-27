package com.techelevator.dao;

import com.techelevator.model.Profile;
import org.junit.Before;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.junit.Assert;

import javax.sql.DataSource;

public class JdbcProfileDaoTests extends FinalCapstoneDaoTests {

    private static final Profile PROFILE_A = new Profile(1,2,"Bob",
            "Smore", 37, "6'4", 184.5,
            196.7, "03/26/1994", null);
    private static final Profile PROFILE_B = new Profile(3,5,"Samantha",
            "Foxy", 27, "5'4", 124.5,
            116.7, "01/16/1914", null);

    private JdbcProfileDao sut;

    @Before
    public void setup() {
        DataSource dataSource = this.getDataSource();
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        sut = new JdbcProfileDao(jdbcTemplate);
    }

    @Test
    public void saveProfile_returns_profile(){

    }
    @Test
    public void getProfile_returns_correct_profile_id(){
    Profile profile = sut.getProfile(3);

    }
    @Test
    public void updateProfile_returns_updated_profile_by_id(){

    }
    //saveProfile returns profile
    //getProfile returns correct profile for ID
    //updateProfile returns updated profile by ID


    private void assertProfileMatch(Profile expected, Profile actual){
        Assert.assertEquals(expected.getProfile_id(), actual.getProfile_id());
        Assert.assertEquals(expected.getUser_id(), actual.getUser_id());
        Assert.assertEquals(expected.getFirstName(), actual.getFirstName());
        Assert.assertEquals(expected.getLastName(), actual.getLastName());
        Assert.assertEquals(expected.getAge(), actual.getAge());
        Assert.assertEquals(expected.getHeight(), actual.getHeight());
        Assert.assertEquals(expected.getCurrentWeight(), actual.getCurrentWeight());
        Assert.assertEquals(expected.getGoalWeight(), actual.getGoalWeight());

    }



}

