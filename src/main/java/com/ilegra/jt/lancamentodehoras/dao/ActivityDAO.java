package com.ilegra.jt.lancamentodehoras.dao;

import com.ilegra.jt.lancamentodehoras.pojo.Activity;
import com.ilegra.jt.lancamentodehoras.pojo.Project;
import com.ilegra.jt.lancamentodehoras.pojo.User;
import com.ilegra.jt.lancamentodehoras.repository.ActivityRepository;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

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
    public void delete(User user,Project project, Activity activity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(User user,Project project, Activity activity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Activity> listByMonth(User user,Project project, Short month) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Activity> listAll() {
        return Memory.activities;
    }
    
    @Override
    public long getTotalTimeInMinutes(){
        return Memory.activities
                .stream()
                .mapToLong((activity)->activity.getWorkedHours().toMinutes())
                .sum();        
    }
    
    @Override
    public String getTotalTimeFormated(){
        long minutes = this.getTotalTimeInMinutes();
        long hours = (long)Math.floor(minutes/60);
        long min = minutes % 60;        
       
        return String.format("%d:%d", hours, min);
    }  
}
