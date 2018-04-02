package com.weixin.service.impl;

import com.weixin.bean.Collect;
import com.weixin.mapper.CollectMapper;
import com.weixin.service.CollectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CollectServiceImpl implements CollectService{
    @Autowired
    private CollectMapper collectMapper;

    @Override
    public int saveModel(Collect collect) {
        return collectMapper.saveModel(collect);
    }

    @Override
    public int updateModel(Collect collect) {
        return collectMapper.updateModel(collect);
    }

    @Override
    public int deleteModel(Collect collect) {
        return collectMapper.deleteModel(collect);
    }

    @Override
    public List<Collect> listModel() {
        return collectMapper.listModel();
    }

    @Override
    public Collect getModel(Integer ctid) {
        return collectMapper.getModel(ctid);
    }
}
