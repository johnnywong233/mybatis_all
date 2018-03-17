package com.johnny.dao;

import com.johnny.pojo.Role;

import java.util.List;
import java.util.Map;

public interface RoleDao {
    List<Role> findRoleByMap(Map<String, String> params);
}
