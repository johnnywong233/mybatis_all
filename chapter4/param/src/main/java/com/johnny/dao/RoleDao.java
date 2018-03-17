package com.johnny.dao;

import com.johnny.pojo.Role;
import com.johnny.pojo.RoleParam;

import java.util.List;

public interface RoleDao {
    List<Role> findRoleByParams(RoleParam params);
}
