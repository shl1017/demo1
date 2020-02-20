package com.bdqn.test;

import org.apache.shiro.crypto.hash.Md5Hash;

import java.util.UUID;

public class Password {
    public static void main(String[] args) {
        String password="123456";
        Md5Hash md5Hash=new Md5Hash(password,"abc",5);
        System.out.println(md5Hash);
    }
}
