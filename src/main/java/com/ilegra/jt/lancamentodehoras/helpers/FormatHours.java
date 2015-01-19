package com.ilegra.jt.lancamentodehoras.helpers;

import com.ilegra.jt.lancamentodehoras.dao.Memory;

public class WorkHoursFormated {
    
    private long getTotalTimeInMinutes(){
        return Memory.activities
                .stream()
                .mapToLong((activity)->activity.getWorkedHours().toMinutes())
                .sum();        
    }    
    public String getTotalTimeFormated(){
        long minutes = this.getTotalTimeInMinutes();
        long hours = (long)Math.floor(minutes/60);
        long min = minutes % 60;       
        return String.format("%d:%d", hours, min);
    }  
}
