package com.example.userlist;

import java.util.ArrayList;

public class Users {
    ArrayList<User> userList;//коллекция для наполнения списка ресайклвью
    public ArrayList<User> getUserList(){
        this.userList = new ArrayList<>();
        for (int i = 0; i < 100; i++) {//делаем список до 100
            User user = new User();
            user.setUserName("Имя_"+(i+1));//сеттеры для имени
            user.setUserLastname("Фамилия_"+(i+1));//и фамилии
            userList.add(user);//вкладываем список для рейсклвью
        }
        return userList;
    }
}
