package net.anyjava.ticketsystem.repository;

import net.anyjava.ticketsystem.domain.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by anyjava on 2016. 4. 7..
 */
public interface TicketRepository extends JpaRepository<Ticket, Long> {
}
