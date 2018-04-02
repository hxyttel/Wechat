package com.weixin.bean;

import java.io.Serializable;

public class ProductImg implements Serializable{
    private Integer piid ;
    private String  piurl;
    private Integer pid;
    private Product product;

    public ProductImg() {
    }

    public ProductImg(Integer piid, String piurl, Integer pid, Product product) {
        this.piid = piid;
        this.piurl = piurl;
        this.pid = pid;
        this.product = product;
    }

    public Integer getPiid() {
        return piid;
    }

    public void setPiid(Integer piid) {
        this.piid = piid;
    }

    public String getPiurl() {
        return piurl;
    }

    public void setPiurl(String piurl) {
        this.piurl = piurl;
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
}
