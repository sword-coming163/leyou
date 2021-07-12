package com.leyou.auth.test;

import com.leyou.auth.entity.UserInfo;
import com.leyou.auth.utils.JwtUtils;
import com.leyou.auth.utils.RsaUtils;
import org.junit.Before;
import org.junit.Test;

import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.Date;

/**
 * @Author: 98050
 * @Time: 2018-10-23 20:58
 * @Feature: JWT测试
 */
public class JwtTest {

    private static final String pubKeyPath = "C:\\Users\\Administrator\\Desktop\\secret\\rsa.pub";

    private static final String priKeyPath = "C:\\Users\\Administrator\\Desktop\\secret\\rsa.pri";

    private PublicKey publicKey;

    private PrivateKey privateKey;

    @Test
    public void testRsa() throws Exception {
        RsaUtils.generateKey(pubKeyPath, priKeyPath, "234");
    }

    @Before
    public void testGetRsa() throws Exception {
        this.publicKey = RsaUtils.getPublicKey(pubKeyPath);
        this.privateKey = RsaUtils.getPrivateKey(priKeyPath);
    }

    @Test
    public void testGenerateToken() throws Exception {
        // 生成token
        String token = JwtUtils.generateToken(new UserInfo(5040L, "zhangsan"), privateKey, 5);
        System.out.println("token = " + token);
    }

    @Test
    public void testParseToken() throws Exception {
        String token = "eyJhbGciOiJSUzI1NiJ9.eyJpZCI6NTA0MCwidXNlcm5hbWUiOiJ6aGFuZ3NhbiIsImV4cCI6MTYyNDU5Nzg3OX0.Lo8fKc_ny4oXR6euI2hHclC87RmZIKn5N0--4R04eGTjBPF667GcC8W4q7WR-V2AJTxNmrZiLyChiFMsQKB12wLQcJIE-GZET0RXqusP8tJvkRBP2k-83HhruRF5ESGuHpK9BjTiKu-mlJ6ql2qs5T3TVmq0cO6jQihD98pI93w";
        // 解析token
        UserInfo user = JwtUtils.getInfoFromToken(token, publicKey);
        System.out.println("id: " + user.getId());
        System.out.println("userName: " + user.getUsername());
    }

    @Test
    public void date(){
        System.out.println(new Date());
    }
}
