package com.weixin.service;

import com.weixin.bean.Cart;
import com.weixin.bean.User;
import com.weixin.common.BaseService;

import java.util.List;

public interface CartService extends BaseService<Integer,Cart> {
    List<Cart> listUserCart(Integer uid);
}
