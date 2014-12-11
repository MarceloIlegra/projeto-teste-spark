package com.ilegra.jt.lancamentodehoras.service;

import com.ilegra.jt.lancamentodehoras.dao.ActivityDAO;
import com.ilegra.jt.lancamentodehoras.model.Activity;
import com.ilegra.jt.lancamentodehoras.model.User;
import com.ilegra.jt.lancamentodehoras.routes.RequestMapping;
import com.ilegra.jt.lancamentodehoras.validators.ActivityValidator;
import com.ilegra.jt.lancamentodehoras.validators.DateHelper;
import spark.Request;

public class ActivityService {
    
    public void save(Request request) {        
        if(DateHelper.isIntervalFormatValid(request.queryParams("data"), 
                request.queryParams("horainicio"), request.queryParams("horafim"))){            
            Activity activity = new RequestMapping().mapRequestToActivity(request);
            User user = request.session().attribute("login");            
            if (ActivityValidator.isValid(activity)) new ActivityDAO().add(user,activity);
        }
    }     

}
