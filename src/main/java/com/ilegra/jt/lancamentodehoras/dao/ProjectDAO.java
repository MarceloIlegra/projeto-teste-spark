package com.ilegra.jt.lancamentodehoras.dao;

import com.ilegra.jt.lancamentodehoras.exceptions.ProjectNotFoundException;
import com.ilegra.jt.lancamentodehoras.model.Project;
import com.ilegra.jt.lancamentodehoras.model.User;
import com.ilegra.jt.lancamentodehoras.repository.ProjectRepository;
import java.util.List;


public class ProjectDAO implements ProjectRepository{

    @Override
    public List<Project> listByUser(User user) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public Project getById(int id) throws ProjectNotFoundException{
        
        Project project = null;
        
        try{
            project = Memory.projects.get(id);
        }catch(java.lang.IndexOutOfBoundsException exceptionMessage){
            throw new ProjectNotFoundException();
        }
        
        return project;
        
    }
    
    
    @Override
    public List<Project> listAll(){
        return Memory.projects;
    }
    
}
