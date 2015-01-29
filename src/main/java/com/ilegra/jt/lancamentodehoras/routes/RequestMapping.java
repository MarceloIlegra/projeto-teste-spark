package com.ilegra.jt.lancamentodehoras.routes;

import com.ilegra.jt.lancamentodehoras.pojo.Activity;
import com.ilegra.jt.lancamentodehoras.pojo.ActivityType;
import com.ilegra.jt.lancamentodehoras.pojo.Group;
import com.ilegra.jt.lancamentodehoras.pojo.Project;
import com.ilegra.jt.lancamentodehoras.pojo.SubProject;
import com.ilegra.jt.lancamentodehoras.service.ActivityTypeService;
import com.ilegra.jt.lancamentodehoras.service.GroupService;
import com.ilegra.jt.lancamentodehoras.service.ProjectService;
import com.ilegra.jt.lancamentodehoras.service.SubProjectService;
import static com.ilegra.jt.lancamentodehoras.validators.RequestValidator.toLocalDateTime;
import java.util.Optional;
import spark.Request;

public class RequestMapping {
    
    
    public Activity mapRequestToActivity(Request request) {
        Activity activity = new Activity();  
        activity.setUser(request.session().attribute("login"));
        activity.setStartHour(toLocalDateTime(request.queryParams("data"), request.queryParams("horainicio")));
        activity.setFinishHour(toLocalDateTime(request.queryParams("data"), request.queryParams("horafim")));
        activity.setProject(ProjectService.getById(new Integer(request.queryParams("projeto"))).get());
        activity.setSubProject(SubProjectService.getById(new Integer(request.queryParams("subprojeto"))).get());
        activity.setGroup(GroupService.getById(new Integer(request.queryParams("grupo"))).get());
        activity.setActivityType(ActivityTypeService.getById(new Integer(request.queryParams("tipo_atividade"))).get());
        activity.setDescription(request.queryParams("descricao"));       
        if(request.queryParams("nova-atividade-id") !=null && !request.queryParams("nova-atividade-id").equals("")){
            activity.setId(new Long(request.queryParams("nova-atividade-id")));             
        }
        return activity;
    }
    
    public short requestToShort(Request request){
        return Short.parseShort(request.queryParams("mes_ano"));
    }
    
    public Optional<Project> requestToProject(Request request){
        ProjectService projectService = new ProjectService();
        return projectService.getById(new Integer(request.queryParams("projeto")));
    }
    
    public Optional<SubProject> requestToSubProject(Request request){
        SubProjectService subProjectService = new SubProjectService();
        return subProjectService.getById(new Integer(request.queryParams("subprojeto")));
    }
    
    public Optional<Group> requestToGroup(Request request){
        GroupService groupService = new GroupService();
        return groupService.getById(new Integer(request.queryParams("grupo")));
    }
    
    public Optional<ActivityType> requestToActivityType(Request request){
        ActivityTypeService activityTypeService = new ActivityTypeService();
        return activityTypeService.getById(new Integer(request.queryParams("tipo_atividade")));
    }
}
