package com.dubianmayou.controller;

import com.dubianmayou.entity.VoteResult;
import com.google.gson.Gson;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by bruce on 4/20/2015.
 */
@Controller
@RequestMapping("/vote")
public class VoteController {
    @RequestMapping(value = "/count/{name}", method = RequestMethod.GET)
    @ResponseBody
    public String getCount(@PathVariable String name) {
        if (name.equals("mayu")) {
            VoteResult result = new VoteResult();
            result.setName("mayu");
            result.setCount(4);
            return new Gson().toJson(result);
        } else if (name.equals("zhiyuan")) {
            VoteResult result = new VoteResult();
            result.setName("zhiyuan");
            result.setCount(2);
            return new Gson().toJson(result);
        } else {
            VoteResult result = new VoteResult();
            result.setName("me");
            result.setCount(1);
            return new Gson().toJson(result);
        }
    }
}
