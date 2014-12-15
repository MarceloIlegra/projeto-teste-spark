package com.ilegra.jt.lancamentohoras.validators;

import com.ilegra.jt.lancamentodehoras.validators.RequestValidator;
import java.time.LocalDateTime;
import java.time.Month;
import org.junit.Test;
import static org.junit.Assert.*;

public class DateHelperTest {
    
    private static final LocalDateTime today = LocalDateTime.now();

    @Test
    public void receiveEmptyReturnTrue() {
        assertEquals(true, RequestValidator.isEmpty(""));
    }
    
    @Test
    public void receiveNullReturnTrue() {
        assertEquals(true, RequestValidator.isNull(null));
    }
    
    @Test
    public void receiveTextOutOfBrazilianDateFormatReturFalse() {
        assertEquals(false, RequestValidator.validateDate("2014-02-20"));
    }
    
    @Test
    public void receiveTextInBrazilianDateFormatReturnTrue() {
        assertEquals(true, RequestValidator.validateDate("20/12/2014"));
    }
    
    @Test
    public void receiveInvalidDayReturnFalse() {
        assertEquals(false, RequestValidator.validateDate("50/12/2014"));
    }
    
    @Test
    public void receiveInvalidMonthReturnFalse() {
        assertEquals(false, RequestValidator.validateDate("20/13/2014"));
    }
    
    @Test
    public void toLocalDateTimeConvertCorrectly() {

        LocalDateTime expected = LocalDateTime.of(2014, Month.MARCH, 10, 10, 20);
        LocalDateTime actual = RequestValidator.toLocalDateTime("10/03/2014", "10:20");

        assertEquals(expected, actual);
    }
    
    @Test
    public void startDateBeforeToday() {
        LocalDateTime startDate = today.minusDays(RequestValidator.LIMIT_DAYS+1);
        assertFalse(RequestValidator.validateStartDateBeforeToday(startDate));
    }
    
    @Test
    public void startDateAfterToday() {
        LocalDateTime startDate = today.plusDays(1);
        assertFalse(RequestValidator.validateStartDateAfterToday(startDate));
    }
}
