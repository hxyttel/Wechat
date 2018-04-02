package com.weixin.service;

import com.weixin.bean.ProductImg;
import com.weixin.common.BaseService;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ProductImgService extends BaseService<Integer,ProductImg>{
    abstract List<ProductImg> listProductImgByPid(@Param("pid") Integer pid);
}
