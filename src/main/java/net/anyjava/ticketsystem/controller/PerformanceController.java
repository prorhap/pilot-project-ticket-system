package net.anyjava.ticketsystem.controller;

import net.anyjava.ticketsystem.controller.form.PerformanceForm;
import net.anyjava.ticketsystem.domain.Performance;
import net.anyjava.ticketsystem.service.PerformanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/performances")
public class PerformanceController {

    @Autowired
    private PerformanceService performanceService;

    @RequestMapping(method = RequestMethod.POST)
    public Performance registerPerformance(
            @RequestBody PerformanceForm performance) {
        return performanceService.save(performance);
    }
}
