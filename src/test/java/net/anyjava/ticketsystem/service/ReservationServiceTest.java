package net.anyjava.ticketsystem.service;

import net.anyjava.TicketApplication;
import net.anyjava.ticketsystem.controller.form.PerformanceFormTest;
import net.anyjava.ticketsystem.domain.Performance;
import net.anyjava.ticketsystem.domain.Member;
import net.anyjava.ticketsystem.domain.Ticket;
import net.anyjava.ticketsystem.repository.PerformanceRepository;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

/**
 * Created by anyjava on 2016. 4. 7..
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = TicketApplication.class)
public class ReservationServiceTest {

    @Autowired
    private ReservationService reservationService;

    @Autowired
    private PerformanceRepository performanceRepository;

    @Autowired
    private MemberService memberService;

    private Member member;
    private Performance performance;

    @Before
    public void setUp() {
        // 공연생성
        performance = PerformanceFormTest.getTestPerformanceForm().getEntity();
        performanceRepository.save(performance);

        member = new Member();
        member.setName("SON");
        member.setEmail("htson@woowahan.com");
        member.setPassWord("qwer1234");
        memberService.join(member);
    }

    @Test
    public void testReserveTicket() {

        // Given
        long performanceId = this.performance.getId();
        long memberid = this.member.getId();
        int countOfReserveTicket = 3;

        // When
        List<Ticket> reservedTickets = reservationService.reserveTicket(
                performanceId,
                memberid,
                countOfReserveTicket);

        // Then
        assertThat("티케 예매 3장 성공 테스트",
                countOfReserveTicket, equalTo(reservedTickets.size()));


    }

    @Test
    public void testReserveTicketOutOfDate() {


    }
}
