package com.ilegra.jt.lancamentodehoras.repository;

import com.ilegra.jt.lancamentodehoras.model.Project;
import com.ilegra.jt.lancamentodehoras.model.SubProject;
import com.ilegra.jt.lancamentodehoras.model.User;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author Rafael Souza
 */
public interface SubProjectRepository {
    
    public List<SubProject> listByUserAndProject(User user, Project project);
    
    public List<SubProject> listAll();
    
    public Optional<SubProject> getById(int id);
    
}
