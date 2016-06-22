package com.dubianmayou.utils.jsch;

import com.google.common.collect.Maps;
import com.jcraft.jsch.Channel;

import java.util.Map;

/**
 * Created by bruce on 6/22/2016.
 */
public class ChannelRegister {
    private static Map<String,Channel> sessionChannels = Maps.newConcurrentMap();

    public static void register(String sessionId,Channel channel){
        sessionChannels.put(sessionId,channel);
    }

    public static Channel getChannel(String sessionId){
        return sessionChannels.get(sessionId);
    }
}
