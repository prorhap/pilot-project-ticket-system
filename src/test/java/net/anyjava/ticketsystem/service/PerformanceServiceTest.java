package net.anyjava.ticketsystem.service;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;


import net.anyjava.TicketApplication;
import net.anyjava.ticketsystem.controller.form.PerformanceForm;
import net.anyjava.ticketsystem.controller.form.PerformanceFormTest;
import net.anyjava.ticketsystem.domain.Performance;
import net.anyjava.ticketsystem.dto.PerformanceDto;
import net.anyjava.ticketsystem.repository.PerformanceRepository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;
import javax.transaction.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = TicketApplication.class)
public class PerformanceServiceTest {

    @Autowired
    private PerformanceService performanceService;

    @Autowired
    private PerformanceRepository performanceRepository;

    @Test
    @Transactional
    public void testRegisterPerformance() {

        // Given
        PerformanceForm performanceForm
                = PerformanceFormTest.getTestPerformanceForm();

        // When
        Performance performance = performanceService.save(performanceForm);


        // THen
        assertThat(performanceRepository.findOne(performance.getId()),
                equalTo(performance));
    }

    @Test
    @Transactional
    public void testFindOneById() {
        // Given
        PerformanceForm performanceForm
                = PerformanceFormTest.getTestPerformanceForm();
        Performance performance = performanceService.save(performanceForm);

        Long performanceId = performance.getId();

        // When
        Performance readedPerformance
                = performanceService.findOne(performanceId);

        // Then
        assertThat(readedPerformance, equalTo(performance));

    }

    @Test
    @Transactional
    public void testFindAllPerformance() {

        // Given
        PerformanceForm performanceForm
                = PerformanceFormTest.getTestPerformanceForm();
        performanceService.save(performanceForm);

        // When
        PerformanceDto performanceDto = performanceService.findAll();

        // Then
        assertThat(1L, equalTo(performanceDto.getTotalCount()));

    }

}
