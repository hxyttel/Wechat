package com.weixin.bean;

import java.io.Serializable;

public class Cart implements Serializable {
    private Integer cid;
    private Integer uid;
    private Integer pid;
    private Integer ccount;
    private Product product;
    private User user;

    public Cart() {
    }

    public Cart(Integer cid, Integer uid, Integer pid, Integer ccount, Product product, User user) {
        this.cid = cid;
        this.uid = uid;
        this.pid = pid;
        this.ccount = ccount;
        this.product = product;
        this.user = user;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "cid=" + cid +
                ", uid=" + uid +
                ", pid=" + pid +
                ", ccount=" + ccount +
                ", product=" + product +
                ", user=" + user +
                '}';
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public Integer getCcount() {
        return ccount;
    }

    public void setCcount(Integer ccount) {
        this.ccount = ccount;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
