package com.tipo.witter.pojo;

import javax.validation.constraints.NotNull;

/**
 * @author Tipo
 * @version 1.0
 * @date 2019/8/12 17:47
 */
public class Account {
    @NotNull
    private String username;
    @NotNull
    private String password;
    private boolean remember;

    public Account() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isRemember() {
        return remember;
    }

    public void setRemember(boolean remember) {
        this.remember = remember;
    }

    @Override
    public String toString() {
        return "Account{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", remember=" + remember +
                '}';
    }
}
