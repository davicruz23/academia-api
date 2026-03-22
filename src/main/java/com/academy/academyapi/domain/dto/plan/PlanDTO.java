package com.academy.academyapi.domain.dto.plan;

import com.academy.academyapi.enums.PlanType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PlanDTO {

    private Long id;
    private PlanType type;
    private BigDecimal price;
    private Integer durationInDays;
}
