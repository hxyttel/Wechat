package com.weixin.service.impl;

import com.weixin.bean.ProductImg;
import com.weixin.mapper.ProductImgMapper;
import com.weixin.mapper.ProductMapper;
import com.weixin.service.ProductImgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductImgServiceImpl implements ProductImgService {
    @Autowired
    private ProductImgMapper productImgMapper;
    @Override
    public List<ProductImg> listProductImgByPid(Integer pid) {
        return productImgMapper.listProductImgByPid(pid);
    }

    @Override
    public int saveModel(ProductImg productImg) {
        return productImgMapper.saveModel(productImg);
    }

    @Override
    public int updateModel(ProductImg productImg) {
        return productImgMapper.updateModel(productImg);
    }

    @Override
    public int deleteModel(ProductImg productImg) {
        return productImgMapper.deleteModel(productImg);
    }

    @Override
    public List<ProductImg> listModel() {
        return productImgMapper.listModel();
    }

    @Override
    public ProductImg getModel(Integer piid) {
        return productImgMapper.getModel(piid);
    }
}
