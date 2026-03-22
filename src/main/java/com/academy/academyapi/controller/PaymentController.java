package com.academy.academyapi.controller;

import com.academy.academyapi.domain.dto.payment.PaymentDTO;
import com.academy.academyapi.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/payments")
@RequiredArgsConstructor
public class PaymentController {

    private final PaymentService service;

    @PostMapping
    public void registerPayment(@RequestBody PaymentDTO dto) {
        service.registerPayment(dto);
    }
}