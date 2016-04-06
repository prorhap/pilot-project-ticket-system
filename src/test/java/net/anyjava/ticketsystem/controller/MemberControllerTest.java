package net.anyjava.ticketsystem.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.databind.ObjectMapper;
import net.anyjava.TicketApplication;
import net.anyjava.ticketsystem.domain.Member;
import net.anyjava.ticketsystem.service.MemberService;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = TicketApplication.class)
@WebAppConfiguration
public class MemberControllerTest {

    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Autowired
    private MemberService memberService;

    /**
     * MockMvc
     */
    @Before
    public void setup() {
        mockMvc = MockMvcBuilders
                .webAppContextSetup(webApplicationContext)
                .build();
    }

    @Test
    public void testJoinMember() throws Exception {
        // Given
        Member member = new Member();
        member.setName("SON");
        member.setEmail("anyjava.kr@gmail.com");
        member.setPassWord("qwer1234");

        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(member);

        // When
        ResultActions perform = mockMvc.perform(
                post("/members")
                        .contentType(MediaType.APPLICATION_JSON_UTF8)
                        .content(json));

        // Then
        perform.andExpect(status().isOk());

    }

    @Test
    public void testJoinMemberDup() throws Exception {
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

        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(member2);

        // When
        ResultActions perform = mockMvc.perform(
                post("/members")
                        .contentType(MediaType.APPLICATION_JSON_UTF8)
                        .content(json));

        // Then
        perform.andExpect(status().is5xxServerError());

    }


}
