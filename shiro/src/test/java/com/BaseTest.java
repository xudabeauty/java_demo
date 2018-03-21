package com;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.apache.shiro.util.ThreadContext;
import org.junit.After;
import org.junit.Before;

import com.my.entity.Permission;
import com.my.entity.Role;
import com.my.entity.User;
import com.my.service.PermissionService;
import com.my.service.PermissionServiveImpl;
import com.my.service.RoleService;
import com.my.service.RoleServiceImpl;
import com.my.service.UserService;
import com.my.service.UserServiceImpl;
import com.my.utils.JdbcTemplateUtil;

public class BaseTest {
    protected PermissionService permissionService=new PermissionServiveImpl();
    protected RoleService roleService=new RoleServiceImpl();
    protected UserService userService=new UserServiceImpl();
    protected String password="123";
    
    protected Permission p1;
    protected Permission p2;
    protected Permission p3;
    protected Role r1;
    protected Role r2;
    protected User u1;
    protected User u2;
    protected User u3;
    protected User u4;
    @Before
    public void setUp() {
        JdbcTemplateUtil.jdbcTemplate().update("delete from sys_users");
        JdbcTemplateUtil.jdbcTemplate().update("delete from sys_roles");
        JdbcTemplateUtil.jdbcTemplate().update("delete from sys_permissions");
        JdbcTemplateUtil.jdbcTemplate().update("delete from sys_users_roles");
        JdbcTemplateUtil.jdbcTemplate().update("delete from sys_roles_permissions");
        
        //新增权限
        p1 = new Permission("user:create", "用户模块新增", Boolean.TRUE);
        p2 = new Permission("user:update", "用户模块修改", Boolean.TRUE);
        p3 = new Permission("menu:create", "菜单模块新增", Boolean.TRUE);
        permissionService.createPermission(p1);
        permissionService.createPermission(p2);
        permissionService.createPermission(p3);
        
        //新增角色
        r1=new Role("admin","管理员",Boolean.TRUE);
        r2=new Role("user","普通用户",Boolean.TRUE);
        roleService.creatRole(r1);
        roleService.creatRole(r2);
        
        //关联角色-权限
        roleService.correlationPermission(r1.getId(), p1.getId());
        roleService.correlationPermission(r1.getId(), p2.getId());
        roleService.correlationPermission(r1.getId(), p3.getId());
        
        roleService.correlationPermission(r2.getId(), p1.getId());
        roleService.correlationPermission(r2.getId(),p2.getId());
        
        //新增用户
        u1 = new User("zhang", password);
        u2 = new User("li", password);
        u3 = new User("wu", password);
        u4 = new User("wang", password);
        u4.setLocked(Boolean.TRUE);
        userService.createUser(u1);
        userService.createUser(u2);
        userService.createUser(u3);
        userService.createUser(u4);
        //关联用户角色
        userService.correlationRoles(u1.getId(), r1.getId());
    }
    @After
    public void tearDown() {
        ThreadContext.unbindSubject();//退出时请解除绑定到subject的线程，否则对下次测试造成影响
    }
    protected void login(String configFile, String username, String password) {
        //1、获取SecurityManager工厂，此处使用Ini配置文件初始化SecurityManager
        Factory<org.apache.shiro.mgt.SecurityManager> factory =
                new IniSecurityManagerFactory(configFile);

        //2、得到SecurityManager实例 并绑定给SecurityUtils
        org.apache.shiro.mgt.SecurityManager securityManager = factory.getInstance();
        SecurityUtils.setSecurityManager(securityManager);

        //3、得到Subject及创建用户名/密码身份验证Token（即用户身份/凭证）
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);

        subject.login(token);
    }

    public Subject subject() {
        return SecurityUtils.getSubject();
    }
    
    

}
