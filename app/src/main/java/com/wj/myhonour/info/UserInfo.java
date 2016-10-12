package com.wj.myhonour.info;

/**
 * WangJ jie581825@yeah.net
 * Created on 2016/10/12
 * Modified:
 * Modified on
 */
public class UserInfo {

    private static boolean isLogin;
    private static String userId;
    private static String userName;

    public static boolean isLogin(){
        return isLogin;
    }

    public static String getUserId(){
        return userId;
    }

    public static String getUserName(){
        return userName;
    }

    public static void login() {
        isLogin = true;

        userId = "";
        userName = "";
    }

    public static void logout() {
        isLogin = false;

        userId = "";
        userName = "";
    }
}
