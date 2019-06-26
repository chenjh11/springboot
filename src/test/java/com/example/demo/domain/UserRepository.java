package com.example.demo.domain;

import com.example.demo.domain.gdpiccaims.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
// * Created by chenjunhong06 on 2019/6/19.
 */
public interface UserRepository extends JpaRepository<User,Long>{

    User findByUsercode(String usercode);
    User findByUsercodeOrUsername(String usercode, String username);

}
