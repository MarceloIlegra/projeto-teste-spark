package com.ilegra.jt.lancamentodehoras.config;


import com.ilegra.jt.lancamentodehoras.dao.UserDAO;
import com.ilegra.jt.lancamentodehoras.model.User;
import java.util.Optional;
import static spark.Spark.*;
import spark.ModelAndView;
import spark.template.mustache.MustacheTemplateEngine;

public class Routes {
    
    public void init(){
    
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
