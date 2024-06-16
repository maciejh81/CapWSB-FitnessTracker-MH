package com.capgemini.wsb.fitnesstracker.statistics.api;

import com.capgemini.wsb.fitnesstracker.statistics.api.Statistics;

import java.util.List;
import java.util.Optional;

public interface StatisticsProvider {

    Optional<Statistics> getStatistics(Long statisticsId);

    List<Statistics> findAllByCaloriesGreaterThan(int calories);

    List<Statistics> findAll();
}
