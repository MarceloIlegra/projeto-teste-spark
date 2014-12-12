package com.ilegra.jt.lancamentodehoras.service;

import com.ilegra.jt.lancamentodehoras.dao.ActivityDAO;
import com.ilegra.jt.lancamentodehoras.model.Activity;
import com.ilegra.jt.lancamentodehoras.model.User;
import com.ilegra.jt.lancamentodehoras.validators.ActivityValidator;

public class ActivityService {
    
    public void save(User user, Activity activity) {                
        if (ActivityValidator.isValid(activity)) new ActivityDAO().add(user,activity);
    }     

}
