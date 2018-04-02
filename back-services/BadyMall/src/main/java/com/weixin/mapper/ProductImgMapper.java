package com.weixin.mapper;

import com.weixin.bean.ProductImg;
import com.weixin.common.BaseDAO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ProductImgMapper extends BaseDAO<Integer,ProductImg> {
    abstract List<ProductImg> listProductImgByPid(@Param("pid") Integer pid);
}
