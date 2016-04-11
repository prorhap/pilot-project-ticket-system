package net.anyjava.ticketsystem.domain;


import lombok.Data;
import net.anyjava.ticketsystem.controller.form.PerformanceForm;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

@Entity
@Data
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
    private Date ticketOpenDate;

    @NotNull
    private int totalTicketCount;

    @NotNull
    private int ticketPrice;

    @OneToMany(mappedBy = "performance")
    private List<Ticket> tickets;

    public static Performance of(PerformanceForm performanceForm) {
        Performance performance = new Performance();

        performance.setStartDate(performanceForm.getStartDate());
        performance.setTicketOpenDate(performanceForm.getTicketOpenDate());
        performance.setTitle(performanceForm.getTitle());
        performance.setTotalTicketCount(performanceForm.getTotalTicketCount());

        List<Ticket> tikects = new ArrayList<>(performanceForm.getTotalTicketCount());
        Collections.fill(tikects, new Ticket());

        performance.setTickets(tikects);

        return performance;
    }

}
