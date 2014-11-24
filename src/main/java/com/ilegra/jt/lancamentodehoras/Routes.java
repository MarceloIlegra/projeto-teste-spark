package com.ilegra.jt.lancamentodehoras;


import static spark.Spark.*;
import spark.ModelAndView;
import spark.template.mustache.MustacheTemplateEngine;

public class Routes {
    
    public static void main( String[] args ){     
        
        
        // hello.mustache file is in resources/templates directory
        get("/login", (rq, rs) -> new ModelAndView(null, "login.mustache"), new MustacheTemplateEngine());
        
        get("/lancamentohoras", (rq, rs) -> new ModelAndView(null, "listagem.mustache"), new MustacheTemplateEngine());
        
        post("/login", (request, response) -> {
            
            String usuario = request.queryParams("usuario");
            String senha = request.queryParams("senha");
            
            response.redirect("/lancamentohoras");
            return String.format("Login: %s <br />Senha: %s", usuario, senha);
        });
        
        
        /**
	get("/novo", (request, response) -> "Tela de Login");
        
        get("/listagem", (request, response) -> "Tela de Login");
        */
    }
}
