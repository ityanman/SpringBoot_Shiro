package com.ityan.SpringBoot_Shiro.mapper;

import com.ityan.SpringBoot_Shiro.domain.Permission;

import java.util.List;

public interface PermissionMapper {
    int deleteByPrimaryKey(Long pid);

    int insert(Permission record);

    Permission selectByPrimaryKey(Long pid);

    List<Permission> selectAll();

    int updateByPrimaryKey(Permission record);

    List<Permission> getPrimaryByrid(long rid);
}