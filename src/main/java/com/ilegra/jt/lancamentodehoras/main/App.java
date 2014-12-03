package com.ilegra.jt.lancamentodehoras.main;


import com.ilegra.jt.lancamentodehoras.dao.Memory;
import com.ilegra.jt.lancamentodehoras.routes.Routes;
import static spark.Spark.*;

public class App {   
    
    public static void main( String[] args ){            
                
        staticFileLocation("/public");
       
        Memory.start();
        
        Routes routes = new Routes();
        routes.init();
        
    }
}
