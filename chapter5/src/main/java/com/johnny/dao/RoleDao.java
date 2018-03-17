package com.johnny.dao;

import com.johnny.pojo.Role;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RoleDao {
    /**
     * 5.2 if
     */
    List<Role> findRolesIf(@Param("roleName") String roleName);

    /**
     * 5.3 choose,when,otherwise元素
     */
    List<Role> findChooseWhenOtherWise(@Param("id") String id, @Param("roleName") String roleName);

    /**
     * 5.4 trim,where,set元素
     * where
     */
    List<Role> findWhere(@Param("roleName") String roleName);

    /**
     * trim
     */
    List<Role> findRoleTrim(@Param("roleName") String roleName);

    /**
     * set
     */
    int updateRole(@Param("role") Role role);

     /* 5.4 trim,where,set元素end  */

    /**
     * 5.6 test属性
     */
    List<Role> getRoleTest(@Param("type") String type);

    /**
     * 5.7 使用Bind元素.
     */
    List<Role> findRoleMulBind(@Param("roleName") String roleName, @Param("note") String note);
}