package com.dubianmayou.utils;

import com.dubianmayou.dto.FollowerDto;
import com.dubianmayou.entity.OpCollection;


/**
 * Created by bruce on 5/29/2016.
 */
public class OpCollectionUtils {
    public static FollowerDto buildFollower(OpCollection m) {
        FollowerDto dto = new FollowerDto();
        dto.setUrl(m.getUrl());
        dto.setCount(100);
        dto.setPicUrl("http://i5.pdim.gs/dmfd/200_200_100/94d3fd2684926c4de9a0b2f291080edf.jpeg");
        return dto;
    }
}
