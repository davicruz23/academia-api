package com.academy.academyapi.controller.mapper;

import com.academy.academyapi.domain.Payment;
import com.academy.academyapi.domain.dto.payment.PaymentDTO;

public class PaymentMapper {
    public static PaymentDTO mapper(Payment src) {
        return PaymentDTO.builder()
                .id(src.getId())
                .studentId(src.getStudent().getId())
                .studentName(src.getStudent().getName())
                .amount(src.getAmount())
                .paymentDate(src.getPaymentDate())
                .build();
    }
}
