package model;

public class UserInfo {

    public static final UserInfo info = new UserInfo();

    private UserInfo(){

    }

    public static UserInfo getUserInfo(){
        return info;
    }
}
