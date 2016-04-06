package net.anyjava.ticketsystem.domain;


import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
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
    @Temporal(TemporalType.DATE)
    private Date startDate;

    @NotNull
    @Temporal(TemporalType.TIMESTAMP)
    private Date reservationStartDateTime;

    @NotNull
    private int totalTicketCount;

    @NotNull
    private int ticketPrice;

    @OneToMany(mappedBy = "performance")
    private List<Ticket> tickets;

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

        List<Ticket> tikects = new ArrayList<>(totalTicketCount);
        Collections.fill(tikects, new Ticket());

        performance.setTickets(tikects);

        return performance;
    }

}
