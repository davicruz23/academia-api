package com.academy.academyapi.service;

import com.academy.academyapi.controller.mapper.PaymentMapper;
import com.academy.academyapi.domain.Payment;
import com.academy.academyapi.domain.Student;
import com.academy.academyapi.domain.dto.payment.CreatePaymentDTO;
import com.academy.academyapi.domain.dto.payment.PaymentDTO;
import com.academy.academyapi.repository.PaymentRepository;
import com.academy.academyapi.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PaymentService {

    private final PaymentRepository paymentRepository;
    private final StudentRepository studentRepository;
    private final PlanService planService;

    public void registerPayment(CreatePaymentDTO dto) {

        if (dto.getStudentId() == null) {
            throw new IllegalArgumentException("StudentId is required");
        }

        Student student = studentRepository.findById(dto.getStudentId())
                .orElseThrow(() -> new RuntimeException("Student not found"));

        Payment payment = new Payment();
        payment.setStudent(student);
        payment.setPaymentDate(LocalDate.now());

        payment.setAmount(student.getPlan().getPrice());

        paymentRepository.save(payment);

        student.setNextDueDate(
                planService.calculateNextDueDate(
                        student.getNextDueDate(),
                        student.getPlan().getDurationInDays()
                )
        );

        studentRepository.save(student);
    }

    public List<PaymentDTO> findByStudent(Long studentId) {

        return paymentRepository.findByStudentId(studentId)
                .stream()
                .map(PaymentMapper::mapper)
                .toList();
    }
}