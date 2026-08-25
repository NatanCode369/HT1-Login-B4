package org.aaguilar.system.model;

public class User {
    private String name;
    private String lastName;
    private String email;
    private String userName;
    private String password;

    public User() {
    }

    public User(String name, String email, String lastName, String userName, String password) {
        this.name = name;
        this.email = email;
        this.lastName = lastName;
        this.userName = userName;
        this.password = password;
    }

    public User(String name, String lastName, String email, String userName) {
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.userName = userName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
