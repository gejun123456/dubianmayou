package com.dubianmayou.utils.jsch;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by bruce on 6/22/2016.
 */
public class SessionUtils {
    private static Map<String,Queue<String>> sessionData = Maps.newConcurrentMap();

    public static void addData(String sessionId,String value){
        if(sessionData.containsKey(sessionId)){
            sessionData.get(sessionId).add(value);
        } else {
            LinkedBlockingQueue<String> s = new LinkedBlockingQueue<>();
            s.add(value);
            sessionData.put(sessionId,s);
        }
    }

    public static List<String> getData(String sessionId){
        List<String> res= Lists.newArrayList();
        if(sessionData.containsKey(sessionId)){
            Queue<String> queue = sessionData.get(sessionId);
            while(!queue.isEmpty()){
                String poll = queue.poll();
                res.add(poll);
            }
        }
        return res;
    }
}
