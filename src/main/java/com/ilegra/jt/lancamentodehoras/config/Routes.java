package com.ilegra.jt.lancamentodehoras.config;


import com.ilegra.jt.lancamentodehoras.dao.ActivityDAO;
import com.ilegra.jt.lancamentodehoras.dao.ProjectDAO;
import com.ilegra.jt.lancamentodehoras.dao.UserDAO;
import com.ilegra.jt.lancamentodehoras.model.User;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import static spark.Spark.*;
import spark.ModelAndView;
import spark.template.mustache.MustacheTemplateEngine;

public class Routes {
    
    public void init(){
    
        
        ProjectDAO projectDAO = new ProjectDAO();
        
        
        Map map = new HashMap();
        map.put("activities", Memory.activities);
        map.put("projects", projectDAO.listAll());
        
        get("/", (request, response) -> new ModelAndView(null, "login.mustache"), new MustacheTemplateEngine() );
        
        get("/login", (request, response) -> new ModelAndView(null, "login.mustache"), new MustacheTemplateEngine());
        
        get("/lancamentohoras", (request, response) -> new ModelAndView(map, "listagem.mustache"), new MustacheTemplateEngine());
        
        post("lancamentohoras/salvar" ,(request , response) ->{
            
             String startHour = request.queryParams("horaInicio");
             String finishHour = request.queryParams("horaFim");
             String project = request.queryParams("projeto");
             String subProject = request.queryParams("subprojeto");
             String group = request.queryParams("grupo");
             String activityType = request.queryParams("tipoAtividade");
             String description = request.queryParams("descricao");
             
             ActivityDAO activity = new ActivityDAO();
             
             
             
             
             return startHour; 
            
        });        
        
        post("/login", (request, response) -> {
            
            String usuario = request.queryParams("usuario");
            String senha = request.queryParams("senha");
            
            UserDAO user = new UserDAO();
            Optional<User> logado = user.login(usuario, senha);
            
            logado.ifPresent((valor)->response.redirect("/lancamentohoras"));
            response.redirect("/login");
            
            return "loginteste";
            
        });  
        
    }
    
}
