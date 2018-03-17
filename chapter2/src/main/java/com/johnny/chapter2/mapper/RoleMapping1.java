package com.johnny.chapter2.mapper;

import com.johnny.chapter2.po.Role;
import org.apache.ibatis.annotations.Select;

public interface RoleMapping1 {
    @Select(value = "select id,role_name as roleName,note from t_role where id =#{id} ")
    Role getRole(Long id);
}