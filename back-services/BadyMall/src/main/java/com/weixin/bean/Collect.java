package com.weixin.bean;

import java.io.Serializable;

public class Collect implements Serializable {
    private  Integer ctid;
    private  Integer uid;
    private  Integer  pid;
    private  Product product;
    private User user;
    public Collect() {
    }

    public Collect(Integer ctid, Integer uid, Integer pid, Product product, User user) {
        this.ctid = ctid;
        this.uid = uid;
        this.pid = pid;
        this.product = product;
        this.user = user;
    }

    @Override
    public String toString() {
        return "Collect{" +
                "ctid=" + ctid +
                ", uid=" + uid +
                ", pid=" + pid +
                ", product=" + product +
                ", user=" + user +
                '}';
    }

    public Integer getCtid() {
        return ctid;
    }

    public void setCtid(Integer ctid) {
        this.ctid = ctid;
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
