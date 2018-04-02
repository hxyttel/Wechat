package com.weixin.mapper;

import com.weixin.bean.Product;
import com.weixin.common.BaseDAO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ProductMapper extends BaseDAO<Integer ,Product>{
    //根据产品类型id查询产品
    abstract List<Product> listProductByPtid(Integer ptid);
    //根据产品名模糊查询产品
    abstract List<Product> listProductByPname(@Param("pname") String pname);

    //根据产品类型id查询产品的数量
    abstract Long countProductByPtid(Integer ptid);
}
