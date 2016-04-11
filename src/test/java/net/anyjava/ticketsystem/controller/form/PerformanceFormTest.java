package net.anyjava.ticketsystem.controller.form;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import net.anyjava.ticketsystem.domain.Performance;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;

public class PerformanceFormTest {

    /**
     * PerformanceForm 생성
     * @return PerformanceForm
     */
    public static PerformanceForm getTestPerformanceForm() {
        try {
            PerformanceForm performanceForm = new PerformanceForm();
            performanceForm.setTitle("아이유 콘서트");

            performanceForm.setStartDate(new SimpleDateFormat("yyyy/MM/dd").parse("2016/05/01"));
            performanceForm.setTicketOpenDate(new SimpleDateFormat("yyyy/MM/dd HH:mm").parse("2016/04/01 14:00"));
            performanceForm.setTotalTicketCount(100);
            return performanceForm;
        }catch(ParseException e) {
            throw new RuntimeException("Exception while parsing date format", e);
        }

    }

    @Test
    public void testCreateEntity() {
        // Given
        PerformanceForm performanceForm
                = PerformanceFormTest.getTestPerformanceForm();

        // When
        Performance performance = Performance.of(performanceForm);

        // Then
        assertThat(LocalDate.of(2016, 5, 1),
                equalTo(performance.getStartDate()));
    }

}
