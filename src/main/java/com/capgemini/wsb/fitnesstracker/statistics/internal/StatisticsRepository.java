package com.capgemini.wsb.fitnesstracker.statistics.internal;

import com.capgemini.wsb.fitnesstracker.statistics.api.Statistics;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
interface StatisticsRepository extends JpaRepository<Statistics, Long> {

    List<Statistics> findAllByTotalCaloriesBurnedGreaterThan(int calories);
}
