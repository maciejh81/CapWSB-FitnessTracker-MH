package com.capgemini.wsb.fitnesstracker.statistics.internal;

import com.capgemini.wsb.fitnesstracker.statistics.api.Statistics;
import com.capgemini.wsb.fitnesstracker.statistics.api.StatisticsDTO;
import com.capgemini.wsb.fitnesstracker.statistics.api.StatisticsNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/v1/statistics")
@RequiredArgsConstructor
class StatisticsController {

    private final StatisticsServiceImpl statisticsService;
    private final StatisticsMapper statisticsMapper;

    @PostMapping
    public StatisticsDTO createStatistics(@RequestBody StatisticsDTO statisticsDto) {
        Statistics statistics = statisticsMapper.toEntity(statisticsDto);
        Statistics createdStatistics = statisticsService.createStatistics(statistics);
        return statisticsMapper.toDto(createdStatistics);
    }

    @PutMapping("/{id}")
    public StatisticsDTO updateStatistics(@PathVariable Long id, @RequestBody StatisticsDTO statisticsDto) {
        Statistics updatedStatistics = statisticsService.updateStatistics(id, statisticsDto);
        return statisticsMapper.toDto(updatedStatistics);
    }

    @GetMapping("/{id}")
    public StatisticsDTO getStatisticsById(@PathVariable Long id) {
        return statisticsService.getStatistics(id)
                .map(statisticsMapper::toDto)
                .orElseThrow(() -> new StatisticsNotFoundException("Statistics not found with ID: " + id));
    }

    @DeleteMapping("/{id}")
    public void deleteStatistics(@PathVariable Long id) {
        statisticsService.deleteStatistics(id);
    }

    @GetMapping
    public List<StatisticsDTO> getAllStatistics() {
        return statisticsService.findAll().stream()
                .map(statisticsMapper::toDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/calories")
    public List<StatisticsDTO> getStatisticsByCalories(@RequestParam int calories) {
        return statisticsService.findAllByCaloriesGreaterThan(calories).stream()
                .map(statisticsMapper::toDto)
                .collect(Collectors.toList());
    }
}
