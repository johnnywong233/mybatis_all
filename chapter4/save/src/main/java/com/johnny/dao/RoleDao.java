package com.johnny.dao;

import com.johnny.pojo.Role;

import java.util.Map;

public interface RoleDao {
    Role getRole(Integer id);

    Map<Object, Object> findRoleByNote(Integer id);
}
