package com.ilegra.jt.lancamentodehoras.service;

import com.ilegra.jt.lancamentodehoras.dao.ActivityDAO;
import com.ilegra.jt.lancamentodehoras.pojo.Activity;
import com.ilegra.jt.lancamentodehoras.pojo.User;
import com.ilegra.jt.lancamentodehoras.validators.ActivityValidator;
import java.util.Optional;

public class ActivityService {
    
    public void save(User user, Activity activity) {                
        if (ActivityValidator.isValid(activity)) new ActivityDAO().add(user,activity);
    } 
    
    public Optional<Activity> findById(long id){
        return new ActivityDAO().find(id);
    }
    
    public boolean update(User user, Activity activity){
        if (ActivityValidator.isValid(activity)){
            new ActivityDAO().update(user, activity.getProject(), activity);
            return true;
        }
        return false;
    }
    public boolean delete(User user, Activity activity){
        if(activity.getId() != null){
            new ActivityDAO().delete(user, activity.getProject(), activity);
            return true;
        }
        return false;        
    }
}
