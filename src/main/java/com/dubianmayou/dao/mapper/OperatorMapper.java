package com.dubianmayou.dao.mapper;

import com.dubianmayou.entity.Operator;

/**
 * Created by bruce on 5/29/2016.
 */
public interface OperatorMapper {
    Operator loadByIp(String ip);
}
