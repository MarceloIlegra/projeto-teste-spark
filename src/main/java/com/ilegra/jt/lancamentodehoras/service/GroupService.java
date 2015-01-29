package com.ilegra.jt.lancamentodehoras.service;

import com.ilegra.jt.lancamentodehoras.dao.GroupDAO;
import com.ilegra.jt.lancamentodehoras.pojo.Group;
import java.util.Optional;

public class GroupService {
    
    public static Optional<Group> getById(Integer id) {
        return new GroupDAO().getById(id);
    }    
}
