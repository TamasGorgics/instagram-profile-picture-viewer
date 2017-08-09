package com.tgorgics.instaprofilepic.web.dto;

public class UserDTO {

    private String userName;

    public String getUserName() {
        return this.userName;
    }

    public void setUserName(final String userName) {
        this.userName = userName;
    }

    @Override
    public String toString() {
        return "UserDTO [userName=" + this.userName + "]";
    }

}
