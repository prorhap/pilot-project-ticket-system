package net.anyjava.ticketsystem.domain;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Setter
@Getter
public class Performance {


    @Id @GeneratedValue
    @Column(name = "PERFORMANCE_ID")
    private Long id;

    private String title;

    private LocalDate startDate;
    private LocalDateTime reservationStartDateTime;
    private int TotalTicketCount;

    public static Performance createPerformance(String title) {
        Performance performance = new Performance();
        performance.setTitle(title);

        return performance;
    }

}
