package com.johnny.dao;

import com.johnny.pojo.Role;

import java.util.List;

public interface RoleDao {
    int updateRole(Role role);

    int deleteRole(Integer id);

    List<Role> selectAllData();
}
