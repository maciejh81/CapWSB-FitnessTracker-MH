package com.capgemini.wsb.fitnesstracker.statistics.api;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class StatisticsNotFoundException extends RuntimeException {

    public StatisticsNotFoundException(String message) {
        super(message);
    }
}
