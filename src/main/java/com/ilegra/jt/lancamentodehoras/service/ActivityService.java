package com.ilegra.jt.lancamentodehoras.service;

import com.ilegra.jt.lancamentodehoras.dao.ActivityDAO;
import com.ilegra.jt.lancamentodehoras.dao.ActivityTypeDAO;
import com.ilegra.jt.lancamentodehoras.dao.GroupDAO;
import com.ilegra.jt.lancamentodehoras.dao.ProjectDAO;
import com.ilegra.jt.lancamentodehoras.dao.SubProjectDAO;
import com.ilegra.jt.lancamentodehoras.model.Activity;
import com.ilegra.jt.lancamentodehoras.model.ActivityType;
import com.ilegra.jt.lancamentodehoras.model.Group;
import com.ilegra.jt.lancamentodehoras.model.Project;
import com.ilegra.jt.lancamentodehoras.model.SubProject;
import com.ilegra.jt.lancamentodehoras.model.User;
import com.ilegra.jt.lancamentodehoras.repository.ActivityRepository;
import com.ilegra.jt.lancamentodehoras.repository.ActivityTypeRepository;
import com.ilegra.jt.lancamentodehoras.repository.GroupRepository;
import com.ilegra.jt.lancamentodehoras.repository.ProjectRepository;
import com.ilegra.jt.lancamentodehoras.repository.SubProjectRepository;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import spark.Request;
import java.util.Optional;
import java.util.stream.Collectors;

public class ActivityService {

    private static final LocalDateTime today = LocalDateTime.now();
    private static final int LIMIT = 5;

    public void save(Request request) {

        String date = request.queryParams("data");
        String startHourText = request.queryParams("horainicio");
        String finishHourText = request.queryParams("horafim");
        String projectText = request.queryParams("projeto");
        String subProjectText = request.queryParams("subprojeto");
        String groupsText = request.queryParams("grupo");
        String activityTypeText = request.queryParams("tipo_atividade");
        String description = request.queryParams("descricao");

        LocalDateTime startHour = null;
        LocalDateTime finishHour = null;

        if (validateDate(date) && isHour(startHourText)) {

            startHour = toLocalDateTime(date, startHourText);

        }

        if (validateDate(date) && isHour(finishHourText)) {

            finishHour = toLocalDateTime(date, finishHourText);

        }

        ProjectRepository projectDAO = new ProjectDAO();
        Optional<Project> optionalProject = projectDAO.getById(new Integer(projectText));
        Project project = optionalProject.get();

        SubProjectRepository subProjectDAO = new SubProjectDAO();
        Optional<SubProject> optionalSubProject = subProjectDAO.getById(new Integer(subProjectText));
        SubProject subProject = optionalSubProject.get();

        GroupRepository groupDAO = new GroupDAO();
        Optional<Group> optionalGroup = groupDAO.getById(new Integer(groupsText));
        Group group = optionalGroup.get();

        ActivityTypeRepository activityTypeDAO = new ActivityTypeDAO();
        Optional<ActivityType> optionalActivityType = activityTypeDAO.getById(new Integer(activityTypeText));
        ActivityType activityType = optionalActivityType.get();

        User user = new User();
        user.setLogin("aline");
        user.setPassword("1234");

        Activity activity1 = new Activity();
        activity1.setUser(user);
        activity1.setStartHour(startHour);
        activity1.setFinishHour(finishHour);
        activity1.setSubProject(subProject);
        activity1.setGroup(group);
        activity1.setActivityType(activityType);
        activity1.setDescription(description);

        if (validateHours(startHour, finishHour)
                && validateStartDateBeforeToday(startHour)
                && validateStartDateAfterToday(startHour)) {
            ActivityRepository ActivityDAO = new ActivityDAO();
            ActivityDAO.add(user, project, activity1);
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

        if (isValidate) {

            try {
                localDate = LocalDate.parse(date, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
            } catch (java.time.format.DateTimeParseException exceptionMessage) {
                isValidate = false;
            }

        }

        return isValidate;
    }

    public static boolean isHour(String hour) {

        boolean isValid = true;

        try {
            LocalTime time = LocalTime.parse(hour);
        } catch (java.time.format.DateTimeParseException exceptionMessage) {
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

    public static boolean validateHours(LocalDateTime starHour, LocalDateTime finishHour) {

        return !starHour.isAfter(finishHour);

    }

    public static boolean validateStartDateBeforeToday(LocalDateTime startHour) {

        LocalDateTime dataLimit = today.minusDays(LIMIT);

        return startHour.isAfter(dataLimit);

    }

    public static boolean validateStartDateAfterToday(LocalDateTime startHour) {

        return !startHour.isAfter(today);

    }
    
    public static boolean isHoraSobrePosta(LocalDateTime startHour, LocalDateTime finishHour){        
        List<Activity> activities = new ActivityDAO().listAll();
        int total = activities.stream()
                .filter((valor)->startHour.isBefore(valor.getStartHour()) && finishHour.isAfter(valor.getFinishHour()))
                .collect(Collectors.toList())
                .size();
        return total > 0 ;        
    }

}
