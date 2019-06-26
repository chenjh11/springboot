package com.example.demo.domain.gdpiccaims;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by chenjunhong06 on 2019/6/21.
 */
@Entity
public class Userrole implements Serializable {
    private static final  long  serialVersionUID = 1L;

    @Id
    @Column(nullable = false,name = "id")
    private String id;

    @Column(nullable = false)
    private String usercode;

    @Column(nullable = false)
    private String rolecode;

    @Column(nullable = false)
    private String comcode;


//    @ManyToOne(fetch = FetchType.EAGER)
//    private User user;



    public Userrole(){

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

    public Userrole(String usercode, String rolecode, String comcode) {
        this.setUsercode(usercode);
        this.setRolecode(rolecode);
        this.setComcode(comcode);
    }

    public void setUsercode(String usercode){
        this.usercode = usercode;
    }


    public String getUsercode(){
        return usercode;
    }

    public void setId(String id){
        this.id = id;    }

    public String getId(){
        return id;
    }

    public void setRolecode(String rolecode){
        this.rolecode = rolecode;
    }

    public String getRolecode(){
        return rolecode;
    }

    public void setComcode(String comcode){
        this.comcode = comcode;
    }

    public String getComcode(){
        return comcode;
    }


//    public  User getUser(){
//        return user;
//    }
//    public void setUser(User user){
//        this.user = user;
//    }

    public Map<String,Object> toMap() {
        Map<String,Object> userrole = new HashMap<String, Object>();
        userrole.put("usercode",usercode);
        userrole.put("rolecode",rolecode);
        userrole.put("id",id);
        userrole.put("comcode",comcode);
        return userrole;
    }

    @Override
    public String toString() {
        return "Userroleinfo{" +
                "usercode=" + usercode +
                ", rolecode='" + rolecode + '\'' +
                ", id='" + id + '\'' +
                ", comcode=" + comcode +
//                ", userroless=" + userroless +
                '}';
    }
}
