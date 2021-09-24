package com.techelevator.dao;

import com.techelevator.model.DiaryMealEntry;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcDiaryMealEntryDao implements DiaryMealEntryDao {

    private JdbcTemplate jdbcTemplate;


    public JdbcDiaryMealEntryDao(DataSource ds){
        this.jdbcTemplate = new JdbcTemplate(ds);
    }

    @Override
    public DiaryMealEntry create(DiaryMealEntry entry) {
        String query = "insert into diary_meal_entries (diary_id, diary_meal_entry_date, diary_meal_type_id, food_id, serving_size, number_of_servings) values(?,?,?,?,?,?) RETURNING diary_meal_entry_id;";

        int id = jdbcTemplate.queryForObject(query,Integer.class, entry.getDiaryId(),entry.getDiaryMealEntryDate(),entry.getDiaryMealTypeId(),entry.getFoodId(),entry.getServingSize(),entry.getNumberOfServings());

        return getMealEntryByEntryId(id);
    }

    @Override
    public DiaryMealEntry getMealEntryByEntryId(int entryId) {
        DiaryMealEntry entry =  null;

        String query = "select diary_meal_entry_id , diary_id ,diary_meal_entry_date, diary_meal_type_id, food_id , serving_size, number_of_servings from diary_meal_entries where diary_meal_entry_id = ?;";

        SqlRowSet result = jdbcTemplate.queryForRowSet(query,entryId);

        if(result.next()){
           entry = mapToEntry(result);
        }
        return entry;
    }

    @Override
    public List<DiaryMealEntry> getEntriesByDairyIdAndDate(int dairyId, LocalDate date) {
        List<DiaryMealEntry> entries = new ArrayList<>();


        String query = "select diary_meal_entry_id , diary_id ,diary_meal_entry_date, diary_meal_type_id, food_id , serving_size, number_of_servings from diary_meal_entries where diary_id = ? and diary_meal_entry_date = ? ;";

        SqlRowSet result = jdbcTemplate.queryForRowSet(query,dairyId,date);

        while(result.next()){
            entries.add(mapToEntry(result));
        }

        return entries;
    }

    @Override
    public DiaryMealEntry update(DiaryMealEntry entry) {
       // String query = "y";
        return null;
    }

    @Override
    public boolean deleteMealEntry(int entryId) {
        return false;
    }



    private DiaryMealEntry mapToEntry(SqlRowSet res){
        DiaryMealEntry entry = new DiaryMealEntry();
        entry.setDiaryMealEntryId(res.getInt("diary_meal_entry_id"));
        entry.setDiaryId(res.getInt("diary_id"));
        entry.setDiaryMealEntryDate(res.getDate("diary_meal_entry_date").toLocalDate());
        entry.setDiaryMealTypeId(res.getInt("diary_meal_type_id"));
        entry.setFoodId(res.getInt("food_id"));
        entry.setServingSize(res.getString("serving_size"));
        entry.setNumberOfServings(res.getDouble("number_of_servings"));

        return  entry;
    }
}
