package com.dubianmayou.dao.mapper;

import com.dubianmayou.entity.OpCollection;

import java.util.List;

/**
 * Created by bruce on 5/29/2016.
 */
public interface OpCollectionMapper {
    List<OpCollection> loadByOperatorId(int operatorId);
}
