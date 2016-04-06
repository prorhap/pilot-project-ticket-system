package net.anyjava.ticketsystem.repository;

import net.anyjava.ticketsystem.domain.Member;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


/**
 * Created by anyjava on 2016. 4. 5..
 */
public interface MemberRepository extends JpaRepository<Member, Long> {
    List<Member> findByEmailEquals(String email);
}
