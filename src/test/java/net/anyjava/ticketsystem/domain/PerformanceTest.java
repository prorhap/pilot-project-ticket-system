package net.anyjava.ticketsystem.domain;

import net.anyjava.TicketApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = TicketApplication.class)
@Transactional
public class PerformanceTest {

    @PersistenceContext
    private EntityManager em;

    @Test
    public void testCreateEntity() {

        Performance performance = Performance.createPerformance("아이유 콘서트");

        performance.setStartDate(LocalDate.of(2016, 5, 1));
        performance.setReservationStartDateTime(LocalDateTime.of(2016, 4, 10, 10, 00, 00));
        performance.setTotalTicketCount(100);

        em.persist(performance);

        assertEquals("아이유 콘서트", performance.getTitle());
    }

}