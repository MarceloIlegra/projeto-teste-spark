package com.ilegra.jt.lancamentodehoras.repository;


import com.ilegra.jt.lancamentodehoras.model.Project;
import com.ilegra.jt.lancamentodehoras.model.User;
import java.util.List;

public interface ProjectRepository {
    
    public List<Project> listByUser(User user);
    
}
