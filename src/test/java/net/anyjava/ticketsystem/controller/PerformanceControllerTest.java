package net.anyjava.ticketsystem.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.databind.ObjectMapper;

import net.anyjava.TicketApplication;
import net.anyjava.ticketsystem.controller.form.PerformanceForm;
import net.anyjava.ticketsystem.controller.form.PerformanceFormTest;
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
public class PerformanceControllerTest {

    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext webApplicationContext;

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
    public void testRegisterPerformance() throws Exception {

        // Given
        PerformanceForm iuConcert
                = PerformanceFormTest.getTestPerformanceForm();

        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(iuConcert);

        // When
        ResultActions perform = mockMvc.perform(
                post("/performances")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(json));

        // Then
        perform.andExpect(status().isOk());

    }



}
