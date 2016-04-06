package net.anyjava.ticketsystem.repository;

import net.anyjava.ticketsystem.domain.Performance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

// TODO : 질문 ? sevice에서 repository ? service -> service -> respository ?
public interface PerformanceRepository
        extends JpaRepository<Performance, Long> {

    @Query("SELECT p FROM Performance p JOIN FETCH p.tickets "
            + "WHERE p.id = :id AND p.reservationStartDateTime <= :now")
    Performance findByBookablePerformance(@Param("id") long id,
                                          @Param("now") LocalDateTime now);
}
