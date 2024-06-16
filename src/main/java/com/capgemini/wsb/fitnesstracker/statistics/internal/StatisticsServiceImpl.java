package com.capgemini.wsb.fitnesstracker.statistics.internal;

import com.capgemini.wsb.fitnesstracker.statistics.api.Statistics;
import com.capgemini.wsb.fitnesstracker.statistics.api.StatisticsDTO;
import com.capgemini.wsb.fitnesstracker.statistics.api.StatisticsProvider;
import com.capgemini.wsb.fitnesstracker.statistics.api.StatisticsService;
import com.capgemini.wsb.fitnesstracker.user.internal.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
class StatisticsServiceImpl implements StatisticsService, StatisticsProvider {

    private final StatisticsRepository statisticsRepository;
    private final UserRepository userRepository;
    private final StatisticsMapper statisticsMapper;

    @Override
    public Statistics createStatistics(Statistics statistics) {
        log.info("Creating Statistics {}", statistics);
        return statisticsRepository.save(statistics);
    }

    @Override
    public Statistics updateStatistics(Long id, StatisticsDTO statisticsDto) {
        Statistics existingStatistics = statisticsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Statistics not found with ID: " + id));
        existingStatistics.setTotalTrainings(statisticsDto.getTotalTrainings());
        existingStatistics.setTotalDistance(statisticsDto.getTotalDistance());
        existingStatistics.setTotalCaloriesBurned(statisticsDto.getTotalCaloriesBurned());
        return statisticsRepository.save(existingStatistics);
    }

    @Override
    public void deleteStatistics(Long id) {
        statisticsRepository.deleteById(id);
    }

    @Override
    public Optional<Statistics> getStatistics(Long statisticsId) {
        return statisticsRepository.findById(statisticsId);
    }

    @Override
    public List<Statistics> findAllByCaloriesGreaterThan(int calories) {
        return statisticsRepository.findAllByTotalCaloriesBurnedGreaterThan(calories);
    }

    @Override
    public List<Statistics> findAll() {
        return statisticsRepository.findAll();
    }
}
