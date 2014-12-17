package com.ilegra.jt.lancamentodehoras.routes;

import com.ilegra.jt.lancamentodehoras.dao.ActivityTypeDAO;
import com.ilegra.jt.lancamentodehoras.dao.GroupDAO;
import com.ilegra.jt.lancamentodehoras.dao.ProjectDAO;
import com.ilegra.jt.lancamentodehoras.dao.SubProjectDAO;
import com.ilegra.jt.lancamentodehoras.dao.UserDAO;
import com.ilegra.jt.lancamentodehoras.pojo.Activity;
import static com.ilegra.jt.lancamentodehoras.validators.RequestValidator.toLocalDateTime;
import spark.Request;

public class RequestMapping {
    Activity activity = new Activity();
    
    public Activity  mapRequestToActivity(Request request){          
        loadActivity(request);   
        idNotEmpty(request);         
        return activity;
    }
    
    private void loadActivity(Request request) {
        activity.setUser(new UserDAO().login(request.queryParams("usuario"),request.queryParams("senha")).get());
        activity.setStartHour(toLocalDateTime(request.queryParams("data"), request.queryParams("horainicio")));
        activity.setFinishHour(toLocalDateTime(request.queryParams("data"), request.queryParams("horafim")));
        activity.setProject(new ProjectDAO().getById(new Integer(request.queryParams("projeto"))).get());
        activity.setSubProject(new SubProjectDAO().getById(new Integer(request.queryParams("subprojeto"))).get());
        activity.setGroup(new GroupDAO().getById(new Integer(request.queryParams("grupo"))).get());
        activity.setActivityType(new ActivityTypeDAO().getById(new Integer(request.queryParams("tipo_atividade"))).get());
        activity.setDescription(request.queryParams("descricao"));
    }
    private void idNotEmpty(Request request){
        if(request.queryParams(":id") !=null && !request.queryParams(":id").equals("")){
            activity.setId(new Long(request.queryParams(":id")));             
        }      
    }
}
