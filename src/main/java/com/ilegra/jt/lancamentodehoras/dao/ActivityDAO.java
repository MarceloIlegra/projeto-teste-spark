package com.ilegra.jt.lancamentodehoras.dao;

import com.ilegra.jt.lancamentodehoras.pojo.Activity;
import com.ilegra.jt.lancamentodehoras.pojo.ActivityType;
import com.ilegra.jt.lancamentodehoras.pojo.Group;
import com.ilegra.jt.lancamentodehoras.pojo.Project;
import com.ilegra.jt.lancamentodehoras.pojo.SubProject;
import com.ilegra.jt.lancamentodehoras.pojo.User;
import com.ilegra.jt.lancamentodehoras.repository.ActivityRepository;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

public class ActivityDAO implements ActivityRepository {

    @Override
    public Long add(Activity activity) {
        Memory.currentActivityId++;
        activity.setId(Memory.currentActivityId);
        activity.setUser(activity.getUser());
        Memory.activities.add(activity);
        return activity.getId();
    }

    @Override
    public Optional<Activity> find(Long id) {
        return Memory.activities.stream()
                .filter((activity)->Objects.equals(activity.getId(), id))
                .findFirst();
    }  
    
    @Override
    public void delete(Activity activity) {
        for(Activity item : Memory.activities){
            if(activity.getId().equals(item.getId())){                
                Memory.activities.remove(item);
                break;
            }
        }
    }

    @Override
    public void update(Activity activity) {
        int index =0;
        for(Activity item : Memory.activities){
            if(activity.getId().equals(item.getId())){                
                Memory.activities.set(index, activity);
                break;
            }
            index++;
        }        
    }

    @Override
    public List<Activity> listByMonth(User user,Short month) {
        return Memory.activities
                .stream()
                .filter((activity)->(activity.getStartHour().getMonth().getValue()== month))
                .collect(Collectors.toList());
    }

    @Override
    public List<Activity> listAll() {
        return Memory.activities;
    }
    
    public List<Activity> search(Project project,SubProject subProject,Group group,ActivityType activityType,String descricao){
        return Memory.activities
                .stream()
                .filter((activity) ->(activity.getProject().equals(project) ||
                        (activity.getSubProject().equals(subProject)||
                        (activity.getGroup().equals(group)) ||
                        (activity.getActivityType().equals(activityType))||
                        (activity.getDescription().toLowerCase().contains(descricao.toLowerCase())))))
                .collect(Collectors.toList());
    }
}
