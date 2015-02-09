package com.ilegra.jt.lancamentodehoras.routes;

import com.ilegra.jt.lancamentodehoras.dao.ActivityDAO;
import com.ilegra.jt.lancamentodehoras.dao.ActivityTypeDAO;
import com.ilegra.jt.lancamentodehoras.dao.ProjectDAO;
import com.ilegra.jt.lancamentodehoras.dao.SubProjectDAO;
import com.ilegra.jt.lancamentodehoras.dao.GroupDAO;
import com.ilegra.jt.lancamentodehoras.helpers.FormatHours;
import com.ilegra.jt.lancamentodehoras.pojo.User;
import com.ilegra.jt.lancamentodehoras.repository.ActivityRepository;
import com.ilegra.jt.lancamentodehoras.repository.ActivityTypeRepository;
import com.ilegra.jt.lancamentodehoras.repository.GroupRepository;
import com.ilegra.jt.lancamentodehoras.repository.ProjectRepository;
import com.ilegra.jt.lancamentodehoras.repository.SubProjectRepository;
import com.ilegra.jt.lancamentodehoras.service.UserService;
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
    private final ActivityService activityService = new ActivityService();
    private final RequestMapping requestMapping = new RequestMapping(); 
    private final MustacheTemplateEngine mustacheTemplateEngine = new MustacheTemplateEngine();
    
    public void init() {
        
        ProjectRepository projectDAO = new ProjectDAO();
        SubProjectRepository subprojectDAO = new SubProjectDAO();
        GroupRepository groupDAO = new GroupDAO();
        ActivityTypeRepository activityTypeDAO = new ActivityTypeDAO();
        ActivityRepository activityDAO = new ActivityDAO(); 
        FormatHours workHoursFormated = new FormatHours();

        map.put("activities", activityDAO.listAll());
        updateWorkedTime(workHoursFormated);
        map.put("projects", projectDAO.listAll());
        map.put("subProjects", subprojectDAO.listAll());
        map.put("groups", groupDAO.listAll());
        map.put("activityType", activityTypeDAO.listAll());

        get("/", (request, response) -> new ModelAndView(null, "login.mustache"),mustacheTemplateEngine);

        get("/login", (request, response) -> new ModelAndView(null, "login.mustache"),mustacheTemplateEngine);

        get("/logout", (request, response) -> {
            request.session().removeAttribute("login");
            response.redirect("/login");
            return null;
        });

        post("/login", (request, response) -> {
            Optional<User> userLoged = new UserService().authenticateUser(request.queryParams("usuario"), request.queryParams("senha"));
            userLoged.ifPresent((valor) -> {
                request.session().attribute("login", userLoged.get());
                response.redirect("/atividades");
            });
            response.redirect("/login");
            return null;
        });

        //Fazer before para todos
        before("/atividades", (request, response) -> {
            if (request.session().attribute("login") == null) {
                response.redirect("/login");                
            }            
        });

        get("/atividades", (request, response) -> 
                new ModelAndView(map, "lancamentohoras.mustache"),mustacheTemplateEngine);
        
        get("/atividades/filterByMonth",(request,respose)->
                activityService.findByMonth(request.session().attribute("login"),requestMapping.requestToShort(request)));
        
        get("/atividades/:id", "application/json", (request, response)-> 
                activityService.findById(new Long(request.params(":id"))).get(), new JsonTransformer());
        
        post("/atividades/search",(request,response)->
                activityService.search(requestMapping.requestToProject(request).get(),
                        requestMapping.requestToSubProject(request).get(),
                        requestMapping.requestToGroup(request).get(),
                        requestMapping.requestToActivityType(request).get(),
                        request.queryParams("descricao")));
       
        get("atividades/searchString",(request,response)->
               activityService.searchString(request.queryParams("descricao")));
      
        get("/atividades/_listagem", (request, response)-> new ModelAndView(map, "_listagem.mustache"), mustacheTemplateEngine);
        
        put("/atividades/:id", (request, response)-> { 
           if (RequestValidator.isIntervalFormatValid(request.queryParams("data"), request.queryParams("horainicio"), request.queryParams("horafim"))) {
                 activityService.update(requestMapping.mapRequestToActivity(request));
                 updateWorkedTime(workHoursFormated);
           }
           return "";
        });
        
        delete("/atividades/:id", (request,response) -> {
            activityService.findById(new Long(request.params(":id"))).map((activity)->{
                activityService.delete(activity);
                updateWorkedTime(workHoursFormated);
                return null;
            });
            return "";
        });
        
        post("/atividades", (request, response) -> {
            if(RequestValidator.isIntervalFormatValid(request.queryParams("data"),request.queryParams("horainicio"),request.queryParams("horafim"))){                
                activityService.save(requestMapping.mapRequestToActivity(request)); 
                updateWorkedTime(workHoursFormated);
            }
            return "";
        }); 
        
        post("/atividades/:id", (request, response) -> {
            if(RequestValidator.isIntervalFormatValid(request.queryParams("data"),request.queryParams("horainicio"),request.queryParams("horafim"))){                
                activityService.save(requestMapping.mapRequestToActivity(request)); 
                updateWorkedTime(workHoursFormated);
            }
            return "";
        }); 
    }

    private void updateWorkedTime(FormatHours workHoursFormated) {
        map.put("activities_total_time",workHoursFormated.getTotalTimeFormated());
    }
}
