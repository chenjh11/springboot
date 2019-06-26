package com.example.demo.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by chenjunhong06 on 2019/6/19.
 */
@Entity
public class User implements Serializable {
    private static final  long  serialVersionUID = 1L;
    @Id
    @GeneratedValue
    private String usercode;
    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String comcode;

    public User(String usercode, String username, String password, String comcode) {
        this.usercode = usercode;
        this.username = username;
        this.password = password;
        this.comcode = comcode;
    }

    public void setUsercode(String usercode){
        this.usercode = usercode;
    }

    public String getUsercode(){
        return usercode;
    }

    public void setUsername(String username){
        this.username = username;
    }

    public String getUsername(){
        return username;
    }

    public void setPassword(String password){
        this.password = password;
    }

    public String getPassword(){
        return password;
    }

    public void setComcode(String comcode){
        this.comcode = comcode;
    }

    public String getComcode(){
        return comcode;
    }


}
