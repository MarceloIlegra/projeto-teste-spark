package com.ilegra.jt.lancamentodehoras.service;

import com.ilegra.jt.lancamentodehoras.dao.SubProjectDAO;
import com.ilegra.jt.lancamentodehoras.pojo.SubProject;
import java.util.Optional;

public class SubProjectService {
    
    public static Optional<SubProject> getById(Integer id) {
        return new SubProjectDAO().getById(id);
    }
    
}
