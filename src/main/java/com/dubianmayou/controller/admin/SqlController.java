package com.dubianmayou.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by bruce on 4/28/2015.
 */
@Controller
public class SqlController {
    @RequestMapping(value = "runsql",method = RequestMethod.GET)
    public String runSql(){
        return "manage/sql";
    }
}
