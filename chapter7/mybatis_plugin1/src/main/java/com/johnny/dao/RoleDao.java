package com.johnny.dao;

import com.johnny.pojo.Role;
import org.apache.ibatis.annotations.Param;

public interface RoleDao {
    /**
     * set
     */
    int insertRole(@Param("role") Role role);
}