package com.academy.academyapi.domain.dto.student;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateStudentDTO {

    private String name;
    private String phone;
    private Long planId;

}
