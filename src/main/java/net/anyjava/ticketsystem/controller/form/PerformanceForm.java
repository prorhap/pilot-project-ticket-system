package net.anyjava.ticketsystem.controller.form;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import net.anyjava.ticketsystem.domain.Performance;

import java.time.LocalDate;
import java.time.LocalDateTime;
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
    @JsonIgnore
    public Performance getEntity() {
        Performance performance
                = Performance.createPerformance(this.getTitle(),
                        this.totalTicketCount);

        performance.setStartDate(
                LocalDate.of(getStartYear(), getStartMonth(), getStartDay()));
        performance.setReservationStartDateTime(
                LocalDateTime.of(getReservationStartYear(),
                        getReservationStartMonth(),
                        getReservationStartDay(),
                        getReservationStartHour(),
                        getReservationStartMinute(), 00)
        );

        return performance;
    }
}
