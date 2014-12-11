package com.ilegra.jt.lancamentodehoras.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.Duration;
import java.util.Objects;

public class Activity {

    private Long id;
    private User user;
    private LocalDateTime startHour;
    private LocalDateTime finishHour;
    private Project project;
    private SubProject subProject;
    private String description;
    private Group group;
    private ActivityType activityType;
    public static DateTimeFormatter formatDate = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    public static DateTimeFormatter formatTime = DateTimeFormatter.ofPattern("HH:mm");

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 19 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        
        if (getClass() != obj.getClass())return false;
        
        final Activity other = (Activity) obj;
        
        if (!Objects.equals(this.id, other.id)) return false;
        
        if (!Objects.equals(this.user, other.user)) return false;
        
        if (!Objects.equals(this.startHour, other.startHour)) return false;
        
        if (!Objects.equals(this.finishHour, other.finishHour)) return false;
       
        if (!Objects.equals(this.project, other.project)) return false;

        if (!Objects.equals(this.subProject, other.subProject)) return false;
        
        if (!Objects.equals(this.description, other.description)) return false;
        
        if (!Objects.equals(this.group, other.group)) return false;
        
        if (!Objects.equals(this.activityType, other.activityType)) return false;

        return true;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getStartHour() {
        return startHour;
    }

    public void setStartHour(LocalDateTime startHour) {
        this.startHour = startHour;
    }

    public LocalDateTime getFinishHour() {
        return finishHour;
    }

    public void setFinishHour(LocalDateTime finishHour) {
        this.finishHour = finishHour;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public SubProject getSubProject() {
        return subProject;
    }

    public void setSubProject(SubProject subProject) {
        this.subProject = subProject;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public ActivityType getActivityType() {
        return activityType;
    }

    public void setActivityType(ActivityType activityType) {
        this.activityType = activityType;
    }

    public String getDateFormatedPTbr() {
        return this.getStartHour().format(formatDate);
    }

    public String getStartHourFormated() {
        return this.getStartHour().format(formatTime);
    }

    public String getEndHourFormated() {
        return this.getFinishHour().format(formatTime);
    }

    public String getWorkedHoursFormated() {

        Duration intervalo = this.getWorkedHours();
        long hour = intervalo.toHours();
        long minutes = intervalo.toMinutes() - (hour * 60);
        
        return String.format("%d:%d", hour, minutes);
    }
    
    public Duration getWorkedHours(){
        return Duration.between(this.startHour, this.finishHour);
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Activity{" + "id=" + id + ", user=" + user + ", startHour=" + startHour + ", finishHour=" + finishHour + ", project=" + project + ", subProject=" + subProject + ", description=" + description + ", group=" + group + ", activityType=" + activityType + '}';
    } 
}
