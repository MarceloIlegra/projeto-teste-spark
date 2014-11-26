
package com.ilegra.jt.lancamentodehoras.config;

import com.ilegra.jt.lancamentodehoras.model.Activity;
import com.ilegra.jt.lancamentodehoras.model.Project;
import com.ilegra.jt.lancamentodehoras.model.SubProject;
import com.ilegra.jt.lancamentodehoras.model.User;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

public class Memory {

    public static ArrayList<User> users = new ArrayList<User>();
    public static List<Activity> activities = new ArrayList<Activity>();
    
    public static void start(){
        
        users.add(new User("marcelo", "123"));
        users.add(new User("admin", "123"));
        
        Project project = new Project();
        project.setId(0);
        project.setDescription("Projeto descricao");
        
        SubProject subProject = new SubProject();
        subProject.setId(0);
        subProject.setDescription("SubProjeto descrição");
        
        
        Activity activity = new Activity();
        activity.setId(0);
        activity.setDescription("Atividade descricao");
        activity.setProject(project);
        activity.setSubproject(subProject);
        activity.setStartHour(LocalDateTime.of(2014, Month.JUNE, 12, 17, 0));
        activity.setFinishHour(LocalDateTime.of(2014, Month.JUNE, 12, 18, 0));
        activities.add(activity);
        
        Activity activity2 = new Activity();
        activity2.setId(0);
        activity2.setDescription("Atividade descricao 2");
        activity2.setProject(project);
        activity2.setSubproject(subProject);
        activity2.setStartHour(LocalDateTime.of(2014, Month.JUNE, 13, 9, 0));
        activity2.setFinishHour(LocalDateTime.of(2014, Month.JUNE, 13, 11, 0));        
        activities.add(activity2);
        
    }
    

    
}
