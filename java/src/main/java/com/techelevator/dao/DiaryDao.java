package com.techelevator.dao;

import com.techelevator.exceptions.DiaryNotFoundException;
import com.techelevator.model.Diary;

public interface DiaryDao {


    Diary getDiaryByDiaryId(int dairyId) throws DiaryNotFoundException;


    Diary getDiaryByProfileId(int profileId) throws DiaryNotFoundException;


    Diary getDiaryByUserId(int userId) throws DiaryNotFoundException;


    Diary createDiary(int profileId) throws DiaryNotFoundException;

}
