package com.ilegra.jt.lancamentodehoras.service;

import com.ilegra.jt.lancamentodehoras.dao.ActivityDAO;
import com.ilegra.jt.lancamentodehoras.pojo.Activity;
import com.ilegra.jt.lancamentodehoras.pojo.User;
import com.ilegra.jt.lancamentodehoras.validators.ActivityValidator;
import java.util.List;
import java.util.Optional;

public class ActivityService {
    
    public void save(User user, Activity activity) {                
        if (ActivityValidator.isValid(activity)) new ActivityDAO().add(user,activity);
    } 
    
    public Optional<Activity> findById(long id){
        return new ActivityDAO().find(id);
    }  
    
    public void update(User user, Activity activity){
        if (ActivityValidator.isValidEdit(activity))new ActivityDAO().update(user,activity);
    }
    
    public void delete(User user, Activity activity){
        if(activity.getId()!= null)new ActivityDAO().delete(user,activity);
    }
    
    public Activity convertOptionalToActivity(Optional<Activity> optionalActivity){
        return (optionalActivity.isPresent()) ?  optionalActivity.get() : null;            
    }
    
    public List<Activity> findByMonth(User user,Short month){
           return  new ActivityDAO().listByMonth(user,month);
    }
}
