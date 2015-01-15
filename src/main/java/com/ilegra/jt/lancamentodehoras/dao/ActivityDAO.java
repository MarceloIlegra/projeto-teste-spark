package com.ilegra.jt.lancamentodehoras.dao;

import com.ilegra.jt.lancamentodehoras.pojo.Activity;
import com.ilegra.jt.lancamentodehoras.pojo.User;
import com.ilegra.jt.lancamentodehoras.repository.ActivityRepository;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

public class ActivityDAO implements ActivityRepository {

    @Override
    public Long add(User user, Activity activity) {
        Memory.currentActivityId++;
        activity.setId(Memory.currentActivityId);
        activity.setUser(user);
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
    public void delete(User user,Activity activity) {
        for(Activity item : Memory.activities){
            if(activity.getId().equals(item.getId())){                
                Memory.activities.remove(item);
                break;
            }
        }
    }

    @Override
    public void update(User user,Activity activity) {
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
}
