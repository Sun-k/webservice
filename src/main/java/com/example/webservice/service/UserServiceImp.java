package com.example.webservice.service;

import com.example.webservice.bean.User;

import javax.jws.WebService;
import java.util.*;

/**
 * @author Sunk
 * @create 2018-4-19-16:46
 **/

@WebService(targetNamespace = "http://service.webservice.example.com/",
        endpointInterface = "com.example.webservice.service.UserService")
public class UserServiceImp implements UserService {

    private Map<String, User> userMap = new HashMap<String, User>();
     public UserServiceImp() {
                 System.out.println("向实体类插入数据");
                 User user = new User();
                 user.setUserId("411001");
                 user.setUserName("zhansan");
                 user.setAge("20");
                 user.setUpdateTIme(new Date());
                userMap.put(user.getUserId(), user);

                 user = new User();
                 user.setUserId("411002");
                 user.setUserName("lisi");
                 user.setAge("30");
                 user.setUpdateTIme(new Date());
                userMap.put(user.getUserId(), user);

                 user = new User();
                 user.setUserId("411003");
                 user.setUserName("wangwu");
                user.setAge("40");
                user.setUpdateTIme(new Date());
        userMap.put(user.getUserId(), user);
             }

    @Override
    public String getNames(String[] userIds) {

         List<String> names = new ArrayList<>();
         for(String userId : userIds){
             names.add(userMap.get(userId).getUserName());
         }
         String sysout = "";
        for(int i = 0; i < userIds.length; i++){
            sysout+="用户id："+userIds[i]+"该用户是："+names.get(i)+";";
        }
        return sysout;
    }

    @Override
    public User getUser(String userId) {

        System.out.println("userMap是:"+userMap);
        return userMap.get(userId);
    }
}
