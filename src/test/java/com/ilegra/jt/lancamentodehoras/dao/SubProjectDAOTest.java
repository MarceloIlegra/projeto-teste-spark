
package com.ilegra.jt.lancamentodehoras.dao;

import com.ilegra.jt.lancamentodehoras.exceptions.SubProjectNotFoundException;
import com.ilegra.jt.lancamentodehoras.model.SubProject;
import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;


public class SubProjectDAOTest {
    
    private SubProjectDAO subProjectDAO;
    
    @Before
    public void setUp(){
        subProjectDAO = new SubProjectDAO();
        Memory.start();
    }
        
    @Test
    public void listaVaziaNaoPodeSerNull(){
        assertNotNull(this.subProjectDAO.listAll());
    }
    
    @Test
    public void pegarSubProjectCorretamente() throws SubProjectNotFoundException{
        
        SubProject expected = Memory.subProjects.get(0);
        SubProject actual = this.subProjectDAO.getById(0);
        
        assertEquals(expected, actual);
        
    }
    
    @Test(expected = SubProjectNotFoundException.class)
    public void tentarPegarSubProjetoComIdInvalido() throws SubProjectNotFoundException{
        this.subProjectDAO.getById(9999);
    }
    
    
}
