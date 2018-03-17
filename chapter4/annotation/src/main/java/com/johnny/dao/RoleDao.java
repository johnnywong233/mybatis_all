package com.johnny.dao;

import com.johnny.pojo.Role;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RoleDao {
    List<Role> findRoleByAnnotation(@Param("roleName") String rolename, @Param("note") String note);
}