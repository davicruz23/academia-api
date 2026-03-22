package com.academy.academyapi.controller.mapper;

import com.academy.academyapi.domain.Plan;
import com.academy.academyapi.domain.dto.plan.PlanDTO;

public class PlanMapper {
    public static PlanDTO mapper (Plan src) {
        return PlanDTO.builder()
                .id(src.getId())
                .type(src.getType())
                .price(src.getPrice())
                .durationInDays(src.getDurationInDays())
                .build();
    }
}
