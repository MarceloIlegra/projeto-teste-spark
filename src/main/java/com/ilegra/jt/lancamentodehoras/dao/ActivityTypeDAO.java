package com.ilegra.jt.lancamentodehoras.dao;

import com.ilegra.jt.lancamentodehoras.model.ActivityType;
import com.ilegra.jt.lancamentodehoras.model.User;
import com.ilegra.jt.lancamentodehoras.repository.ActivityTypeRepository;
import java.util.List;
import java.util.Optional;

public class ActivityTypeDAO implements ActivityTypeRepository {
   
    @Override
    public List<ActivityType> listByActivity(User user, ActivityType activityType){
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public Optional<ActivityType> getById(int id){
        
        return Memory.activityType
                .stream().filter((activityType) -> id == activityType.getId())
                .findFirst();
    }
    
    @Override
    public List<ActivityType> listAll(){
        return Memory.activityType;
    }
}
