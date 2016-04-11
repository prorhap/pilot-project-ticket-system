package net.anyjava.ticketsystem.repository;

import net.anyjava.TicketApplication;
import net.anyjava.ticketsystem.controller.form.PerformanceFormTest;
import net.anyjava.ticketsystem.domain.Performance;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = TicketApplication.class)
public class PerformanceRepositoryTest {

    @Autowired
    private PerformanceRepository performanceRepository;

    @Test
    public void testNotExistBookablePerformance() throws Exception {
        // Given
        // 공연생성
        Performance performance = Performance.of(PerformanceFormTest.getTestPerformanceForm());
        performanceRepository.save(performance);

        long id = (long) performance.getId();

        // When
        List<Performance> notBookablePerformance =
                performanceRepository.findPerforformanceByTicketOpenDate(new SimpleDateFormat("yyyy/MM/dd").parse("2016/03/30"));

        // Then
        assertEquals("예매 가능하지 않은 공연테스트", 0, notBookablePerformance.size());

        // When
        List<Performance> bookablePerformance =
                performanceRepository.findPerforformanceByTicketOpenDate(new Date());

        // Then
        assertEquals("예매 가능한 공연테스트", 1, bookablePerformance.size());
        assertEquals("예매 가능한 공연테스트", "아이유 콘서트", bookablePerformance.get(0).getTitle());
    }
}
