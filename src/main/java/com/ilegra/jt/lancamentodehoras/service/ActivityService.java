package com.ilegra.jt.lancamentodehoras.service;

import com.ilegra.jt.lancamentodehoras.dao.ActivityDAO;
import com.ilegra.jt.lancamentodehoras.pojo.Activity;
import com.ilegra.jt.lancamentodehoras.pojo.ActivityType;
import com.ilegra.jt.lancamentodehoras.pojo.Group;
import com.ilegra.jt.lancamentodehoras.pojo.Project;
import com.ilegra.jt.lancamentodehoras.pojo.SubProject;
import com.ilegra.jt.lancamentodehoras.pojo.User;
import com.ilegra.jt.lancamentodehoras.validators.ActivityValidator;
import java.util.List;
import java.util.Optional;

public class ActivityService {
    
    public void save(Activity activity) {                
        if (ActivityValidator.isValid(activity)) new ActivityDAO().add(activity);
    } 
    
    public Optional<Activity> findById(long id){
        return new ActivityDAO().find(id);
    }  
    
    public void update(Activity activity){
        if (ActivityValidator.isValidEdit(activity))new ActivityDAO().update(activity);
    }
    
    public void delete(Activity activity){
        if(activity.getId()!= null)new ActivityDAO().delete(activity);
    }
    
    public List<Activity> findByMonth(User user ,Short month){
           return  new ActivityDAO().listByMonth(user,month);
    }
    
    public List<Activity> search(Project project ,SubProject subProject ,Group group ,ActivityType activityType,String descricao){
        return new ActivityDAO().search(project,subProject,group,activityType,descricao);
    }
}
