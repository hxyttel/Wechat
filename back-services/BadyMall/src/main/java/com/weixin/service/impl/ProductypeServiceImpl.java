package com.weixin.service.impl;

import com.weixin.bean.Productype;
import com.weixin.mapper.ProductypeMapper;
import com.weixin.service.ProductypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductypeServiceImpl implements ProductypeService{
    @Autowired
    private ProductypeMapper productypeMapper;
    @Override
    public int saveModel(Productype productype) {
        return productypeMapper.saveModel(productype);
    }

    @Override
    public int updateModel(Productype productype) {
        return productypeMapper.updateModel(productype);
    }

    @Override
    public int deleteModel(Productype productype) {
        return productypeMapper.deleteModel(productype);
    }

    @Override
    public List<Productype> listModel() {
        return productypeMapper.listModel();
    }

    @Override
    public Productype getModel(Integer ptid) {
        return productypeMapper.getModel(ptid);
    }
}
