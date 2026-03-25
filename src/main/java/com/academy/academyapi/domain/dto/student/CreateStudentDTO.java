package com.academy.academyapi.domain.dto.student;

import com.academy.academyapi.domain.dto.address.CreateAddressDTO;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateStudentDTO {

    private String name;
    private String phone;
    private String email;
    private String cpf;
    private Long planId;
    private CreateAddressDTO address;

}
