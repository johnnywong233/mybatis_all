package com.johnny.pojo;

import lombok.Data;

@Data
public class Role {
    private Integer id;
    private String roleName;
    private String note;

    @Override
    public String toString() {
        return "-->" + id + "-->" + roleName + "-->" + note;
    }
}