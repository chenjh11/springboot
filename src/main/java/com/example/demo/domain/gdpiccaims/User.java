package com.example.demo.domain.gdpiccaims;


import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

/**
 * Created by chenjunhong06 on 2019/6/19.
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

//    @OneToMany(fetch = FetchType.EAGER,cascade = {CascadeType.REMOVE})
//    @JoinColumn(name = "usercode")
//    private Set<Userrole> userroless = new HashSet<Userrole>();


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


//    public Set<Userrole> getUserroless(){
//        return userroless;
//    }
//    public  void setUserroless(Set<Userrole> userroless){
//        this.userroless = userroless;
//    }

    public Map<String,Object> toMap() {
        Map<String,Object> Userinfo = new HashMap<String, Object>();
        Userinfo.put("usercode",usercode);
        Userinfo.put("username",username);
        Userinfo.put("password",password);
        Userinfo.put("comcode",comcode);
        return Userinfo;
    }

    @Override
    public String toString() {
        return "Userinfo{" +
                "usercode=" + usercode +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", comcode=" + comcode +
//                ", userroless=" + userroless +
                '}';
    }
}
