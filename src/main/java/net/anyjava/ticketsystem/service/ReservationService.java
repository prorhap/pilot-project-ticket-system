package net.anyjava.ticketsystem.service;

import net.anyjava.ticketsystem.domain.Performance;
import net.anyjava.ticketsystem.domain.Ticket;
import net.anyjava.ticketsystem.repository.PerformanceRepository;
import net.anyjava.ticketsystem.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by anyjava on 2016. 4. 7..
 * 티켓 예약/취소 관련 서비스로직을 포함한다
 */
@Service
public class ReservationService {

    @Autowired
    private PerformanceRepository performanceRepository;

    @Autowired
    private TicketRepository ticketRepository;

    /**
     * 티켓예매 서비스
     * @param performanceId 예매할 공연 아이디
     * @param memberId 예매자 회원 아이디
     * @param countOfReserveTicket 예매 수량
     * @return 예매한 티켓 리스트
     */
    @Transactional
    public List<Ticket> reserveTicket(
            long performanceId, long memberId, int countOfReserveTicket) {

        Performance bookablePerformance = performanceRepository
                .findByBookablePerformance(
                        performanceId,
                        new Date());

        if (bookablePerformance == null) {
            throw new RuntimeException("예매할수 없습니다.");
        }

        // TODO : 죄악을 저지르자. 무조건 3개를 가져오지만,, 선점되지 않은 3개를 리턴해야함.
        List<Ticket> tickets = bookablePerformance.getTickets();

        List<Ticket> bookedTickets = new ArrayList<>(countOfReserveTicket);

        for (Ticket ticket :
                tickets) {
            bookedTickets.add(ticket);
        }

        return bookedTickets;
    }
}
