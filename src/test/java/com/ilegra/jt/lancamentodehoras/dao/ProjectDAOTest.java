package com.ilegra.jt.lancamentodehoras.dao;

import com.ilegra.jt.lancamentodehoras.exceptions.ProjectNotFoundException;
import com.ilegra.jt.lancamentodehoras.model.Project;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class ProjectDAOTest {
    
    private ProjectDAO projectDAO;
    
    @Before
    public void setUp(){
        projectDAO = new ProjectDAO();
        Memory.start();
    }
    
    @Test
    public void pegarOProjetoCorretamente() throws ProjectNotFoundException{
        
        Project expected = Memory.projects.get(0);
        Project actual = this.projectDAO.getById(0);
        
        assertEquals(expected, actual);
        
    }
    
    @Test(expected = ProjectNotFoundException.class)
    public void tentarPegarProjetoComIdInvalido() throws ProjectNotFoundException{
        
        int invalidId = 9999;
        this.projectDAO.getById(invalidId);
        
    }
    
}
