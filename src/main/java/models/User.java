package models;

import javax.naming.Name;

public class User {
    String name;
    String lastName;
    String email;
    String password;

    public User() {

    }

    public void setName(String name) {
        this.name = name;
    }
    public User withName(String name) {
        if (name == null) return this;
        this.name = name;
        return this;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public User withLastName(String lastName) {
        if (lastName == null) return this;
        this.lastName = lastName;
        return this;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public User withEmail(String email) {
        if (email == null) return this;
        this.email= email;
        return this;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public User withPassword(String password) {
        if (password == null) return this;
        this.password= password;
        return this;
    }
    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public User(String name, String lastName, String email, String password) {
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
    }
}
