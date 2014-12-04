package com.ilegra.jt.lancamentodehoras.repository;


import com.ilegra.jt.lancamentodehoras.model.Project;
import com.ilegra.jt.lancamentodehoras.model.User;
import java.util.List;
import java.util.Optional;

public interface ProjectRepository {
    
    public List<Project> listByUser(User user);
    
    public List<Project> listAll();
    
    public Optional<Project> getById(int id);    
    
}
