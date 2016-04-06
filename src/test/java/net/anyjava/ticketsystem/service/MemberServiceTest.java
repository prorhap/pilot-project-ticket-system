package net.anyjava.ticketsystem.service;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

import net.anyjava.TicketApplication;
import net.anyjava.ticketsystem.domain.Member;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = TicketApplication.class)
public class MemberServiceTest {

    @Autowired
    private MemberService memberService;


    @Test
    @Transactional
    public void testJoinMember() {

        // Given
        Member member = new Member();
        member.setName("SON");
        member.setEmail("htson@woowahan.com");
        member.setPassWord("qwer1234");

        // When
        Member joinedMember = memberService.join(member);

        // Then
        assertThat(member.getEmail(), equalTo(joinedMember.getEmail()));
    }

    // TODO : Exception class 정의하기
    @Test(expected = RuntimeException.class)
    @Transactional
    public void testDuplicateJoin() {
        // TODO : 중복가입처리
        // Given
        Member member = new Member();
        member.setName("SON");
        member.setEmail("htson@woowahan.com");
        member.setPassWord("qwer1234");

        memberService.join(member);

        Member member2 = new Member();
        member2.setName("SON");
        member2.setEmail("htson@woowahan.com");
        member2.setPassWord("qwer1234");

        // When
        memberService.join(member2);

        // Then
        fail("실행되면 안되는 블록");

    }
}
