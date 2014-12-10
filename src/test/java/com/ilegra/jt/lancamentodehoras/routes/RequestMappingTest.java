/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ilegra.jt.lancamentodehoras.routes;

import com.ilegra.jt.lancamentodehoras.model.Activity;
import java.util.HashMap;
import java.util.Map;
import org.junit.Test;
import spark.Request;
import static org.junit.Assert.*;

public class RequestMappingTest {
    
    @Test  
    public void simpleTest(){
        Request request = new MyRequest();
        Activity expected = new Activity();
        Activity actual= new RequestMapping().mapRequestToActivity(request);
        assertEquals(expected, actual);
    }
    @Test
    public void mappingTest(){        
        Map<String,String> params = new HashMap<String,String>();
        params.put("data", "20/12/2014");
        params.put("horainicio","12:00");
        params.put("horafim", "16:00");
        params.put("projeto","Projeto 1");
        params.put("subprojeto","SubProjeto 1");
        params.put("grupo","Grupo 1");
        params.put("tipo_atividade","Atividade 1");
        params.put("descricao","TESTE");
        Activity expected = new Activity();
        Request request = new MyRequest(params);
        Activity actual= new RequestMapping().mapRequestToActivity(request);
        expected.setDescription("TESTE");
        assertEquals(expected.getDescription(),actual.getDescription());
        
        
        
        
        
    }
    
    
    
}
