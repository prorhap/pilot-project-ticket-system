package net.anyjava.ticketsystem.repository;

import net.anyjava.ticketsystem.domain.Performance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PerformanceRepository
        extends JpaRepository<Performance, Long> {
}
