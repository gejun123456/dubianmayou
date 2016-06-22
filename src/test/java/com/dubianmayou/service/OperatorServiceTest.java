package com.dubianmayou.service;

import com.dubianmayou.dto.FollowerDto;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import pac.AbstractTest;

import java.util.List;

/**
 * Created by bruce on 5/29/2016.
 */
public class OperatorServiceTest extends AbstractTest {
    @Autowired
    private OperatorService operatorService;
    @Test
    public void findFollowers() throws Exception {
        List<FollowerDto> followers = operatorService.findFollowers("192.168.8.101");
        printToJson(followers);
    }

}