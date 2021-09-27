package com.techelevator.dao;

import com.techelevator.model.DiaryMealEntry;

import java.time.LocalDate;
import java.util.List;

public interface DiaryMealEntryDao {

    DiaryMealEntry create(DiaryMealEntry entry);


    DiaryMealEntry getMealEntryByEntryId(int entryId);

    List<DiaryMealEntry> getEntriesByDairyIdAndDate(int dairyId, LocalDate date);


    DiaryMealEntry update(DiaryMealEntry entry);


    boolean deleteMealEntry(int entryId);
}
