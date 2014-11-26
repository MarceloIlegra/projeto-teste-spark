package com.ilegra.jt.lancamentodehoras.model;

import java.util.ArrayList;
import java.util.List;

public class Project {

    public Project(Integer id, String description) {
        this.id = id;
        this.description = description;
    }
    
    private Integer id;
    private String description;
    private List<SubProject> subProjects = new ArrayList<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }    

    public List<SubProject> getSubProjects() {
        return subProjects;
    }

    public void setSubProjects(List<SubProject> subProjects) {
        this.subProjects = subProjects;
    }
    
    
    
}
