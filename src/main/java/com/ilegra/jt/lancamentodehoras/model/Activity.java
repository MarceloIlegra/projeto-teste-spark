package com.ilegra.jt.lancamentodehoras.model;

import java.time.LocalDateTime;

public class Activity {

    private Integer id;
    private LocalDateTime startHour;
    private LocalDateTime finishHour;
    private Project project;
    private SubProject subProject;
    private String description;
    private Group group;

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

}
