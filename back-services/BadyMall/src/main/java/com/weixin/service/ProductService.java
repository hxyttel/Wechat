package com.weixin.service;

import com.weixin.bean.Product;
import com.weixin.common.BaseService;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ProductService extends BaseService<Integer,Product> {
    abstract List<Product> listProductByPtid(Integer ptid);
    //根据产品名模糊查询产品
    abstract List<Product> listProductByPname(@Param("pname") String pname);
}
