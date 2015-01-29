package com.ilegra.jt.lancamentodehoras.service;

import com.ilegra.jt.lancamentodehoras.dao.ProjectDAO;
import com.ilegra.jt.lancamentodehoras.pojo.Project;
import java.util.Optional;

public class ProjectService {

    public static Optional<Project> getById(Integer id) {
        return new ProjectDAO().getById(id);
    }
}
