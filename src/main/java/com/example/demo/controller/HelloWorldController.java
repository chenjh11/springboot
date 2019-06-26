package com.example.demo.controller;




import com.example.demo.domain.gdpiccaims.Powerrole;
import com.example.demo.domain.gdpiccaims.Userrole;
import com.example.demo.domain.piccaims.User;
import com.example.demo.service.gdpiccaims.PowerroleGdpiccaimsRepository;
import com.example.demo.service.gdpiccaims.UserGdpiccaimsRepository;
import com.example.demo.service.gdpiccaims.UserroleGdpiccaimsRepository;
import com.example.demo.service.piccaims.UserPiccaimsRepository;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Created by chenjunhong06 on 2019/6/18.
 */
@RestController
public class HelloWorldController {
    @Autowired
    private UserGdpiccaimsRepository userGdpiccaimsRepository;
    @Autowired
    private UserroleGdpiccaimsRepository userroleGdpiccaimsRepository;
    @Autowired
    private PowerroleGdpiccaimsRepository powerroleGdpiccaimsRepository;

    @Autowired
    private UserPiccaimsRepository userPiccaimsRepository;

    @RequestMapping("/hello")
    public String index(){
//        Date date = new Date();
//        DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG,DateFormat.LONG);
//        String formattedDate = dateFormat.format(date);
//        userRepository.save(new User("98765432","springboottest","ssssss","44060000"));
//        userRepository.save(new User("dadswwr","深层次","75236","8888"));

//        Assert.assertEquals("75236",userRepository.findByUsercode("dadswwr").getUsername());
//        userRepository.delete(userRepository.findByUsercode("98765432"));
        com.example.demo.domain.gdpiccaims.User userGdpiccaims = userGdpiccaimsRepository.findByUsercode("16219410");
//        System.out.println(userGdpiccaims);
        String gdpiccaimsUsername = userGdpiccaims.getUsername();
//        System.out.println(gdpiccaimsUsername);
        User userPiccaims = userPiccaimsRepository.findByUsercode("PZFG201744060000000019");
//        System.out.println(userPiccaims);
        String piccaimUsername =  userPiccaims.getUsername();
//        System.out.println(piccaimUsername);
        return gdpiccaimsUsername+ "__"+piccaimUsername;

    }
//    @RequestMapping("/user")
//    public List<User> userList(){
//        return  userPiccaimsRepository.findAll();
//    }

    @RequestMapping("/gdpiccaimsUser")
    public List userGdpiccaimsList(){
       List logininfo = null;
        com.example.demo.domain.gdpiccaims.User userGdpiccaims = userGdpiccaimsRepository.findByUsercode("16219410");
        logininfo = userGdpiccaimsRepository.findUserByUsercode("16219410");
        List userGdpiccaimss = userGdpiccaimsRepository.findUserByUsercode("16219410");
        Map<String,Object> userGdpiccaimsMap = userGdpiccaims.toMap();
        System.out.println(userGdpiccaims);
        Userrole userroleGdpiccaimss = userroleGdpiccaimsRepository.findByUsercode(userGdpiccaims.getUsercode());
        List userroleGdpiccaims = userroleGdpiccaimsRepository.findUserroleByUsercode(userGdpiccaims.getUsercode());
        System.out.println(userroleGdpiccaims.get(0));
        Map<String,Object> userroleGdpiccaimssMap =userroleGdpiccaimss.toMap();
        Map<String,Object> result = new HashMap<String, Object>();
        result.putAll(userGdpiccaimsMap);
        System.out.println(result);
        result.putAll(userroleGdpiccaimssMap);
        System.out.println(result);

//        JSONObject jsonpObject = new JSONObject(userroleGdpiccaims.get(0));
//        System.out.println(jsonpObject);
        if(null != userroleGdpiccaimssMap){
            System.out.println(userroleGdpiccaimssMap.get("rolecode").toString());

            List powerroleGdpiccaims = powerroleGdpiccaimsRepository.findPowerroleByRolecode(userroleGdpiccaimssMap.get("rolecode").toString());
            if(null != powerroleGdpiccaims){
                Powerrole powerrole = (Powerrole) powerroleGdpiccaims.get(0);
                System.out.println(powerrole);
                System.out.println(powerroleGdpiccaims.size());
                powerroleGdpiccaims.add(userroleGdpiccaims);
                System.out.print(powerroleGdpiccaims.get(0).getClass().getName());
            }
        }
        return  logininfo;
    }
}
