package net.anyjava.ticketsystem.domain;

import static org.junit.Assert.assertEquals;

import net.anyjava.TicketApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

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

        Performance performance = new Performance();

        performance.setTitle("아이유 콘서트");
        performance.setStartDate(new Date(2016, 5, 1));
        performance.setTicketOpenDate(new Date(2016, 4, 10, 10, 00, 00));
        performance.setTotalTicketCount(100);

        em.persist(performance);

        assertEquals("아이유 콘서트", performance.getTitle());
    }

}
