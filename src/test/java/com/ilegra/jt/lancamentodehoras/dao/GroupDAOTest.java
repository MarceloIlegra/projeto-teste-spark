package com.ilegra.jt.lancamentodehoras.dao;

import com.ilegra.jt.lancamentodehoras.exceptions.GroupNotFoundException;
import com.ilegra.jt.lancamentodehoras.model.Group;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

public class GroupDAOTest {

    private GroupDAO groupDAO;

    @Before
    public void setUp() {
        groupDAO = new GroupDAO();
        Memory.start();
    }

    @Test
    public void pegarOGrupoCorretamente() throws GroupNotFoundException {

        Group expected = Memory.groups.get(0);
        Group actual = this.groupDAO.getById(0);

        assertEquals(expected, actual);

    }

    @Test(expected = GroupNotFoundException.class)
    public void tentarPegarProjetoComIdInvalido() throws GroupNotFoundException {

        int invalidId = 9999;
        this.groupDAO.getById(invalidId);

    }

}
