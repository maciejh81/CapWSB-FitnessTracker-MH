package com.capgemini.wsb.fitnesstracker.statistics.api;

public interface StatisticsService {

    Statistics createStatistics(Statistics statistics);

    Statistics updateStatistics(Long id, StatisticsDTO statisticsDto);

    void deleteStatistics(Long id);
}
