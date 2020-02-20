package com.bdqn.test;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;

public class HelloTest {
    public static void main(String[] args) {
        Factory<SecurityManager> factory=new IniSecurityManagerFactory("classpath:shiro.ini");
        SecurityManager manager=factory.getInstance();
        SecurityUtils.setSecurityManager(manager);
        Subject currentUser=SecurityUtils.getSubject();
        UsernamePasswordToken token=new UsernamePasswordToken("test","123");
        try {
            currentUser.login(token);
            System.out.println("身份信息验证成功");
        } catch (AuthenticationException e) {
            e.printStackTrace();
            System.out.println("身份信息验证失败");
        }
        currentUser.logout();//退出
    }
}
