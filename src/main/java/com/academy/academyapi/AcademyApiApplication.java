package com.academy.academyapi;

import com.academy.academyapi.domain.Plan;
import com.academy.academyapi.enums.PlanType;
import com.academy.academyapi.repository.PlanRepository;
import com.academy.academyapi.service.PlanService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class AcademyApiApplication {

    @Bean
    @Transactional
    public CommandLineRunner commandLineRunner(
            PlanRepository planRepository,
            PlanService planService
    ) {
        return args -> {
            try {
                Plan plan = planService.findById(1L);
            }catch (Exception e){

                List<Plan> plans = new ArrayList<>();
                plans.add(new Plan(null, PlanType.DAILY,  BigDecimal.valueOf(10), 1));
                plans.add(new Plan(null, PlanType.MONTHLY,  BigDecimal.valueOf(60), 30));
                plans.add(new Plan(null, PlanType.ANNUAL,  BigDecimal.valueOf(650), 365));
                planRepository.saveAll(plans);
            }
        };
    }

    public static void main(String[] args) {
        SpringApplication.run(AcademyApiApplication.class, args);
    }

}
