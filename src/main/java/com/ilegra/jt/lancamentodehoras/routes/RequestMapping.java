package com.ilegra.jt.lancamentodehoras.routes;

import com.ilegra.jt.lancamentodehoras.pojo.Activity;
import com.ilegra.jt.lancamentodehoras.service.ActivityTypeService;
import com.ilegra.jt.lancamentodehoras.service.GroupService;
import com.ilegra.jt.lancamentodehoras.service.ProjectService;
import com.ilegra.jt.lancamentodehoras.service.SubProjectService;
import static com.ilegra.jt.lancamentodehoras.validators.RequestValidator.toLocalDateTime;
import spark.Request;

public class RequestMapping {
    
    public Activity mapRequestToActivity(Request request) {
        Activity activity = new Activity();
        activity.setStartHour(toLocalDateTime(request.queryParams("data"), request.queryParams("horainicio")));
        activity.setFinishHour(toLocalDateTime(request.queryParams("data"), request.queryParams("horafim")));
        activity.setProject((ProjectService.getById(new Integer(request.queryParams("project")))));
        activity.setSubProject((SubProjectService.getById(new Integer(request.queryParams("subprojeto")))));
        activity.setGroup(GroupService.getById(new Integer(request.queryParams("gurpo"))));
        activity.setActivityType(ActivityTypeService.getById(new Integer(request.queryParams("tipo_atividade"))));       
        activity.setDescription(request.queryParams("descricao"));
        activity.setId(setId(request.queryParams(":id")));
        return activity;
    }    
    private Long setId(String id){
        return id != null && !id.isEmpty() ? new Long(id) : null;             
    }  
}
