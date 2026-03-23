package com.academy.academyapi.service;

import com.academy.academyapi.controller.mapper.StudentMapper;
import com.academy.academyapi.domain.Address;
import com.academy.academyapi.domain.Payment;
import com.academy.academyapi.domain.Plan;
import com.academy.academyapi.domain.Student;
import com.academy.academyapi.domain.dto.student.CreateStudentDTO;
import com.academy.academyapi.domain.dto.student.StudentDTO;
import com.academy.academyapi.domain.dto.student.UpdateStudentDTO;
import com.academy.academyapi.repository.PaymentRepository;
import com.academy.academyapi.repository.PlanRepository;
import com.academy.academyapi.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository repository;
    private final PlanRepository planRepository;
    private final PlanService planService;
    private final PaymentRepository paymentRepository;

    public List<StudentDTO> findAll() {
        return repository.findAll()
                .stream()
                .map(StudentMapper::mapper)
                .toList();
    }

    public StudentDTO findById(Long id) {

        Student student = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Estudante não encontrado!"));

        return StudentMapper.mapper(student);
    }

    public StudentDTO create(CreateStudentDTO dto) {

        if (dto.getPlanId() == null) {
            throw new IllegalArgumentException("PlanId is required");
        }

        if (dto.getAddress() == null) {
            throw new IllegalArgumentException("Endereço Obrigatório!");
        }

        Plan plan = planRepository.findById(dto.getPlanId())
                .orElseThrow(() -> new RuntimeException("Plan not found"));

        Address address = new  Address(
                null,
                dto.getAddress().getState(),
                dto.getAddress().getCity(),
                dto.getAddress().getStreet(),
                dto.getAddress().getNumber(),
                dto.getAddress().getZipCode(),
                dto.getAddress().getComplement()
        );


        Student student = new Student();

        student.setName(dto.getName());
        student.setPhone(dto.getPhone());
        student.setPlan(plan);
        student.setAddress(address);

        LocalDate today = LocalDate.now();

        student.setStartDate(today);
        student.setNextDueDate(
                planService.calculateNextDueDate(today, plan.getDurationInDays())
        );
        student.setActive(true);

        Student saved =  repository.save(student);

        Payment payment = new Payment();
        payment.setStudent(saved);
        payment.setAmount(plan.getPrice());
        payment.setPaymentDate(today);
        payment.setPaid(true);
        paymentRepository.save(payment);


        return StudentMapper.mapper(saved);
    }

    public List<StudentDTO> findOverdue() {
        return repository.findByNextDueDateBeforeAndActiveTrue(LocalDate.now())
                .stream()
                .map(StudentMapper::mapper)
                .toList();
    }

    public StudentDTO update(Long id, UpdateStudentDTO dto) {

        Student student = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found"));

        if (dto.getName() != null) {
            student.setName(dto.getName());
        }

        if (dto.getPhone() != null) {
            student.setPhone(dto.getPhone());
        }

        if (dto.getPlanId() != null) {
            Plan plan = planRepository.findById(dto.getPlanId())
                    .orElseThrow(() -> new RuntimeException("Plan not found"));

            student.setPlan(plan);
        }

        Student saved = repository.save(student);

        return StudentMapper.mapper(saved);
    }

    public void deactivate(Long id) {
        Student student = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found"));

        student.setActive(false);

        repository.save(student);
    }
}