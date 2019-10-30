package com.ityan.SpringBoot_Shiro.config;

import com.ityan.SpringBoot_Shiro.domain.Employee;
import com.ityan.SpringBoot_Shiro.domain.Permission;
import com.ityan.SpringBoot_Shiro.domain.Role;
import com.ityan.SpringBoot_Shiro.service.EmployeeService;
import com.ityan.SpringBoot_Shiro.service.RoleService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
/*
* 自定义Realm
* */
public class EmployeeRealm extends AuthorizingRealm {
    @Autowired
    EmployeeService employeeService;
    RoleService roleService;

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        System.out.println("来到了认证");
        String  username = (String)token.getPrincipal();
        Employee employee = employeeService.getEmplByUsername(username);
        String password = employee.getPassword();
        if (password==null || "".equals(password)){
            return null;
        }
        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(employee,password,this.getName());
        return info;
    }

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("来到了授权");
        //获取客户主体
        Employee employee = (Employee) principalCollection.getPrimaryPrincipal();
        //声明角色集合
        List<String> RoleList = new ArrayList<>();
        //声明权限集合
        List<String> PermissionList = new ArrayList<>();
        //根据用户id获取角色id
        RoleList = employeeService.getRolesByEid(employee.getId());
        System.out.println("角色有："+RoleList);
        //根据用户id获取权限id
        PermissionList = employeeService.getPermissionByEid(employee.getId());
        System.out.println("权限有："+PermissionList);
        //给授权信息
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        //添加角色
        info.addRoles(RoleList);
        //添加权限
        info.addStringPermissions(PermissionList);


        return info;
    }


}
