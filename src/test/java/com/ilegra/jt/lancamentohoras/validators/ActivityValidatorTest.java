package com.ilegra.jt.lancamentohoras.validators;

import com.ilegra.jt.lancamentodehoras.dao.Memory;
import com.ilegra.jt.lancamentodehoras.model.Activity;
import com.ilegra.jt.lancamentodehoras.validators.ActivityValidator;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.Arrays;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

public class ActivityValidatorTest {
    
    @Before
    public void setup() {
        int year = 2014;
        Month month = Month.DECEMBER;
        int dayOfMonth = 5;
        Activity first = new Activity();
        first.setStartHour(LocalDateTime.of(year, month, dayOfMonth, 9, 30));
        first.setFinishHour(LocalDateTime.of(year, month, dayOfMonth, 10, 30));
        Memory.activities = Arrays.asList(first);
    }
    @Test
    public void receiveTextContainsHoursInFormatHoursMinuteReturnTrue() {
        assertEquals(true, ActivityValidator.isHour("20:00"));
    }

    @Test
    public void receiveInvalidTextReturnFalse() {
        assertEquals(false, ActivityValidator.isHour("textoInvalido"));
    }
    @Test
    public void validateStartHourUpperThanFinishHour() {
        LocalDateTime start = LocalDateTime.of(2014, Month.MARCH, 10, 20, 20);
        LocalDateTime end = LocalDateTime.of(2014, Month.MARCH, 10, 10, 20);
        assertFalse(ActivityValidator.validateHours(start, end));
    }

    @Test
    public void validateStartHourLowerThanFinishHour() {
        LocalDateTime start = LocalDateTime.of(2014, Month.MARCH, 10, 2, 20);
        LocalDateTime end = LocalDateTime.of(2014, Month.MARCH, 10, 10, 20);
        assertTrue(ActivityValidator.validateHours(start, end));
    }

    @Test
    public void startHourAlreadyExist() {
        LocalDateTime start = LocalDateTime.of(2014, Month.DECEMBER, 5, 10, 00);
        LocalDateTime end = LocalDateTime.of(2014, Month.DECEMBER, 5, 10, 40);
        assertTrue(ActivityValidator.isOverlapHour(start, end));
    }

    @Test
    public void finishHourAlreadyExist() {
        LocalDateTime start = LocalDateTime.of(2014, Month.DECEMBER, 5, 9, 00);
        LocalDateTime end = LocalDateTime.of(2014, Month.DECEMBER, 5, 9, 40);
        assertTrue(ActivityValidator.isOverlapHour(start, end));
    }

    @Test
    public void timeInsideARangeAlreadyRegistered() {
        LocalDateTime start = LocalDateTime.of(2014, Month.DECEMBER, 5, 9, 40);
        LocalDateTime end = LocalDateTime.of(2014, Month.DECEMBER, 5, 10, 10);
        assertTrue(ActivityValidator.isOverlapHour(start, end));
    }

    @Test
    public void dateWithtHoursAlreadyRegistered() {
        LocalDateTime start = LocalDateTime.of(2014, Month.DECEMBER, 5, 9, 0);
        LocalDateTime end = LocalDateTime.of(2014, Month.DECEMBER, 5, 11, 0);
        assertTrue(ActivityValidator.isOverlapHour(start, end));
    }

    @Test
    public void periodEqualsAlreadyRegistered() {
        LocalDateTime start = LocalDateTime.of(2014, Month.DECEMBER, 5, 9, 20);
        LocalDateTime end = LocalDateTime.of(2014, Month.DECEMBER, 5, 10, 30);
        assertTrue(ActivityValidator.isOverlapHour(start, end));
    }    
    
    @Test
    public void periodNotOverLap() {
        LocalDateTime start = LocalDateTime.of(2014, Month.DECEMBER, 5, 8, 0);
        LocalDateTime end = LocalDateTime.of(2014, Month.DECEMBER, 5, 8, 30);
        assertFalse(ActivityValidator.isOverlapHour(start, end));
    }  
}
