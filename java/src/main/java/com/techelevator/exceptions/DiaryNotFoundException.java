package com.techelevator.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Diary Not Found")
public class DiaryNotFoundException extends Exception {
    public DiaryNotFoundException() {
        super("Diary Not Found");
    }
}
