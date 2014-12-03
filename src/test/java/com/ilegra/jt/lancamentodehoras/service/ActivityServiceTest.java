
package com.ilegra.jt.lancamentodehoras.service;

import java.time.LocalDateTime;
import java.time.Month;
import static org.junit.Assert.*;
import org.junit.Test;

public class ActivityServiceTest {
        
    @Test
    public void oMetodoIsEmptyQuandoRecebeVazioRetornaTrue(){        
        assertEquals(true, ActivityService.isEmpty(""));        
    }

    @Test
    public void oMetodoIsNullQuandoRecebeNullRetornaTrue(){        
        assertEquals(true, ActivityService.isNull(null));        
    }
    
    @Test
    public void oMetodoValidateDateQuandoRecebeUmTextoForaDoPadraoPtBrRetornaFalse(){
        assertEquals(false, ActivityService.validateDate("2014-02-20"));
    }
    
    @Test
    public void oMetodoValidateDateQuandoRecebeUmTextoNoFormatoPtBrRetornaTrue(){
        assertEquals(true, ActivityService.validateDate("20/12/2014"));
    }    

    @Test
    public void oMetodoIsHourQuandoRecebeUmTextoContendoUmHorarioNoFormatoHoraMinutoRetornaTrue(){
        assertEquals(true, ActivityService.isHour("20:00"));
    }

    @Test
    public void isHourQuandoRecebeUmTextoInvalidoRetornaFalse(){
        assertEquals(false, ActivityService.isHour("textoInvalido"));
    }    

    @Test
    public void toLocalDateTimeConverteCorretamente(){
        
        LocalDateTime expected = LocalDateTime.of(2014, Month.MARCH, 10, 10, 20);
        LocalDateTime actual = ActivityService.toLocalDateTime("10/03/2014", "10:20");
        
        assertEquals(expected, actual);
        
    }
    

}
