
package com.ilegra.jt.lancamentodehoras.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import spark.Request;

public class ActivityService {
    
    public void save(Request request){
        
        String date = request.queryParams("nova-atividade-data");
        String hour = request.queryParams("horainicio");
        LocalDateTime startHour = null;
        
        if(validateDate(date) && isHour(hour)){
            
            startHour = toLocalDateTime(date, hour);         
            
        }
        
    }

    public static LocalDateTime toLocalDateTime(String date, String hour) {
        
        LocalTime time = LocalTime.parse(hour);
        
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate localDate = LocalDate.parse(date, formatter);
        
        return LocalDateTime.of(localDate, time);
        
    }

    public static boolean validateDate(String date) {
        
        boolean isValidate = !isEmpty(date) && !isNull(date);
        
        if(isValidate){
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");

            try {
                simpleDateFormat.parse(date);
            } catch (ParseException exceptionMessage) {
                isValidate = false;
            }            
        }        
        
        return isValidate;        
    }

    public static boolean isHour(String hour){
            
        boolean isValid = true;
        
        try{
            LocalTime time = LocalTime.parse(hour);    
        }catch(java.time.format.DateTimeParseException exceptionMessage){
            isValid = false;
        }
                
        return isValid;
    }
    
    public static boolean isNull(String data) {
        return data == null;
    }

    public static boolean isEmpty(String data) {
        return data.equals("");
    }
    
}
