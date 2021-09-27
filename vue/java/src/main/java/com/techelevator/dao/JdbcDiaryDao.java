package com.techelevator.dao;

import com.techelevator.exceptions.DiaryNotFoundException;
import com.techelevator.model.Diary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

@Component
public class JdbcDiaryDao implements DiaryDao {

    private JdbcTemplate jdbcTemplate;


    public JdbcDiaryDao(DataSource ds){
        this.jdbcTemplate = new JdbcTemplate(ds);
    }


    @Override
    public Diary getDiaryByDiaryId(int dairyId) throws DiaryNotFoundException {
        Diary diary = null;
        String query = "select diary_id, profile_id from diary where diary_id = ? ;";


        SqlRowSet results = jdbcTemplate.queryForRowSet(query, dairyId);

        if(results.next()){
            diary = mapToDiary(results);
        }else throw new DiaryNotFoundException();

        return diary;
    }

    @Override
    public Diary getDiaryByProfileId(int profileId) throws DiaryNotFoundException {
        Diary diary = null;
        String query = "select diary_id, profile_id from diary where profile_id = ? ;";


        SqlRowSet results = jdbcTemplate.queryForRowSet(query, profileId);

        if(results.next()){
            diary = mapToDiary(results);
        }else throw new DiaryNotFoundException();

        return diary;
    }

    @Override
    public Diary getDiaryByUserId(int userId) throws DiaryNotFoundException {
        Diary diary = null;

        String query = "select diary_id, diaries.profile_id from diary join profiles on diary.profile_id = profiles.profile_id where user_id = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(query, userId);

        if(results.next()){
            diary = mapToDiary(results);
        }else  {
            throw new DiaryNotFoundException();
        }

        return diary;
    }

    @Override
    public Diary createDiary(int profileId) throws DiaryNotFoundException {
        String query = "insert into diary(profile_id) values (?) RETURNING diary_id;";

        int id = jdbcTemplate.queryForObject(query,Integer.class,profileId);
        return getDiaryByDiaryId(id);
    }



    private Diary mapToDiary(SqlRowSet res){
        Diary diary = new Diary();
        diary.setDiaryId(res.getInt("diary_id"));
        diary.setProfileId(res.getInt("profile_id"));


        return diary;
    }
}
