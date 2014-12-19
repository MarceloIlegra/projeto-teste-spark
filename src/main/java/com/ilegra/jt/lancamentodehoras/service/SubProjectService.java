package com.ilegra.jt.lancamentodehoras.service;

import com.ilegra.jt.lancamentodehoras.dao.SubProjectDAO;
import com.ilegra.jt.lancamentodehoras.pojo.SubProject;

public class SubProjectService {
    
    public static SubProject getById(Integer id) {
        return new SubProjectDAO().getById(id).get();
    }
    
}
