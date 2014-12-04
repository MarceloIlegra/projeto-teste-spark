package com.ilegra.jt.lancamentodehoras.routes;

import com.ilegra.jt.lancamentodehoras.dao.ActivityDAO;
import com.ilegra.jt.lancamentodehoras.dao.ActivityTypeDAO;
import com.ilegra.jt.lancamentodehoras.dao.ProjectDAO;
import com.ilegra.jt.lancamentodehoras.dao.SubProjectDAO;
import com.ilegra.jt.lancamentodehoras.dao.GroupDAO;
import com.ilegra.jt.lancamentodehoras.dao.UserDAO;
import com.ilegra.jt.lancamentodehoras.model.User;
import com.ilegra.jt.lancamentodehoras.repository.ActivityRepository;
import com.ilegra.jt.lancamentodehoras.repository.ActivityTypeRepository;
import com.ilegra.jt.lancamentodehoras.repository.GroupRepository;
import com.ilegra.jt.lancamentodehoras.repository.ProjectRepository;
import com.ilegra.jt.lancamentodehoras.repository.SubProjectRepository;
import com.ilegra.jt.lancamentodehoras.service.ActivityService;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import static spark.Spark.*;
import spark.ModelAndView;
import spark.template.mustache.MustacheTemplateEngine;

public class Routes {

    public void init() {
        
        ProjectRepository projectDAO = new ProjectDAO();
        SubProjectRepository subprojectDAO = new SubProjectDAO();
        GroupRepository groupDAO = new GroupDAO();
        ActivityTypeRepository activityTypeDAO = new ActivityTypeDAO();        
        ActivityRepository activityDAO = new ActivityDAO();
        
        
        
        
        Map map = new HashMap();
        map.put("activities", activityDAO.listAll());
        map.put("projects", projectDAO.listAll());
        map.put("subProjects", subprojectDAO.listAll());
        map.put("groups", groupDAO.listAll());
        map.put("activityType", activityTypeDAO.listAll());
        
        get("/", (request, response) -> new ModelAndView(null, "login.mustache"), new MustacheTemplateEngine() );

        get("/login", (request, response) -> new ModelAndView(null, "login.mustache"), new MustacheTemplateEngine());

        get("/lancamentohoras", (request, response) -> new ModelAndView(map, "listagem.mustache"), new MustacheTemplateEngine());

        post("lancamentohoras/salvar", (request, response) -> {
            ActivityService activityService = new ActivityService();
            activityService.save(request);

            response.redirect("/lancamentohoras");
            
            return "OK";
        });

        post("/login", (request, response) -> {

            String usuario = request.queryParams("usuario");
            String senha = request.queryParams("senha");

            UserDAO user = new UserDAO();
            Optional<User> logado = user.login(usuario, senha);

            logado.ifPresent((valor) -> response.redirect("/lancamentohoras"));
            response.redirect("/login");

            return "loginteste";

        });

    }
    
}
