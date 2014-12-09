/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ilegra.jt.lancamentodehoras.routes;

import com.ilegra.jt.lancamentodehoras.model.Activity;
import spark.Request;

/**
 *
 * @author Paulo
 */
public class RequestMapping {
    
    public Activity  mapRequestToActivity(Request request){               
        Activity activity = new Activity(); 
        activity.setDescription(request.queryParams("descricao"));
        return activity;
    }
    
}
