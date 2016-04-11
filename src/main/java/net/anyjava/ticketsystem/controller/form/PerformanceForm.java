package net.anyjava.ticketsystem.controller.form;


import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
public class PerformanceForm {


    private Long id;

    @NotNull
    private String title;

    @NotNull
    private Date startDate;

    @NotNull
    private Date ticketOpenDate;

    @NotNull
    private int totalTicketCount;

}
