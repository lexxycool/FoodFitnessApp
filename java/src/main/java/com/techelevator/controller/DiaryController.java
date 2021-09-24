package com.techelevator.controller;

import com.techelevator.dao.DiaryDao;
import com.techelevator.dao.DiaryMealEntryDao;
import com.techelevator.exceptions.DiaryNotFoundException;
import com.techelevator.model.Diary;
import com.techelevator.model.DiaryMealEntry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;


@RestController
@RequestMapping("/diaries")
public class DiaryController {

        @Autowired
        DiaryMealEntryDao diaryMealEntryDao;

        @Autowired
         DiaryDao diaryDao;


    @RequestMapping(path = "", method = RequestMethod.GET)
    public Diary getDiaryByProfileId(@RequestParam(required = true) int profileId) throws DiaryNotFoundException {

       return diaryDao.getDiaryByProfileId(profileId);

    }



    @RequestMapping(path = "/{diaryId}/entries", method = RequestMethod.GET)
    public List<DiaryMealEntry>getDiaryEntries(@PathVariable int diaryId, @RequestParam(defaultValue ="") String date) throws DiaryNotFoundException {

        if(diaryDao.getDiaryByDiaryId(diaryId) !=  null) {
            LocalDate dateObj = null;

            if (date.equals("")) {
                dateObj = LocalDate.now();
            } else {
                dateObj = LocalDate.parse(date);
            }
            return  diaryMealEntryDao.getEntriesByDairyIdAndDate(diaryId,dateObj);
        }
        else throw new DiaryNotFoundException();

    }


    @RequestMapping(path = "/{diaryId}/entries", method = RequestMethod.POST)
    public DiaryMealEntry addDairyEntry(@PathVariable int diaryId, @RequestBody DiaryMealEntry entry) throws DiaryNotFoundException {
        if(diaryDao.getDiaryByDiaryId(diaryId) !=  null) {
            return diaryMealEntryDao.create(entry);
        }else{
            throw new DiaryNotFoundException();
        }


    }




}
