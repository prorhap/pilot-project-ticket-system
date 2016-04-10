package net.anyjava.ticketsystem.controller.form;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import net.anyjava.ticketsystem.domain.Performance;
import org.junit.Test;

import java.time.LocalDate;

public class PerformanceFormTest {

    /**
     * PerformanceForm 생성
     * @return PerformanceForm
     */
    public static PerformanceForm getTestPerformanceForm() {
        PerformanceForm performanceForm = new PerformanceForm();
        performanceForm.setTitle("아이유 콘서트");
        performanceForm.setStartYear(2016);
        performanceForm.setStartMonth(5);
        performanceForm.setStartDay(1);
        performanceForm.setReservationStartYear(2016);
        performanceForm.setReservationStartMonth(4);
        performanceForm.setReservationStartDay(1);
        performanceForm.setReservationStartHour(14);
        performanceForm.setReservationStartMinute(00);
        performanceForm.setTotalTicketCount(10);

        return performanceForm;
    }

    @Test
    public void testCreateEntityByForm() throws JsonProcessingException {
        // Given
        PerformanceForm performanceForm
                = PerformanceFormTest.getTestPerformanceForm();

        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(performanceForm);

        System.out.println("json = " + json);

        // When
        Performance performance = performanceForm.getEntity();

        // Then
        assertThat(LocalDate.of(2016, 5, 1),
                equalTo(performance.getStartDate()));
    }

}
