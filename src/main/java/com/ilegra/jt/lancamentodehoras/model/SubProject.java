package com.ilegra.jt.lancamentodehoras.model;

public class SubProject {

    private Integer id;
    private String description;

    public Integer getId() {
        return id;
    }

    public SubProject(Integer id, String description) {
        this.id = id;
        this.description = description;
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

}
