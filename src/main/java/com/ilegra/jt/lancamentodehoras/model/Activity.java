package com.ilegra.jt.lancamentodehoras.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.Duration;

public class Activity {

    private Integer id;
    private LocalDateTime startHour;
    private LocalDateTime finishHour;
    private Project project;
    private SubProject subProject;
    private String description;
    private Group group;
    private ActivityType activityType;
    public static DateTimeFormatter formatDate = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    public static DateTimeFormatter formatTime = DateTimeFormatter.ofPattern("HH:mm");

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public String getWorkedHours() {

        Duration intervalo = Duration.between(this.startHour, this.finishHour);

        return String.format("%d:%d", intervalo.toHours(), intervalo.toMinutes() - (intervalo.toHours() * 60));

    }

}
