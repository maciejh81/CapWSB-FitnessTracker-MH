package com.capgemini.wsb.fitnesstracker.training.internal;

import com.capgemini.wsb.fitnesstracker.training.api.Training;
import com.capgemini.wsb.fitnesstracker.training.api.TrainingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/trainings")
public class TrainingController {
    @Autowired
    private TrainingService trainingService;
    @Autowired
    private TrainingMapper trainingMapper;

    @PostMapping
    public ResponseEntity<TrainingDto> createTraining(@RequestBody TrainingDto trainingDto) {
        Training createdTraining = trainingService.createTraining(trainingMapper.toEntity(trainingDto));
        return ResponseEntity.ok(trainingMapper.toDto(createdTraining));
    }

    @GetMapping
    public ResponseEntity<List<TrainingDto>> getAllTrainings() {
        List<TrainingDto> dtos = trainingService.findAllTrainings().stream()
                .map(trainingMapper::toDto)
                .collect(Collectors.toList());
        return ResponseEntity.ok(dtos);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<TrainingDto>> getTrainingsByUserId(@PathVariable Long userId) {
        List<TrainingDto> dtos = trainingService.findTrainingsByUserId(userId).stream()
                .map(trainingMapper::toDto)
                .collect(Collectors.toList());
        return ResponseEntity.ok(dtos);
    }

    @GetMapping("/completed")
    public ResponseEntity<List<TrainingDto>> getCompletedTrainings(@RequestParam("date") String date) {
        List<TrainingDto> dtos = trainingService.findCompletedTrainings(date).stream()
                .map(trainingMapper::toDto)
                .collect(Collectors.toList());
        return ResponseEntity.ok(dtos);
    }

    @GetMapping("/activity/{activityType}")
    public ResponseEntity<List<TrainingDto>> getTrainingsByActivity(@PathVariable String activityType) {
        List<TrainingDto> dtos = trainingService.findTrainingsByActivityType(activityType).stream()
                .map(trainingMapper::toDto)
                .collect(Collectors.toList());
        return ResponseEntity.ok(dtos);
    }

    @PutMapping("/{trainingId}")
    public ResponseEntity<TrainingDto> updateTraining(@PathVariable Long trainingId, @RequestBody TrainingDto trainingDto) {
        Training updatedTraining = trainingService.updateTraining(trainingId, trainingMapper.toEntity(trainingDto));
        return ResponseEntity.ok(trainingMapper.toDto(updatedTraining));
    }
}
