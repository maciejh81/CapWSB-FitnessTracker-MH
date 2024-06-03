package com.capgemini.wsb.fitnesstracker.training.internal;

import com.capgemini.wsb.fitnesstracker.training.api.Training;
import org.springframework.stereotype.Component;

@Component
public class TrainingMapper {

    public TrainingDto toDto(Training training) {
        TrainingDto dto = new TrainingDto();
        dto.setId(training.getId());
        dto.setStartTime(training.getStartTime());
        dto.setEndTime(training.getEndTime());
        dto.setActivityType(training.getActivityType().name());
        dto.setDistance(training.getDistance());
        dto.setAverageSpeed(training.getAverageSpeed());
        return dto;
    }

    public Training toEntity(TrainingDto dto) {
        Training training = new Training();
        training.setId(dto.getId());
        training.setStartTime(dto.getStartTime());
        training.setEndTime(dto.getEndTime());
        training.setActivityType(ActivityType.valueOf(dto.getActivityType()));
        training.setDistance(dto.getDistance());
        training.setAverageSpeed(dto.getAverageSpeed());
        return training;
    }
}
