package net.anyjava.ticketsystem.domain;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;

@Entity
@Setter
@Getter
public class Performance {


    private String title;

    public static Performance createPerformanc(String title) {
        Performance performance = new Performance();
        performance.setTitle(title);

        return performance;
    }

}
