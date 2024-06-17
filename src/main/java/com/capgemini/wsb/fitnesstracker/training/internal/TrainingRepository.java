package com.capgemini.wsb.fitnesstracker.training.internal;

import com.capgemini.wsb.fitnesstracker.training.api.Training;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface TrainingRepository extends JpaRepository<Training, Long> {

    List<Training> findByUserId(Long userId);

    List<Training> findByEndTimeAfter(Date endTime);

    List<Training> findByActivityType(String activityType);

    @Query("SELECT t FROM Training t WHERE t.user.id = :userId AND t.endTime >= :startTime AND t.endTime <= :endTime")
    List<Training> findTrainingsForUserInTimeRange(@Param("userId") Long userId, @Param("startTime") Date startTime, @Param("endTime") Date endTime);
}
