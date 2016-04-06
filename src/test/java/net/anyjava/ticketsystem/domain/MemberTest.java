package net.anyjava.ticketsystem.domain;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import net.anyjava.TicketApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by anyjava on 2016. 4. 5..
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = TicketApplication.class)
@Transactional
public class MemberTest {

    @PersistenceContext
    private EntityManager em;

    @Test
    public void testCreateEntity() {
        // Given
        Member member = new Member();
        member.setName("SON");
        member.setEmail("htson@woowahan.com");
        member.setPassWord("qwer1234");

        // When
        em.persist(member);

        em.flush();
        em.clear();

        Member findMember = em.find(Member.class, member.getId());

        // Then
        assertThat(findMember.getId(), equalTo(member.getId()));


    }

}
