package com.shrimpdb.common;

import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.SimpleCredentialsMatcher;

/*
 *�Զ���    ������֤��
 */
public class MD5PswMatcher extends SimpleCredentialsMatcher {  
    @Override  
    public boolean doCredentialsMatch(AuthenticationToken authcToken, AuthenticationInfo info) {  
        UsernamePasswordToken token = (UsernamePasswordToken) authcToken;  

        Object tokenCredentials = encrypt(String.valueOf(token.getPassword()));  
        Object accountCredentials = getCredentials(info);  
        
       // System.out.println(tokenCredentials);
       // System.out.println(accountCredentials);
        //�����������ϵͳ���ܺ������У�飬����һ�¾ͷ���true,��һ�¾ͷ���false  
        return equals(tokenCredentials, accountCredentials);  
    }   
    //��������������ܷ���  
    private String encrypt(String data) {  
        //�������ѡ���Լ���������֤��ʽ ���� md5����sha256��  
        return data;  
    }
}  
