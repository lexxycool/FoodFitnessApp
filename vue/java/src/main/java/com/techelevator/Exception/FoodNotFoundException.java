package com.techelevator.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus( code = HttpStatus.NOT_FOUND, reason = "Food Not Found")
public class FoodNotFoundException extends Exception {


        public FoodNotFoundException() {
            super("Food not Found");
        }

}
