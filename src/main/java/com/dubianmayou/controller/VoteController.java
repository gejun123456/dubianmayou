package com.dubianmayou.controller;

import com.dubianmayou.entity.VoteResult;
import com.google.common.collect.Lists;
import com.google.gson.Gson;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by bruce on 4/20/2015.
 */
@Controller
@RequestMapping("/vote")
public class VoteController {
    @RequestMapping(value = "/count/{name}", method = RequestMethod.GET)
    @ResponseBody
    public String getCount(@PathVariable String name) {
//        if (name.equals("mayu")) {
//            VoteResult result = new VoteResult();
//            result.setName("mayu");
//            result.setCount(4);
//            return new Gson().toJson(result);
//        } else if (name.equals("zhiyuan")) {
//            VoteResult result = new VoteResult();
//            result.setName("zhiyuan");
//            result.setCount(2);
//            return new Gson().toJson(result);
//        } else {
//            VoteResult result = new VoteResult();
//            result.setName("me");
//            result.setCount(1);
//            return new Gson().toJson(result);
//        }
        return "";
    }

    @RequestMapping(value = "/countAll", method = RequestMethod.GET)
    @ResponseBody
    public String getAllCount() {
        List<VoteResult> votes = Lists.newArrayList();
        VoteResult ra = new VoteResult();
        ra.setName("mayu");
        ra.setCount(4);
        votes.add(ra);
        VoteResult rb = new VoteResult();
        rb.setName("zhiyuan");
        rb.setCount(2);
        VoteResult rc = new VoteResult();
        rc.setName("me");
        rc.setCount(1);
        votes.add(rb);
        votes.add(rc);
        return new Gson().toJson(votes);
    }
}
