package com.example.demo.service.gdpiccaims;


import com.example.demo.domain.gdpiccaims.Powerrole;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by chenjunhong06 on 2019/6/19.
 */
public interface PowerroleGdpiccaimsRepository extends JpaRepository<Powerrole,Long> {

    Powerrole findByRolecode(String rolecode);
    Powerrole findByIdOrRolecode(String id,String rolecode);
    Powerrole findByPowerid(String powerid);

    public List<Powerrole> findPowerroleByRolecode(String rolecode);

}
