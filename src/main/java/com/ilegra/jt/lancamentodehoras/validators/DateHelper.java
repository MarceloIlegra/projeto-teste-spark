package com.ilegra.jt.lancamentodehoras.validators;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class DateHelper {

    private static final LocalDateTime today = LocalDateTime.now();
    private static final int daysLimit = 5;

    public static boolean isIntervalFormatValid(String datePTbr, String startHour, String finishHour){
       return DateHelper.validateDate(datePTbr) 
                && ActivityValidator.isHour(startHour) 
                && ActivityValidator.isHour(finishHour); 
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
        if (isValidate) {
            try {
                localDate = LocalDate.parse(date, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
            } catch (java.time.format.DateTimeParseException exceptionMessage) {
                isValidate = false;
            }
        }
        return isValidate;
    }

    public static boolean isNull(String data) {
        return data == null;
    }

    public static boolean isEmpty(String data) {
        return data.equals("");
    }

    public static boolean validateStartDateBeforeToday(LocalDateTime startHour) {
        LocalDateTime dataLimit = today.minusDays(daysLimit);
        return startHour.isAfter(dataLimit);
    }

    public static boolean validateStartDateAfterToday(LocalDateTime startHour) {
        return !startHour.isAfter(today);
    }    
}
