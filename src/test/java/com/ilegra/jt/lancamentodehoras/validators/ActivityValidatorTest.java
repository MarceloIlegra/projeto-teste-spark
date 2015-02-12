package com.ilegra.jt.lancamentodehoras.validators;

import com.ilegra.jt.lancamentodehoras.dao.ActivityTypeDAO;
import com.ilegra.jt.lancamentodehoras.dao.GroupDAO;
import com.ilegra.jt.lancamentodehoras.dao.Memory;
import com.ilegra.jt.lancamentodehoras.dao.ProjectDAO;
import com.ilegra.jt.lancamentodehoras.dao.SubProjectDAO;
import com.ilegra.jt.lancamentodehoras.pojo.Activity;
import com.ilegra.jt.lancamentodehoras.validators.ActivityValidator;
import java.time.LocalDateTime;
import java.time.Month;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

public class ActivityValidatorTest {
    
    private static final LocalDateTime today = LocalDateTime.now();
    
    @Before
    public void start(){
        Memory.start();
    }
    
    @Before
    public void setup() {
        Activity first = new Activity();
        Activity second = new Activity();
        first.setStartHour(LocalDateTime.of(today.getYear(), today.getMonth(), today.getDayOfMonth(),8,0));
        first.setFinishHour(LocalDateTime.of(today.getYear(), today.getMonth(), today.getDayOfMonth(),10,0));
        first.setProject(new ProjectDAO().getById(1).get());
        first.setSubProject(new SubProjectDAO().getById(1).get());
        first.setGroup(new GroupDAO().getById(1).get());                
        first.setActivityType(new ActivityTypeDAO().getById(1).get());
        first.setDescription("TESTE");    
        first.setId(new Long(1));
        Memory.activities.add(first);
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
    public void timeInsideARangeAlreadyRegistered() {
        LocalDateTime start = LocalDateTime.of(today.getYear(), today.getMonth(), today.getDayOfMonth(),7, 40);
        LocalDateTime end = LocalDateTime.of(today.getYear(), today.getMonth(), today.getDayOfMonth(),8, 20);
        assertFalse(!ActivityValidator.isOverlapHour(start, end));
    }
    
    @Test
    public void HoraLancadaNãoEstaNoIntervaloDaAtividadeJaLancada(){
        LocalDateTime start = LocalDateTime.of(today.getYear(), today.getMonth(), today.getDayOfMonth(), 12, 0);
        LocalDateTime end = LocalDateTime.of(today.getYear(), today.getMonth(), today.getDayOfMonth(), 18, 0);
        assertTrue(!ActivityValidator.isOverlapHour(start, end));
    }
}
