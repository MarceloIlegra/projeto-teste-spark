package com.ilegra.jt.lancamentodehoras.dao;

import com.ilegra.jt.lancamentodehoras.pojo.Activity;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.Arrays;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

public class ActivityDAOTest {
    
    private final ActivityDAO dao = new ActivityDAO();      
    
    @Before
    public void setup(){
        int year = 2014;
        Month month = Month.DECEMBER; 
        int dayOfMonth = 5;        
        Activity first = new Activity();
        first.setStartHour(LocalDateTime.of(year, month, dayOfMonth, 10, 0));
        first.setFinishHour(LocalDateTime.of(year, month, dayOfMonth, 12, 0));        
        Activity second = new Activity();
        second.setStartHour(LocalDateTime.of(year, month, dayOfMonth, 13, 0));
        second.setFinishHour(LocalDateTime.of(year, month, dayOfMonth, 15, 30));        
        Memory.activities = Arrays.asList(first, second);        
    }
    
    @Test
    public void getTotalTimeInMinutesSumCorrectly(){   
        int expected = (4*60)+30;
        assertEquals(expected, this.dao.getTotalTimeInMinutes());        
    }
    
    @Test
    public void getTotalTimeFormatedReturnStringCorrectlyFormated(){   
        assertEquals("4:30", this.dao.getTotalTimeFormated());        
    }   
}
