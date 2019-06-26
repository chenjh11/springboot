package com.example.demo.service.piccaims;

import com.example.demo.domain.piccaims.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by chenjunhong06 on 2019/6/20.
 */
public interface UserPiccaimsRepository extends JpaRepository<User,Long> {

    User findByUsercode(String usercode);
    User findByUsercodeOrUsername(String usercode, String username);

    public List<User> findUserByUsercode(String usercode);

}
