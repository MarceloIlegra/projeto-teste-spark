package com.ilegra.jt.lancamentodehoras.service;

import com.ilegra.jt.lancamentodehoras.dao.ProjectDAO;
import com.ilegra.jt.lancamentodehoras.pojo.Project;

public class ProjectService {

    public static Project getById(Integer id) {
        return new ProjectDAO().getById(id).get();
    }
}
