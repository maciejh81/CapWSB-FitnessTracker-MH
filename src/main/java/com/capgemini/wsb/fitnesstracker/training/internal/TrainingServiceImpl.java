package com.capgemini.wsb.fitnesstracker.training.internal;

import com.capgemini.wsb.fitnesstracker.training.api.Training;
import com.capgemini.wsb.fitnesstracker.training.api.TrainingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class TrainingServiceImpl implements TrainingService {

    @Autowired
    private TrainingRepository trainingRepository;

    @Override
    public Training createTraining(Training training) {
        return trainingRepository.save(training);
    }

    @Override
    public List<Training> findAllTrainings() {
        return trainingRepository.findAll();
    }

    @Override
    public List<Training> findTrainingsByUserId(Long userId) {
        return trainingRepository.findByUserId(userId);
    }

    @Override
    public List<Training> findCompletedTrainings(String date) {
        // Assuming the date is passed as a String and needs to be parsed
        Date parsedDate = parseDate(date); // Implement this method to parse the date
        return trainingRepository.findByEndTimeAfter(parsedDate);
    }

    @Override
    public List<Training> findTrainingsByActivityType(String activityType) {
        return trainingRepository.findByActivityType(activityType);
    }

    @Override
    public Training updateTraining(Long trainingId, Training training) {
        return trainingRepository.findById(trainingId)
                .map(existingTraining -> {
                    existingTraining.setUser(training.getUser());
                    existingTraining.setStartTime(training.getStartTime());
                    existingTraining.setEndTime(training.getEndTime());
                    existingTraining.setActivityType(training.getActivityType());
                    existingTraining.setDistance(training.getDistance());
                    existingTraining.setAverageSpeed(training.getAverageSpeed());
                    return trainingRepository.save(existingTraining);
                })
                .orElseThrow(() -> new RuntimeException("Training not found"));
    }

    private Date parseDate(String date) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            return dateFormat.parse(date);
        } catch (ParseException e) {
            throw new IllegalArgumentException("Invalid date format. Please use 'yyyy-MM-dd'.", e);
        }
    }
}