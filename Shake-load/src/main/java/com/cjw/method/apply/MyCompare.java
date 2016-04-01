package com.cjw.method.apply;

import com.cjw.entity.apply.UserInfo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by 828471 on 2016/4/1.
 */
public class MyCompare {

    public static void listCompare(List<UserInfo> userList) {
//        List<UserInfo> userList = new ArrayList<UserInfo>();
        Collections.sort(userList);
    }

    public static void listNowCompare(List<UserInfo> userList) {
//        List<UserInfo> userList = new ArrayList<UserInfo>();
        Collections.sort(userList, new Comparator<UserInfo>() {
            @Override
            public int compare(UserInfo o1, UserInfo o2) {
                if (o1 == o2)
                    return 0;
                return (o1.getAge() <= o2.getAge() ? -1 : 1);
            }
        });
    }

    public static void main(String[] args) {
        UserInfo u = new UserInfo("3222", "33333", 1);
        UserInfo m = new UserInfo("31111", "2222222", 0);
        List<UserInfo> userList = new ArrayList<UserInfo>();
        userList.add(u);
        userList.add(m);
//        listCompare(userList);
        listNowCompare(userList);
        System.out.println(userList.get(0).getUserName());

    }
}
