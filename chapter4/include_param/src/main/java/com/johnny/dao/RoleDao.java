package com.johnny.dao;

import com.johnny.pojo.Role;

import java.util.List;
import java.util.Map;

public interface RoleDao {
    Role getRoleCustom(Integer id);

    List<Role> findRoles(Map<String, String> params);

    Role getRole(Integer id);
}
