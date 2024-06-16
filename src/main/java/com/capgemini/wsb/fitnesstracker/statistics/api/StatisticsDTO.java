package com.capgemini.wsb.fitnesstracker.statistics.api;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StatisticsDTO {

    private Long id;
    private Long userId;
    private int totalTrainings;
    private double totalDistance;
    private int totalCaloriesBurned;
}
