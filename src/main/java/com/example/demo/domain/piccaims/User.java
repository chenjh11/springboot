package com.example.demo.domain.piccaims;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by chenjunhong06 on 2019/6/20.
 */
@Entity
public class User implements Serializable {
    private static final  long  serialVersionUID = 1L;
//    @Id
//    @GeneratedValue
//    private Long  id;

    @Id
    @Column(nullable = false,name = "usercode")
    private String usercode;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String comcode;


    public User(){

    }

//    public User(String usercode){
//        this.setUsercode(usercode);
//    }
//
//    public User(String usercode,String username){
//        this.setUsercode(usercode);
//        this.setUsername(username);
//    }

//    public User(String usercode, String username, String password) {
//        this.setUsercode(usercode);
//        this.setUsername(username);
//        this.setPassword(password);
//    }

    public User(String usercode, String username, String password, String comcode) {
        this.setUsercode(usercode);
        this.setUsername(username);
        this.setComcode(comcode);
        this.setPassword(password);
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



    @Override
    public String toString() {
        return "Userinfo{" +
                "usercode=" + usercode +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", comcode=" + comcode +
                '}';
    }
}
