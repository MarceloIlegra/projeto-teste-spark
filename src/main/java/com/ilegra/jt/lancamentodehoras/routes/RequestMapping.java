package com.ilegra.jt.lancamentodehoras.routes;

import com.ilegra.jt.lancamentodehoras.dao.ActivityTypeDAO;
import com.ilegra.jt.lancamentodehoras.dao.GroupDAO;
import com.ilegra.jt.lancamentodehoras.dao.ProjectDAO;
import com.ilegra.jt.lancamentodehoras.dao.SubProjectDAO;
import com.ilegra.jt.lancamentodehoras.pojo.Activity;
import static com.ilegra.jt.lancamentodehoras.validators.RequestValidator.toLocalDateTime;
import spark.Request;

public class RequestMapping {
    
    public Activity  mapRequestToActivity(Request request){               
        Activity activity = new Activity();
        activity.setStartHour(toLocalDateTime(request.queryParams("data"), request.queryParams("horainicio")));
        activity.setFinishHour(toLocalDateTime(request.queryParams("data"), request.queryParams("horafim")));
        activity.setProject(new ProjectDAO().getById(new Integer(request.queryParams("projeto"))).get());
        activity.setSubProject(new SubProjectDAO().getById(new Integer(request.queryParams("subprojeto"))).get());
        activity.setGroup(new GroupDAO().getById(new Integer(request.queryParams("grupo"))).get());
        activity.setActivityType(new ActivityTypeDAO().getById(new Integer(request.queryParams("tipo_atividade"))).get());
        activity.setDescription(request.queryParams("descricao")); 
        if(request.params(":id") != null && !request.params(":id").equals("")){
            activity.setId(new Long(request.params(":id")));
        }
        return activity;
    }    
}
