package net.anyjava.ticketsystem.service;

import net.anyjava.ticketsystem.domain.Member;
import net.anyjava.ticketsystem.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by anyjava on 2016. 4. 5..
 */
@Service
public class MemberService {

    @Autowired
    private MemberRepository memberRepository;

    /**
     * 회원가입 서비스
     * @param member 회원 엔티티
     * @return 가입한 회원정보
     */
    @Transactional
    public Member join(Member member) {
        List<Member> members
                = memberRepository.findByEmailEquals(member.getEmail());

        if (members.size() > 0) {
            throw new RuntimeException("이미 존재하는 회원입니다.");
        }

        return memberRepository.save(member);
    }

    public List<Member> findAll() {
        List<Member> members = memberRepository.findAll();
        return members;
    }
}
