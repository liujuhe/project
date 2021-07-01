package com.bjpowernode.settings.test;

import com.bjpowernode.crm.utils.DateTimeUtil;
import com.bjpowernode.crm.utils.MD5Util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Test1 {
    public static void main(String[] args) {

        //验证失效时间
        //失效时间
        String expireTime = "2021-8-18 18:52:50";
        //系统时间
        /*String currentTime = DateTimeUtil.getSysTime();
        int count = expireTime.compareTo(currentTime);
        System.out.println(count);*/

        /*String lockState = "0";
        if ("0".equals(lockState)){
            System.out.println("账号已锁定");
        }*/

        //浏览器端的ip地址
       /* String ip = "192.168.1.1";
        //允许访问的ip地址群
        String allowIps="192.168.1.1,192.168.1.21,192.168.1.3";
        if (allowIps.contains(ip)){
            System.out.println("有效的ip地址允许访问系统");
        }else{
            System.out.println("IP地址受限，请联系管理员");
        }*/

        String pwd = "123";
        String newPwd = MD5Util.getMD5(pwd);
        System.out.println(newPwd);
    }
}
