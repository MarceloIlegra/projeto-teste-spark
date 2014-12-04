package com.ilegra.jt.lancamentodehoras.dao;

import com.ilegra.jt.lancamentodehoras.exceptions.SubProjectNotFoundException;
import com.ilegra.jt.lancamentodehoras.model.Project;
import com.ilegra.jt.lancamentodehoras.model.SubProject;
import com.ilegra.jt.lancamentodehoras.model.User;
import com.ilegra.jt.lancamentodehoras.repository.SubProjectRepository;
import java.util.ArrayList;
import java.util.List;

public class SubProjectDAO implements SubProjectRepository {

    @Override
    public List<SubProject> listByUserAndProject(User user, Project project) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public SubProject getById(int id) throws SubProjectNotFoundException{
      
        SubProject subProject = null;
        
        try{
            subProject = Memory.subProjects.get(id);
        }catch(java.lang.IndexOutOfBoundsException exceptionMessage){
            throw new SubProjectNotFoundException();
        }
        
        return subProject;
    }

    @Override
    public List<SubProject> listAll(){
                                
        return Memory.subProjects == null 
                ? new ArrayList<SubProject>() 
                : Memory.subProjects;       
    }

}
