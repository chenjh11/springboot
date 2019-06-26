package com.example.demo.service.gdpiccaims;

import com.example.demo.domain.gdpiccaims.Userrole;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by chenjunhong06 on 2019/6/21.
 */
public interface UserroleGdpiccaimsRepository extends JpaRepository<Userrole,Long> {
    Userrole findByUsercode(String usercode);
    Userrole findById(String id);
    Userrole findByRolecode(String rolecode);
    public List<Userrole> findUserroleByUsercode(String usercode);
}
