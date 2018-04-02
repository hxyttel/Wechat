package com.weixin.mapper;

import com.weixin.bean.Cart;
import com.weixin.bean.Collect;
import com.weixin.bean.User;
import com.weixin.common.BaseDAO;

import java.util.List;

public interface CartMapper extends BaseDAO<Integer,Cart>{
    List<Cart> listUserCart(Integer uid);
}
