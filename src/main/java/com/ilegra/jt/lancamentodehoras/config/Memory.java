package com.ilegra.jt.lancamentodehoras.config;

import com.ilegra.jt.lancamentodehoras.model.Activity;
import com.ilegra.jt.lancamentodehoras.model.Project;
import com.ilegra.jt.lancamentodehoras.model.SubProject;
import com.ilegra.jt.lancamentodehoras.model.User;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.List;
import java.util.ArrayList;

public class Memory {

    public static List<User> users = new ArrayList<>();
    public static List<Activity> activities = new ArrayList<>();
    public static List<Project> projects = new ArrayList<>();
    public static List<SubProject> subProjects = new ArrayList<>();

    public static void start() {

        users.add(new User("marcelo", "123"));
        users.add(new User("admin", "123"));

        Project project1 = new Project(0, "Projeto teste 1");
        projects.add(project1);

        Project project2 = new Project(1, "Projeto teste 2");
        projects.add(project2);

        Project project3 = new Project(2, "Projeto teste 3");
        projects.add(project2);

        SubProject subProject1 = new SubProject(0, "SubProjeto teste 1");
        subProjects.add(subProject1);

        SubProject subProject2 = new SubProject(1, "SubProjeto teste 2");
        subProjects.add(subProject2);

        SubProject subProject3 = new SubProject(2, "SubProjeto teste 3");
        subProjects.add(subProject3);

        Activity activity = new Activity();
        activity.setId(0);
        activity.setDescription("Atividade descricao 1");
        activity.setProject(project1);
        activity.setSubproject(subProject1);
        activity.setStartHour(LocalDateTime.of(2014, Month.JUNE, 12, 17, 0));
        activity.setFinishHour(LocalDateTime.of(2014, Month.JUNE, 12, 18, 0));
        activities.add(activity1);

        Activity activity2 = new Activity();
        activity2.setId(1);
        activity2.setDescription("Atividade descricao 2");
        activity2.setProject(project2);
        activity2.setSubproject(subProject2);
        activity2.setStartHour(LocalDateTime.of(2014, Month.JUNE, 13, 9, 0));
        activity2.setFinishHour(LocalDateTime.of(2014, Month.JUNE, 13, 11, 0));
        activities.add(activity2);

        Activity activity3 = new Activity();
        activity2.setId(2);
        activity2.setDescription("Atividade descricao 3");
        activity2.setProject(project3);
        activity2.setSubproject(subProject3);
        activity2.setStartHour(LocalDateTime.of(2014, Month.JUNE, 13, 9, 0));
        activity2.setFinishHour(LocalDateTime.of(2014, Month.JUNE, 13, 11, 0));
        activities.add(activity3);

    }

}
