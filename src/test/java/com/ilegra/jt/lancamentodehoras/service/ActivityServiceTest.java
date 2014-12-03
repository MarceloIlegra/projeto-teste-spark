package com.ilegra.jt.lancamentodehoras.service;

import java.time.LocalDateTime;
import java.time.Month;
import static org.junit.Assert.*;
import org.junit.Test;

public class ActivityServiceTest {

    @Test
    public void receiveEmptyReturnFalse() {
        assertEquals(true, ActivityService.isEmpty(""));
    }

    @Test
    public void receiveNullReturnTrue() {
        assertEquals(true, ActivityService.isNull(null));
    }

    @Test
    public void receiveTextOutOfBrazilianDateFormatReturFalse() {
        assertEquals(false, ActivityService.validateDate("2014-02-20"));
    }

    @Test
    public void receiveTextInBrazilianDateFormatReturnTrue() {
        assertEquals(true, ActivityService.validateDate("20/12/2014"));
    }

    @Test
    public void receiveTextContainsHoursInFormatHoursMinuteReturnTrue() {
        assertEquals(true, ActivityService.isHour("20:00"));
    }

    @Test
    public void isHourWhenReceiveInvalidTextReturnFalse() {
        assertEquals(false, ActivityService.isHour("textoInvalido"));
    }

    @Test
    public void toLocalDateTimeConvertCorrectly() {

        LocalDateTime expected = LocalDateTime.of(2014, Month.MARCH, 10, 10, 20);
        LocalDateTime actual = ActivityService.toLocalDateTime("10/03/2014", "10:20");

        assertEquals(expected, actual);

    }

}
