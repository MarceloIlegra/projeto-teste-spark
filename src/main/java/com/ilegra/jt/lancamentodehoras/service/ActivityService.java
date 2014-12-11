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
import static com.ilegra.jt.lancamentodehoras.validators.ActivityValidator.*;
import static com.ilegra.jt.lancamentodehoras.validators.DateHelper.*;
import java.time.LocalDateTime;
import spark.Request;
import java.util.Optional;

public class ActivityService {
    
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

        if (validateDate(date) && isHour(startHourText)) {startHour = toLocalDateTime(date, startHourText);}
        if (validateDate(date) && isHour(finishHourText)) {finishHour = toLocalDateTime(date, finishHourText);}

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
                && validateStartDateAfterToday(startHour)
                && !isOverlapHour(startHour,finishHour)){
            ActivityRepository ActivityDAO = new ActivityDAO();
            ActivityDAO.add(user, project, activity1);
        }
    }     
}
