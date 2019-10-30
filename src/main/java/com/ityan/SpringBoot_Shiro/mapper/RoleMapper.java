package com.ityan.SpringBoot_Shiro.mapper;

import com.ityan.SpringBoot_Shiro.domain.Role;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RoleMapper {
    int deleteByPrimaryKey(Long rid);

    int insert(Role record);

    Role selectByPrimaryKey(Long rid);

    List<Role> selectAll();

    int updateByPrimaryKey(Role record);

    void inserRolePermission(@Param("rid") Long rid, @Param("pid") Long pid);

    void deleteRolePermission(Long rid);

    List<Long> getRoleByid(Long id);
}