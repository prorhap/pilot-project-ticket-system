package net.anyjava.ticketsystem.domain;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PerformanceTest {

    @Test
    public void testCreateEntity() {

        Performance performance = Performance.createPerformanc("아이유 콘서트");

        assertEquals("아이유 콘서트", performance.getTitle());
    }

}