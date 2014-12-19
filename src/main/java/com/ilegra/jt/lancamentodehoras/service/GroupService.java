package com.ilegra.jt.lancamentodehoras.service;

import com.ilegra.jt.lancamentodehoras.dao.GroupDAO;
import com.ilegra.jt.lancamentodehoras.pojo.Group;

public class GroupService {
    
    public static Group getById(Integer id) {
        return new GroupDAO().getById(id).get();
    }    
}
