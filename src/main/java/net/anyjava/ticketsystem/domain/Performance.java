package net.anyjava.ticketsystem.domain;


import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
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

    /**
     * Performance 를 생성하는 Factory Method
     * @param title 공연이름
     * @return Performance
     */
    public static Performance createPerformance(String title) {
        Performance performance = new Performance();
        performance.setTitle(title);

        return performance;
    }

}
