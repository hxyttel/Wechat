package com.weixin.service.impl;

import com.weixin.bean.Product;
import com.weixin.mapper.ProductMapper;
import com.weixin.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class ProductServiceImpl implements ProductService{
    @Autowired
    private ProductMapper productMapper;
    @Autowired
    private RedisTemplate redisTemplate;
    @Override
    public List<Product> listProductByPtid(Integer ptid) {
        //从缓存中拿数据
        List<Product> productlist = new ArrayList<Product>();
        ListOperations<String, Object> listOperation = redisTemplate.opsForList();
        Long size = listOperation.size("product");
        Long count = productMapper.countProductByPtid(ptid);
        //缓存10条数据
        if (size !=count&&size<=10) {
            productlist = productMapper.listProductByPtid(ptid);
            for (int i = 0; i < productlist.size(); i++) {
                if(productlist.size()>0){
                    listOperation.rightPush("product", productlist.get(i));
                }
            }
            System.out.println("从数据库中取数据");
            return productlist;
        } else {
            for (int i = 0; i < size; i++) {
                productlist.add((Product)listOperation.leftPop("product"));
            }
            System.out.println("从缓存中取数据");
            return productlist;
        }
    }

    @Override
    public List<Product> listProductByPname(String pname) {
        return productMapper.listProductByPname(pname);
    }

    @Override
    public int saveModel(Product product) {
        return productMapper.saveModel(product);
    }

    @Override
    public int updateModel(Product product) {

        return productMapper.updateModel(product);
    }

    @Override
    public int deleteModel(Product product) {
        return productMapper.deleteModel(product);
    }

    @Override
    public List<Product> listModel() {
        return productMapper.listModel();
    }

    @Override
    public Product getModel(Integer pid) {
        return productMapper.getModel(pid);
    }
}
