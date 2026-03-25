package com.academy.academyapi.controller.mapper;

import com.academy.academyapi.domain.Student;
import com.academy.academyapi.domain.dto.student.StudentDTO;

public class StudentMapper {
    public static StudentDTO mapper (Student src) {
        return StudentDTO.builder()
                .id(src.getId())
                .name(src.getName())
                .cpf(src.getCpf())
                .phone(src.getPhone())
                .email(src.getEmail())
                .startDate(src.getStartDate())
                .active(src.getActive())
                .nextDueDate(src.getNextDueDate())
                .address(AddressMapper.mapper(src.getAddress()))
                .plan(PlanMapper.mapper(src.getPlan()))
                .build();

    }
}
