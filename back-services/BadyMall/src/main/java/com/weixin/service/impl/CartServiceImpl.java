package com.weixin.service.impl;

import com.weixin.bean.Cart;
import com.weixin.mapper.CartMapper;
import com.weixin.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartServiceImpl implements CartService{
    @Autowired
    private CartMapper cartMapper;

    @Override
    public int saveModel(Cart cart) {
        return cartMapper.saveModel(cart);
    }

    @Override
    public int updateModel(Cart cart) {
        return cartMapper.updateModel(cart);
    }

    @Override
    public int deleteModel(Cart cart) {
        return cartMapper.deleteModel(cart);
    }

    @Override
    public List<Cart> listModel() {
        return cartMapper.listModel();
    }

    @Override
    public Cart getModel(Integer cid) {
        return cartMapper.getModel(cid);
    }

    @Override
    public List<Cart> listUserCart(Integer uid) {
        return cartMapper.listUserCart(uid);
    }
}
