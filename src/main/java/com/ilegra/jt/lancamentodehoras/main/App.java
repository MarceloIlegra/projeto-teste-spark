package com.ilegra.jt.lancamentodehoras.main;


import com.ilegra.jt.lancamentodehoras.config.Routes;
import com.ilegra.jt.lancamentodehoras.model.User;
import java.util.ArrayList;
import static spark.Spark.*;

public class App {
    
    public static ArrayList<User> users = new ArrayList<User>();
    
    public static void main( String[] args ){     
        
        users.add(new User("marcelo", "123"));
        users.add(new User("admin", "123"));
                
        staticFileLocation("/public");
       
        Routes routes = new Routes();
        routes.init();
        
    }
}
