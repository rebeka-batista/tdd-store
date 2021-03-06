package com.devsuperior.bds01.dto;

import com.devsuperior.bds01.entities.Department;

import java.io.Serializable;

public class DepartmentDto implements Serializable {

    private Long id;
    private String name;

    public DepartmentDto() {
    }

    public DepartmentDto(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public DepartmentDto(Department entity) {
        id = entity.getId();
        name = entity.getName();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
