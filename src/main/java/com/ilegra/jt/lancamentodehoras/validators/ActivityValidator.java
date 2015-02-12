package com.ilegra.jt.lancamentodehoras.validators;

import com.ilegra.jt.lancamentodehoras.dao.ActivityDAO;
import com.ilegra.jt.lancamentodehoras.pojo.Activity;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.stream.Collectors;

public class ActivityValidator {

    public static boolean isHour(String hour) {
        boolean isValid = true;
        try {
            LocalTime time = LocalTime.parse(hour);
        } catch (java.time.format.DateTimeParseException exceptionMessage) {
            isValid = false;
        }
        return isValid;
    }

    public static boolean validateHours(LocalDateTime starHour, LocalDateTime finishHour) {
        return !starHour.isAfter(finishHour);
    }
    public static boolean isOverlapHour(LocalDateTime startHour, LocalDateTime finishHour) {
        List<Activity> activities = new ActivityDAO().listAll();
        int total = activities.stream()
                .filter((activity) -> {
                    return (activityTimeIsBetweenActivityHoursAlreadyRegistred(activity, startHour, finishHour) 
                            || activityTimeBeforeActivityFinalTimeAlreadyRegistred(activity, startHour, finishHour)
                            || activityTimeAfterActivityInitialTimeAlreadyRegistred(activity, startHour, finishHour));
                })
                .collect(Collectors.toList())
                .size();
        return total > 0;
    }
    
    
    public static boolean activityTimeIsBetweenActivityHoursAlreadyRegistred(Activity activity ,LocalDateTime startRange ,LocalDateTime endRange){
          return  startRange.isAfter(activity.getStartHour())
                  && endRange.isBefore(activity.getFinishHour());
    }
    
    public static boolean activityTimeBeforeActivityFinalTimeAlreadyRegistred(Activity activity ,LocalDateTime startRange ,LocalDateTime endRange){
        return startRange.isBefore(activity.getFinishHour())
                && endRange.isAfter(activity.getFinishHour());
    }
    
    public static boolean activityTimeAfterActivityInitialTimeAlreadyRegistred(Activity activity ,LocalDateTime startRange ,LocalDateTime endRange){
        return startRange.isBefore(activity.getStartHour())
                && endRange.isBefore(activity.getFinishHour());
    }
    
    public static boolean isValid(Activity activity) {
        return ActivityValidator.validateHours(activity.getStartHour(), activity.getFinishHour())
                && RequestValidator.validateStartDateBeforeToday(activity.getStartHour())
                && RequestValidator.validateStartDateAfterToday(activity.getStartHour())
                && !ActivityValidator.isOverlapHour(activity.getStartHour(),activity.getFinishHour());
    }
}