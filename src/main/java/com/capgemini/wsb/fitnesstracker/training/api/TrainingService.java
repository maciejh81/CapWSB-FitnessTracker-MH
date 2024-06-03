package com.capgemini.wsb.fitnesstracker.training.api;

import com.capgemini.wsb.fitnesstracker.training.api.Training;
import java.util.List;

public interface TrainingService {

    Training createTraining(Training training);

    List<Training> findAllTrainings();

    List<Training> findTrainingsByUserId(Long userId);

    List<Training> findCompletedTrainings(String date);

    List<Training> findTrainingsByActivityType(String activityType);

    Training updateTraining(Long trainingId, Training training);
}