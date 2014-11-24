package com.ilegra.jt.lancamentodehoras.main;


import com.ilegra.jt.lancamentodehoras.controller.UserController;
import com.ilegra.jt.lancamentodehoras.dao.UserDAO;
import com.ilegra.jt.lancamentodehoras.model.User;
import java.util.ArrayList;
import java.util.Optional;
import static spark.Spark.*;
import spark.ModelAndView;
import spark.template.mustache.MustacheTemplateEngine;

public class App {
    
    public static ArrayList<User> users = new ArrayList<User>();
    
    public static void main( String[] args ){     
        
        users.add(new User("marcelo", "123"));
        users.add(new User("admin", "123"));
                
        staticFileLocation("/public");
        
        get("/", (request, response) -> new ModelAndView(null, "principal.mustache"), new MustacheTemplateEngine() );
        
        get("/login", (request, response) -> new ModelAndView(null, "login.mustache"), new MustacheTemplateEngine());
        
        get("/lancamentohoras", (request, response) -> new ModelAndView(null, "listagem.mustache"), new MustacheTemplateEngine());
        
        post("/login", (request, response) -> {
            
            String usuario = request.queryParams("usuario");
            String senha = request.queryParams("senha");
            
            UserDAO dao = new UserDAO();
            Optional<User> logado = dao.login(usuario, senha);
            
            logado.ifPresent((valor)->response.redirect("/lancamentohoras"));
            response.redirect("/login");
            
            return "loginteste";
            
        });
        

    }
}
