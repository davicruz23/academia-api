package com.academy.academyapi.domain.dto.student;

import com.academy.academyapi.domain.Plan;
import com.academy.academyapi.domain.dto.address.AddressDTO;
import com.academy.academyapi.domain.dto.plan.PlanDTO;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StudentDTO {

    private Long id;
    private String name;
    private String phone;
    private LocalDate startDate;
    private LocalDate nextDueDate;
    private Boolean active;
    private AddressDTO address;
    private PlanDTO plan;

}
