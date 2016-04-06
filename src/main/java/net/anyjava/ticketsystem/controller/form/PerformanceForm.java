package net.anyjava.ticketsystem.controller.form;


import lombok.Getter;
import lombok.Setter;
import net.anyjava.ticketsystem.domain.Performance;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import javax.validation.constraints.NotNull;

@Setter
@Getter
public class PerformanceForm {


    private Long id;

    @NotNull
    private String title;

    @NotNull
    private int startYear;

    @NotNull
    private int startMonth;

    @NotNull
    private int startDay;

    @NotNull
    private int reservationStartYear;

    @NotNull
    private int reservationStartMonth;

    @NotNull
    private int reservationStartDay;

    @NotNull
    private int reservationStartHour;

    @NotNull
    private int reservationStartMinute;

    @NotNull
    private int totalTicketCount;

    /**
     * Performance Entity를 만듬
     * @return Performance
     */
    public Performance getEntity() {
        Performance performance
                = Performance.createPerformance(this.getTitle(),
                        this.totalTicketCount);

        performance.setTotalTicketCount(this.getTotalTicketCount());
        performance.setStartDate(
                new Date(getStartYear(), getStartMonth(), getStartDay()));
        performance.setReservationStartDateTime(
                new Date(getReservationStartYear(),
                        getReservationStartMonth(),
                        getReservationStartDay(),
                        getReservationStartHour(),
                        getReservationStartMinute(), 00)
        );

        return performance;
    }
}
