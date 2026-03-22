package com.academy.academyapi.controller.mapper;

import com.academy.academyapi.domain.Address;
import com.academy.academyapi.domain.dto.address.AddressDTO;

public class AddressMapper {
    public static AddressDTO mapper(Address src) {
        return AddressDTO.builder()
                .id(src.getId())
                .city(src.getCity())
                .street(src.getStreet())
                .number(src.getNumber())
                .zipCode(src.getZipCode())
                .complement(src.getComplement())
                .build();
    }
}
