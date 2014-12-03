package com.ilegra.jt.lancamentodehoras.dao;

import com.ilegra.jt.lancamentodehoras.model.Group;
import com.ilegra.jt.lancamentodehoras.model.User;
import com.ilegra.jt.lancamentodehoras.model.Project;
import com.ilegra.jt.lancamentodehoras.model.SubProject;
import com.ilegra.jt.lancamentodehoras.repository.GroupRepository;
import java.util.List;

public class GroupDAO implements GroupRepository{
    
    @Override
     public List<Group> listByUserAndProjectAndSubProject(User user, Project project, SubProject subProject){
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

      public List<Group> listAll(){
        return Memory.groups;
    }

}