package com.dubianmayou.utils;

import org.apache.commons.collections.CollectionUtils;

import java.util.List;

/**
 * Created by bruce on 6/22/2016.
 */
public class DataUtils {
    public static String buildData(List<String> datas) {
        String res = "";
        if (CollectionUtils.isEmpty(datas)) {
            return "";
        }
        for (String data : datas) {
            res += data;
        }
        //remove ansi strings.
        return res.replaceAll("\u001B\\[[\\d;]*[^\\d;]","");
    }
}
