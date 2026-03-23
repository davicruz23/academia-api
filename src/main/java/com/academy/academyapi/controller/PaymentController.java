package com.academy.academyapi.controller;

import com.academy.academyapi.domain.dto.payment.CreatePaymentDTO;
import com.academy.academyapi.domain.dto.payment.PaymentDTO;
import com.academy.academyapi.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/payments")
@RequiredArgsConstructor
public class PaymentController {

    private final PaymentService service;

    @PostMapping
    public void registerPayment(@RequestBody CreatePaymentDTO dto) {
        service.registerPayment(dto);
    }

    @GetMapping("/student/{id}")
    public List<PaymentDTO> findByStudent(@PathVariable Long id) {
        return service.findByStudent(id);
    }
}