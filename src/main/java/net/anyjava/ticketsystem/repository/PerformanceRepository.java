package net.anyjava.ticketsystem.repository;

import net.anyjava.ticketsystem.domain.Performance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import sun.misc.Perf;

import java.util.Date;
import java.util.List;

// TODO : 질문 ? sevice에서 repository ? service -> service -> respository ?
public interface PerformanceRepository
        extends JpaRepository<Performance, Long> {


    @Query("SELECT p FROM Performance p WHERE p.ticketOpenDate <= :date")
    List<Performance> findPerforformanceByTicketOpenDate(@Param("date") Date date);

//    Performance findPerforformanceByTicketOpenDate(@Param("id") long id,
//                                          @Param("now") Date now);
}
