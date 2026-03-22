package com.academy.academyapi.service;

import com.academy.academyapi.domain.Plan;
import com.academy.academyapi.domain.dto.plan.CreatePlanDTO;
import com.academy.academyapi.repository.PlanRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class PlanService {

    private final PlanRepository repository;

    public Plan create(CreatePlanDTO dto) {

        Plan plan = new Plan();
        plan.setType(dto.getType());
        plan.setPrice(dto.getPrice());
        plan.setDurationInDays(dto.getDurationInDays());

        return repository.save(plan);

    }

    public Plan findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Plano não encontrado"));
    }

    public LocalDate calculateNextDueDate(LocalDate baseDate, Integer durationInDays) {
        return baseDate.plusDays(durationInDays);
    }
}
