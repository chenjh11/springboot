package com.example.demo.controller;

import com.example.demo.service.gdpiccaims.UserGdpiccaimsRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

/**
 * Created by chenjunhong06 on 2019/6/19.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserGdpiccaimsRepositoryTests {
    @Autowired
    private UserGdpiccaimsRepository userGdpiccaimsRepository;

    @Test
    public void test() throws Exception{
        Date date = new Date();
//        DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG,DateFormat.LONG);
//        String formattedDate = dateFormat.format(date);
        userGdpiccaimsRepository.findByUsercode("16219410").getUsername();

        Assert.assertEquals("16219410", userGdpiccaimsRepository.findByUsercode("16219410").getUsername());


    }
}
