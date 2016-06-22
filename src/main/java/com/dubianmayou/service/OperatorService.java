package com.dubianmayou.service;

import com.dubianmayou.dao.mapper.OpCollectionMapper;
import com.dubianmayou.dao.mapper.OperatorMapper;
import com.dubianmayou.dto.FollowerDto;
import com.dubianmayou.entity.OpCollection;
import com.dubianmayou.entity.Operator;
import com.dubianmayou.utils.OpCollectionUtils;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bruce on 5/29/2016.
 */
@Service
public class OperatorService {
    @Autowired
    private OperatorMapper operatorMapper;

    @Autowired
    private OpCollectionMapper opCollectionMapper;

    public List<FollowerDto> findFollowers(String ip){
        List<FollowerDto> dtos = new ArrayList<>();
        Operator operator = operatorMapper.loadByIp(ip);
        if(operator==null){
            return dtos;
        }
        List<OpCollection> opCollections = opCollectionMapper.loadByOperatorId(operator.getId());
        if(CollectionUtils.isEmpty(opCollections)){
            return dtos;
        }
        for (OpCollection m : opCollections){
            dtos.add(OpCollectionUtils.buildFollower(m));
        }
        return dtos;
    }
}
