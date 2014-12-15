package com.ilegra.jt.lancamentodehoras.validators;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class RequestValidator {

    private static final LocalDateTime today = LocalDateTime.now();
    public static final int LIMIT_DAYS = 5;

    public static boolean isIntervalFormatValid(String datePTbr, String startHour, String finishHour){
       return RequestValidator.validateDate(datePTbr) 
                && ActivityValidator.isHour(startHour) 
                && ActivityValidator.isHour(finishHour); 
    }
    
    public static LocalDateTime toLocalDateTime(String date, String hour) {
        return LocalDateTime.of(LocalDate.parse(date, DateTimeFormatter.ofPattern("dd/MM/yyyy")), LocalTime.parse(hour));
    }

    public static boolean validateDate(String date) {
        if (!isEmpty(date) && !isNull(date)) {
            try {
                LocalDate.parse(date, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
            } catch (java.time.format.DateTimeParseException exceptionMessage) {
                return false;
            }
        }
        return true;
    }

    public static boolean isNull(String data) {
        return data == null;
    }

    public static boolean isEmpty(String data) {
        return data.equals("");
    }

    public static boolean validateStartDateBeforeToday(LocalDateTime startHour) {
        return startHour.isAfter(today.minusDays(LIMIT_DAYS));
    }

    public static boolean validateStartDateAfterToday(LocalDateTime startHour) {
        return !startHour.isAfter(today);
    }    
}
