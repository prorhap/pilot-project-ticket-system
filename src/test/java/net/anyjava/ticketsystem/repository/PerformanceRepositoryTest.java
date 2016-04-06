package net.anyjava.ticketsystem.repository;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertEquals;

import net.anyjava.TicketApplication;
import net.anyjava.ticketsystem.controller.form.PerformanceFormTest;
import net.anyjava.ticketsystem.domain.Performance;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.time.LocalDateTime;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = TicketApplication.class)
public class PerformanceRepositoryTest {

    @Autowired
    private PerformanceRepository performanceRepository;

    @Test
    public void testNotExistBookablePerformance() {
        // Given
        // 공연생성
        Performance performance =
                PerformanceFormTest.getTestPerformanceForm().getEntity();
        performanceRepository.save(performance);

        long id = (long) performance.getId();

        // When
        Performance notBookablePerformance =
                performanceRepository.findByBookablePerformance(
                        id, LocalDateTime.of(2015, 1, 1, 00, 00, 00));

        // Then
        assertEquals("예매 가능하지 않은 공연테스트", null, notBookablePerformance);

        // When
        Performance bookablePerformance =
                performanceRepository.findByBookablePerformance(
                        id, LocalDateTime.now());

        // Then
        assertThat("예매 가능한 공연테스트", bookablePerformance, is(notNullValue()));
    }



}
