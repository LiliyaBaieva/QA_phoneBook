package com.phonebook.model;

public class User {
  public String email;
  public String password;

  public String getEmail() {
    return email;
  }

  public String getPassword() {
    return password;
  }

  public User setEmail(String email) {
    this.email = email;
    return this;
  }

  public User setPassword(String password) {
    this.password = password;
    return this;
  }


}