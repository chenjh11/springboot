package com.example.demo.domain.gdpiccaims;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by chenjunhong06 on 2019/6/21.
 */
@Entity
public class Powerrole implements Serializable {
    private static final  long  serialVersionUID = 1L;

    @Id
    @Column(nullable = false,name = "id")
    private String id;

    @Column(nullable = false)
    private String rolecode;

    @Column(nullable = false)
    private String powerid;





    public Powerrole(){

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

    public Powerrole(String id, String rolecode, String powerid) {
        this.setId(id);
        this.setRolecode(rolecode);
        this.setPowerid(powerid);
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

    public void setPowerid(String powerid){
        this.powerid = powerid;
    }

    public String getPowerid(){
        return powerid;
    }


    public Map<String,Object> toMap() {
        Map<String,Object> Powerroleinfo = new HashMap<String, Object>();
        Powerroleinfo.put("powerid",powerid);
        Powerroleinfo.put("rolecode",rolecode);
        Powerroleinfo.put("id",id);

        return Powerroleinfo;
    }
    @Override
    public String toString() {
        return "Powerroleinfo{" +
                "powerid=" + powerid +
                ", rolecode='" + rolecode + '\'' +
                ", id='" + id + '\'' +
                '}';
    }

}
