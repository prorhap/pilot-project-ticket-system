package net.anyjava.ticketsystem.controller;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import net.anyjava.ticketsystem.controller.form.PerformanceForm;
import net.anyjava.ticketsystem.domain.Performance;
import net.anyjava.ticketsystem.dto.PerformanceDto;
import net.anyjava.ticketsystem.service.PerformanceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/performances")
public class PerformanceController {

    private final static Logger logger = LoggerFactory.getLogger(PerformanceController.class);

    @Autowired
    private PerformanceService performanceService;

    @RequestMapping(method = POST)
    public Performance registerPerformance(
            @RequestBody PerformanceForm performanceForm) {

        logger.info("-c-> register performance: {}", performanceForm);

        return performanceService.save(performanceForm);
    }

    @RequestMapping(method = GET)
    public PerformanceDto registerPerformance() {
        return performanceService.findAll();
    }

    @RequestMapping(value = "/{id}", method = GET)
    public Performance registerPerformance(@PathVariable Long id) {
        return performanceService.findOne(id);
    }
}
