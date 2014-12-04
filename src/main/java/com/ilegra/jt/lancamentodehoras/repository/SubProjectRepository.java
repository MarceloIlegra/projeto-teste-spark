package com.ilegra.jt.lancamentodehoras.repository;

import com.ilegra.jt.lancamentodehoras.model.SubProject;
import com.ilegra.jt.lancamentodehoras.model.User;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author Rafael Souza
 */
public interface SubProjectRepository {
    
    public List<SubProject> listBySubProject(User user, SubProject subproject);
    
    public List<SubProject> listAll();
    
    public Optional<SubProject> getById(int id);
    
}
