
package com.ilegra.jt.lancamentodehoras.service;

import com.ilegra.jt.lancamentodehoras.dao.ProjectDAO;
import com.ilegra.jt.lancamentodehoras.exceptions.ProjectNotFoundException;
import com.ilegra.jt.lancamentodehoras.model.Project;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import java.util.logging.Logger;
import spark.Request;

public class ActivityService {
    
    public void save(Request request){
        
        String date = request.queryParams("nova-atividade-data");
        String startHourText = request.queryParams("horainicio");
        String finishHourText = request.queryParams("horafim");
        String projectText = request.queryParams("nova-atividade-projeto");
        
        LocalDateTime startHour = null;
        LocalDateTime finishHour = null;
        
        if(validateDate(date) && isHour(startHourText)){
            
            startHour = toLocalDateTime(date, startHourText);         
            
        }

        if(validateDate(date) && isHour(finishHourText)){
            
            finishHour = toLocalDateTime(date, finishHourText);         
            
        }   
        
        ProjectDAO projectDAO = new ProjectDAO();
        try {
            Project project = projectDAO.getById(new Integer(projectText));
        } catch (ProjectNotFoundException ex) {
            System.out.println("Expection Message: " + ex.getMessage());
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
        LocalDate localDate = null;
        
        if(isValidate){
            
            try{
                localDate = LocalDate.parse(date, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
            }catch(java.time.format.DateTimeParseException exceptionMessage){
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
