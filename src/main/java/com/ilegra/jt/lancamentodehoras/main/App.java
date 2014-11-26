package com.ilegra.jt.lancamentodehoras.main;


import com.ilegra.jt.lancamentodehoras.config.Routes;
import com.ilegra.jt.lancamentodehoras.model.User;
import java.util.ArrayList;
import static spark.Spark.*;

public class App {   
    
    public static void main( String[] args ){            
                
        staticFileLocation("/public");
       
        Routes routes = new Routes();
        routes.init();
        
    }
}
