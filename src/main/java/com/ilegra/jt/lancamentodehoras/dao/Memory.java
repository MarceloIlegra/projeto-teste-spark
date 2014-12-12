package com.ilegra.jt.lancamentodehoras.dao;

import com.ilegra.jt.lancamentodehoras.pojo.Activity;
import com.ilegra.jt.lancamentodehoras.pojo.Project;
import com.ilegra.jt.lancamentodehoras.pojo.SubProject;
import com.ilegra.jt.lancamentodehoras.pojo.User;
import com.ilegra.jt.lancamentodehoras.pojo.Group;
import com.ilegra.jt.lancamentodehoras.pojo.ActivityType;
import java.time.LocalDateTime;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class Memory {

    public static List<User> users = new ArrayList<>();
    public static List<Activity> activities = new ArrayList<>();
    public static List<Project> projects = new ArrayList<>();
    public static List<SubProject> subProjects = new ArrayList<>();
    public static List<Group> groups = new ArrayList<>();
    public static List<ActivityType> activityType = new ArrayList<>();
    public static Long currentActivityId = (long) 2;
    public static User userLogged;

    public static void start() {
        activities = new ArrayList<>();   
        loadUsers();
        loadProjects();
        loadSubProjects();
        loadGroups();
        loadGroups();
        loadActivityTypes();
        createActivitys();
    }

    private static void loadUsers() {        
        users = Arrays.asList(new User("marcelo", "123"),new User("paulo", "123"),new User("aline", "123"));
        userLogged = users.get(0);
    }
    private static void loadProjects(){
        projects=Arrays.asList(new Project(0, "Projeto teste 1"),new Project(1, "Projeto teste 2"),new Project(2, "Projeto teste 3"));       
    }
    private static void loadSubProjects(){
        subProjects=Arrays.asList(new SubProject(0, "SubProjeto teste 1"),new SubProject(1, "SubProjeto teste 2"),new SubProject(2, "SubProjeto teste 3"));       
    }
    private static void loadGroups(){
        groups=Arrays.asList(new Group(0, "Grupo teste 1"),new Group(1, "Grupo teste 2"),new Group(2, "Grupo teste 3"));
    }
    private static void loadActivityTypes(){
        activityType=Arrays.asList(new ActivityType(0, "Tipo teste 1"),new ActivityType(1, "Tipo teste 2"),new ActivityType(2, "Tipo teste 3"));        
    }
    private static void createActivitys(){
        Activity activity1 = new Activity();
        activity1.setId(new Long(0));
        activity1.setUser(users.get(0));
        activity1.setDescription("Atividade descricao 1");
        activity1.setProject(projects.get(0));
        activity1.setSubProject(subProjects.get(0));
        activity1.setGroup(groups.get(0));
        activity1.setActivityType(activityType.get(0));
        activity1.setStartHour(LocalDateTime.of(2014, 11, 28, 15, 43));
        activity1.setFinishHour(LocalDateTime.of(2014, 11, 28, 18, 38));
        activities.add(activity1);

        Activity activity2 = new Activity();
        activity2.setId(new Long(1));
        activity1.setUser(users.get(0));
        activity2.setDescription("Atividade descricao 1");
        activity2.setProject(projects.get(1));
        activity2.setSubProject(subProjects.get(1));
        activity2.setGroup(groups.get(1));
        activity2.setActivityType(activityType.get(1));
        activity2.setStartHour(LocalDateTime.of(2014, 11, 27, 15, 48));
        activity2.setFinishHour(LocalDateTime.of(2014, 11, 27, 18, 22));
        activities.add(activity2);

        Activity activity3 = new Activity();
        activity3.setId(new Long(2));
        activity1.setUser(users.get(0));
        activity3.setDescription("Atividade descricao 3");
        activity3.setProject(projects.get(2));
        activity3.setSubProject(subProjects.get(2));
        activity3.setGroup(groups.get(2));
        activity3.setActivityType(activityType.get(2));
        activity3.setStartHour(LocalDateTime.of(2014, 11, 21, 14, 30));
        activity3.setFinishHour(LocalDateTime.of(2014, 11, 21, 18, 30));
        activities.add(activity3);        
    }    
}
