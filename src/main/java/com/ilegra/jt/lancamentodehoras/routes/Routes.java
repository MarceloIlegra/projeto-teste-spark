package com.ilegra.jt.lancamentodehoras.routes;

import com.ilegra.jt.lancamentodehoras.dao.ActivityDAO;
import com.ilegra.jt.lancamentodehoras.dao.ActivityTypeDAO;
import com.ilegra.jt.lancamentodehoras.dao.ProjectDAO;
import com.ilegra.jt.lancamentodehoras.dao.SubProjectDAO;
import com.ilegra.jt.lancamentodehoras.dao.GroupDAO;
import com.ilegra.jt.lancamentodehoras.dao.UserDAO;
import com.ilegra.jt.lancamentodehoras.pojo.Activity;
import com.ilegra.jt.lancamentodehoras.pojo.User;
import com.ilegra.jt.lancamentodehoras.repository.ActivityRepository;
import com.ilegra.jt.lancamentodehoras.repository.ActivityTypeRepository;
import com.ilegra.jt.lancamentodehoras.repository.GroupRepository;
import com.ilegra.jt.lancamentodehoras.repository.ProjectRepository;
import com.ilegra.jt.lancamentodehoras.repository.SubProjectRepository;
import com.ilegra.jt.lancamentodehoras.service.ActivityService;
import com.ilegra.jt.lancamentodehoras.validators.RequestValidator;
import com.ilegra.jt.lancamentodehoras.viewtransformer.JsonTransformer;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import static spark.Spark.*;
import spark.ModelAndView;
import spark.template.mustache.MustacheTemplateEngine;

public class Routes {

    private final Map map = new HashMap();

    public void init() {

        ProjectRepository projectDAO = new ProjectDAO();
        SubProjectRepository subprojectDAO = new SubProjectDAO();
        GroupRepository groupDAO = new GroupDAO();
        ActivityTypeRepository activityTypeDAO = new ActivityTypeDAO();
        ActivityRepository activityDAO = new ActivityDAO();

        map.put("activities", activityDAO.listAll());
        map.put("activities_total_time", activityDAO.getTotalTimeFormated());
        map.put("projects", projectDAO.listAll());
        map.put("subProjects", subprojectDAO.listAll());
        map.put("groups", groupDAO.listAll());
        map.put("activityType", activityTypeDAO.listAll());

        get("/", (request, response) -> new ModelAndView(null, "login.mustache"), new MustacheTemplateEngine());

        get("/login", (request, response) -> new ModelAndView(null, "login.mustache"), new MustacheTemplateEngine());

        get("/logout", (request, response) -> {
            request.session().removeAttribute("login");
            response.redirect("/login");
            return null;
        });

        post("/login", (request, response) -> {
            String usuario = request.queryParams("usuario");
            String senha = request.queryParams("senha");
            UserDAO userDAO = new UserDAO();
            Optional<User> userLoged = userDAO.login(usuario, senha);
            userLoged.ifPresent((valor) -> {
                request.session().attribute("login", userLoged.get());
                response.redirect("/atividades");
            });
            response.redirect("/login");
            return null;
        });        
        
        before("/atividades", (request, response) -> {
            if (request.session().attribute("login") == null) {
                response.redirect("/login");
            }
        });

        get("/atividades", (request, response) -> new ModelAndView(map, "lancamentohoras.mustache"), new MustacheTemplateEngine());

        get("/atividades/:id", "application/json", (request, response)-> new ActivityService().findById(new Long(request.params(":id"))).get(), new JsonTransformer());        
        
        put("/atividades/:id", (request, response)->{
            return request.params("id");
        });
        
        post("/atividades/", (request, response) -> {
            if(RequestValidator.isIntervalFormatValid(request.queryParams("data"), 
                    request.queryParams("horainicio"), 
                    request.queryParams("horafim"))){                
                new ActivityService().save(request.session().attribute("login"), 
                        new RequestMapping().mapRequestToActivity(request));
                response.redirect("/atividades");
            }
            return null;
        });              

    }

}
