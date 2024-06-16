package com.capgemini.wsb.fitnesstracker.statistics.internal;

import com.capgemini.wsb.fitnesstracker.statistics.api.Statistics;
import com.capgemini.wsb.fitnesstracker.statistics.api.StatisticsDTO;
import com.capgemini.wsb.fitnesstracker.user.api.User;
import com.capgemini.wsb.fitnesstracker.user.internal.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
class StatisticsMapper {

    private final UserRepository userRepository;

    StatisticsDTO toDto(Statistics statistics) {
        StatisticsDTO dto = new StatisticsDTO();
        dto.setId(statistics.getId());
        dto.setUserId(statistics.getUser().getId());
        dto.setTotalTrainings(statistics.getTotalTrainings());
        dto.setTotalDistance(statistics.getTotalDistance());
        dto.setTotalCaloriesBurned(statistics.getTotalCaloriesBurned());
        return dto;
    }

    Statistics toEntity(StatisticsDTO dto) {
        User user = userRepository.findById(dto.getUserId())
                .orElseThrow(() -> new IllegalArgumentException("User not found with ID: " + dto.getUserId()));
        return Statistics.create(user, dto.getTotalTrainings(), dto.getTotalDistance(), dto.getTotalCaloriesBurned());
    }
}
