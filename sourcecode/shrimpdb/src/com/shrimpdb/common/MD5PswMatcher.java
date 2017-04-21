package com.shrimpdb.common;

import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.SimpleCredentialsMatcher;

/*
 *自定义    密码验证类
 */
public class MD5PswMatcher extends SimpleCredentialsMatcher {  
    @Override  
    public boolean doCredentialsMatch(AuthenticationToken authcToken, AuthenticationInfo info) {  
        UsernamePasswordToken token = (UsernamePasswordToken) authcToken;  

        Object tokenCredentials = encrypt(String.valueOf(token.getPassword()));  
        Object accountCredentials = getCredentials(info);  
        
       // System.out.println(tokenCredentials);
       // System.out.println(accountCredentials);
        //将密码加密与系统加密后的密码校验，内容一致就返回true,不一致就返回false  
        return equals(tokenCredentials, accountCredentials);  
    }   
    //将传进来密码加密方法  
    private String encrypt(String data) {  
        //这里可以选择自己的密码验证方式 比如 md5或者sha256等  
        return data;  
    }
}  
