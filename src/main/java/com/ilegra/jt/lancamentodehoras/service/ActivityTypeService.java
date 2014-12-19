package com.ilegra.jt.lancamentodehoras.service;

import com.ilegra.jt.lancamentodehoras.dao.ActivityTypeDAO;
import com.ilegra.jt.lancamentodehoras.pojo.ActivityType;

public class ActivityTypeService {
    
    public static ActivityType getById(Integer id) {
        return new ActivityTypeDAO().getById(id).get();
    }
    
}
