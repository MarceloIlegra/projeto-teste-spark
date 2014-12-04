package com.ilegra.jt.lancamentodehoras.dao;

import org.junit.Test;
import static org.junit.Assert.*;

public class ActivityDAOTest {

    @Test
    public void listaNaoPodeSerNula() {

        ActivityDAO dao = new ActivityDAO();
        assertNotNull(dao.listAll());

    }
}
