package com.ilegra.jt.lancamentohoras.validators;

import com.ilegra.jt.lancamentodehoras.validators.DateHelper;
import java.time.LocalDateTime;
import java.time.Month;
import org.junit.Test;
import static org.junit.Assert.*;

public class DateHelperTest {
    
    private static final LocalDateTime today = LocalDateTime.now();

    @Test
    public void receiveEmptyReturnTrue() {
        assertEquals(true, DateHelper.isEmpty(""));
    }

    @Test
    public void receiveNullReturnTrue() {
        assertEquals(true, DateHelper.isNull(null));
    }

    @Test
    public void receiveTextOutOfBrazilianDateFormatReturFalse() {
        assertEquals(false, DateHelper.validateDate("2014-02-20"));
    }

    @Test
    public void receiveTextInBrazilianDateFormatReturnTrue() {
        assertEquals(true, DateHelper.validateDate("20/12/2014"));
    }

    @Test
    public void receiveInvalidDayReturnFalse() {
        assertEquals(false, DateHelper.validateDate("50/12/2014"));
    }

    @Test
    public void receiveInvalidMonthReturnFalse() {
        assertEquals(false, DateHelper.validateDate("20/13/2014"));
    }
    @Test
    public void toLocalDateTimeConvertCorrectly() {

        LocalDateTime expected = LocalDateTime.of(2014, Month.MARCH, 10, 10, 20);
        LocalDateTime actual = DateHelper.toLocalDateTime("10/03/2014", "10:20");

        assertEquals(expected, actual);

    }
    @Test
    public void startDateBeforeToday() {
        LocalDateTime startDate = today.minusDays(5);
        assertFalse(DateHelper.validateStartDateBeforeToday(startDate));
    }

    @Test
    public void startDateAfterToday() {
        LocalDateTime startDate = today.plusDays(1);
        assertFalse(DateHelper.validateStartDateAfterToday(startDate));
    }
}
