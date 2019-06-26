package com.example.demo.service.gdpiccaims;


import com.example.demo.domain.gdpiccaims.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Map;

/**
 * Created by chenjunhong06 on 2019/6/19.
 */
public interface UserGdpiccaimsRepository extends JpaRepository<User,Long> {

    User findByUsercode(String usercode);
    User findByUsercodeOrUsername(String usercode, String username);

    public List<User> findUserByUsercode(String usercode);

//    public Map<String,Object> findUserByUsercode(String usercode);

}
