package com.academy.academyapi.domain.dto.address;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateAddressDTO {

    private String state;
    private String city;
    private String street;
    private String number;
    private String zipCode;
    private String complement;
}
