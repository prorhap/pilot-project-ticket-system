package net.anyjava.ticketsystem.domain;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

@Entity
@Setter
@Getter
public class Performance {


    @Id @GeneratedValue
    @Column(name = "PERFORMANCE_ID")
    private Long id;

    @NotNull
    private String title;

    @NotNull
    private LocalDate startDate;

    @NotNull
    private LocalDateTime reservationStartDateTime;

    @NotNull
    private int totalTicketCount;

    @NotNull
    private int ticketPrice;

    @JsonIgnore
    @OneToMany(mappedBy = "performance", cascade = CascadeType.PERSIST)
    private List<Ticket> tickets = new ArrayList<>();

    /**
     * Performance 를 생성하는 Factory Method
     * @param title 공연이름
     * @param totalTicketCount 발행 티켓 수
     * @return Performance
     */
    public static Performance createPerformance(String title,
                                                int totalTicketCount) {
        Performance performance = new Performance();
        performance.setTitle(title);
        performance.setTotalTicketCount(totalTicketCount);

        for (int i = 0; i < totalTicketCount; ++i) {
            performance.setTicket(new Ticket());
        }
        return performance;
    }

    /**
     * TODO : 중복 체크 추가 필요
     * @param ticket Ticket
     */
    public void setTicket(Ticket ticket) {

        this.tickets.add(ticket);

        if (ticket.getPerformance() != this) {
            ticket.setPerformance(this);
        }
    }

    /**
     * 회원을 받아서 해당 회원이 티켓을 예매 하도록 한다
     * @param member  회원
     * @param countOfReserveTicket 예매할 티켓수
     * @return 예매된 티켓 리스트
     */
    public List<Ticket> getTickets(Member member, int countOfReserveTicket) {
        // TODO : 예약안된것 만 가져오도록 추가
        List<Ticket> bookTickets = new ArrayList<>(countOfReserveTicket);

        for (int i = 0; i < countOfReserveTicket; ++i) {
            Ticket ticket = this.tickets.get(i);
            ticket.setMember(member);
            bookTickets.add(this.tickets.get(i));
        }
        return bookTickets;
    }
}
