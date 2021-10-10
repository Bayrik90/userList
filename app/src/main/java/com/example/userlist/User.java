package com.example.userlist;

public class User {
    private String userName;
    private String userLastname;
    private String phone;

    public String getUserName() {//для передачи имени
        return userName;
    }

    public String getUserLastname() {//для передачи последнего имени
        return userLastname;
    }

    public String getPhone() {//для телефона
        return phone;
    }

    public void setUserName(String userName) {//сеттер для наполнения списка именами
        this.userName = userName;
    }

    public void setUserLastname(String userLastname) {//для последнего имени
        this.userLastname = userLastname;
    }

    public void setPhone(String phone) {//для номеров
        this.phone = phone;
    }
}
