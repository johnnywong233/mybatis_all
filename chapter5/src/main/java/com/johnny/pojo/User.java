package com.johnny.pojo;

import lombok.Data;

@Data
public class User {
    private Integer id;
    private String userName;
    private String cnName;
    private Integer sex;
    private String mobile;
    private String email;
    private String note;

    @Override
    public String toString() {
        return "--->" + id + "--->" + userName + "--->" + cnName + "--->" + sex +
                "--->" + mobile + "--->" + email + "--->" + note;
    }
}