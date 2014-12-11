package com.ilegra.jt.lancamentodehoras.validators;

import com.ilegra.jt.lancamentodehoras.dao.ActivityDAO;
import com.ilegra.jt.lancamentodehoras.model.Activity;
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
                    return timeIsAlreadyDefined(startHour, activity)
                    || timeIsAlreadyDefined(finishHour, activity)
                    || isActivityInsideRange(activity, startHour, finishHour);
                })
                .collect(Collectors.toList())
                .size();
        return total > 0;
    }

    private static boolean isActivityInsideRange(Activity activity, LocalDateTime startRange, LocalDateTime endRange) {
        return startRange.isBefore(activity.getStartHour())
                && endRange.isAfter(activity.getFinishHour());
    }

    private static boolean timeIsAlreadyDefined(LocalDateTime time, Activity activity) {
        if (time.equals(activity.getStartHour()) || time.equals(activity.getFinishHour())) {
            return true;
        }
        return time.isAfter(activity.getStartHour())
                && time.isBefore(activity.getFinishHour());
    }

    public static boolean isValid(Activity activity) {
        return ActivityValidator.validateHours(activity.getStartHour(), activity.getFinishHour())
                && DateHelper.validateStartDateBeforeToday(activity.getStartHour())
                && DateHelper.validateStartDateAfterToday(activity.getStartHour())
                && !ActivityValidator.isOverlapHour(activity.getStartHour(),activity.getFinishHour());
    }    
    
}
