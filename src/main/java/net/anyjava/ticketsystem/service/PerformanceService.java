package net.anyjava.ticketsystem.service;

import net.anyjava.ticketsystem.controller.form.PerformanceForm;
import net.anyjava.ticketsystem.domain.Performance;
import net.anyjava.ticketsystem.repository.PerformanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PerformanceService {

    @Autowired
    private PerformanceRepository performanceRepository;

    public Performance save(PerformanceForm performanceForm) {
        return performanceRepository.save(performanceForm.getEntity());
    }

    public Performance findOne(Long performanceId) {
        return performanceRepository.findOne(performanceId);
    }
}
