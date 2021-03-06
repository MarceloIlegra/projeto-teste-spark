package com.ilegra.jt.lancamentodehoras.dao;

import com.ilegra.jt.lancamentodehoras.pojo.Project;
import com.ilegra.jt.lancamentodehoras.pojo.User;
import com.ilegra.jt.lancamentodehoras.repository.ProjectRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ProjectDAO implements ProjectRepository {

    @Override
    public List<Project> listByUser(User user) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.    
    }

    @Override
    public Optional<Project> getById(int id) {
        return Memory.projects
                .stream()
                .filter((project) -> id == project.getId())
                .findFirst();
    }

    @Override
    public List<Project> listAll() {
        return Memory.projects == null
                ? new ArrayList<>()
                : Memory.projects;
    }
}
