package com.ilegra.jt.lancamentodehoras.service;

import com.ilegra.jt.lancamentodehoras.dao.ActivityTypeDAO;
import com.ilegra.jt.lancamentodehoras.pojo.ActivityType;
import java.util.Optional;

public class ActivityTypeService {
    
    public static Optional<ActivityType> getById(Integer id) {
        return new ActivityTypeDAO().getById(id);
    }
    
}
