package com.cjw.entity.apply;


/**
 * Created by 828471 on 2016/4/1.
 */
public class UserInfo implements Comparable<Object> {
    private String userName;
    private String userId;
    private int age;

    public UserInfo(String userName, String userId, int age) {
        this.userName = userName;
        this.userId = userId;
        this.age = age;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public int compareTo(Object o) {
        if (this == o)
            return 0;
        if (o != null && o instanceof UserInfo) {
            UserInfo u = (UserInfo) o;
            if (this.age <= u.age)
                return -1;
            else
                return 1;
        } else
            return -1;
    }
}
