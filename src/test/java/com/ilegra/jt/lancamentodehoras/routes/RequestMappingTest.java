
package com.ilegra.jt.lancamentodehoras.routes;

import com.ilegra.jt.lancamentodehoras.dao.ActivityTypeDAO;
import com.ilegra.jt.lancamentodehoras.dao.GroupDAO;
import com.ilegra.jt.lancamentodehoras.dao.Memory;
import com.ilegra.jt.lancamentodehoras.dao.ProjectDAO;
import com.ilegra.jt.lancamentodehoras.dao.SubProjectDAO;
import com.ilegra.jt.lancamentodehoras.model.Activity;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.HashMap;
import java.util.Map;
import org.junit.Test;
import spark.Request;
import static org.junit.Assert.*;
import org.junit.Before;

public class RequestMappingTest {
    
    @Before
    public void setup(){
        Memory.start();
    }
    
    @Test
    public void mappingTest(){           
        assertEquals(activityFake(), new RequestMapping().mapRequestToActivity(new MyRequest(requestFakeParams())));        
    }

    private Activity activityFake() {
        Activity expected = new Activity();
        expected.setStartHour(LocalDateTime.of(2014, Month.DECEMBER, 20, 12, 0));
        expected.setFinishHour(LocalDateTime.of(2014, Month.DECEMBER, 20, 16, 0));
        expected.setProject(new ProjectDAO().getById(1).get());
        expected.setSubProject(new SubProjectDAO().getById(1).get());
        expected.setGroup(new GroupDAO().getById(1).get());                
        expected.setActivityType(new ActivityTypeDAO().getById(1).get());
        expected.setDescription("TESTE");
        return expected;        
    }

    private Map<String, String> requestFakeParams() {
        Map<String,String> params = new HashMap<String,String>();
        params.put("data", "20/12/2014");
        params.put("horainicio","12:00");
        params.put("horafim", "16:00");
        params.put("projeto","1");
        params.put("subprojeto","1");
        params.put("grupo","1");
        params.put("tipo_atividade","1");
        params.put("descricao","TESTE");
        return params;
    }        
    
}
