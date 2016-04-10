package net.anyjava.ticketsystem.domain;

import static org.junit.Assert.assertEquals;

import net.anyjava.TicketApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = TicketApplication.class)
@Transactional
public class PerformanceTest {

    @PersistenceContext
    private EntityManager em;

    @Test
    public void testCreateEntity() {

        Performance performance
                = Performance.createPerformance("아이유 콘서트", 10);

        performance.setStartDate(LocalDate.of(2016, 5, 1));
        performance.setReservationStartDateTime(
                LocalDateTime.of(2016, 4, 10, 10, 00, 00));

        em.persist(performance);
        em.flush();
        em.clear();

        Performance readedPerformance
                = em.find(Performance.class, performance.getId());

        assertEquals("아이유 콘서트", readedPerformance.getTitle());
        assertEquals("Ticket 생성 테스트",
                10, readedPerformance.getTickets().size());
    }

}
