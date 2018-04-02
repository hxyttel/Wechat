package com.weixin.bean;

import java.io.Serializable;
import java.util.List;

public class User implements Serializable{
    private  Integer uid;
    private  String unickname;
    private  String uname;
    private  String usex;
    private Integer uage;
    private String uarea;
    private String uimg;
    private List<Cart> cart;
    private List<Collect> collect;

    public User() {
    }

    public User(Integer uid, String unickname, String uname, String usex, Integer uage, String uarea, String uimg, List<Cart> cart, List<Collect> collect) {
        this.uid = uid;
        this.unickname = unickname;
        this.uname = uname;
        this.usex = usex;
        this.uage = uage;
        this.uarea = uarea;
        this.uimg = uimg;
        this.cart = cart;
        this.collect = collect;
    }

    public List<Cart> getCart() {
        return cart;
    }

    public void setCart(List<Cart> cart) {
        this.cart = cart;
    }

    public List<Collect> getCollect() {
        return collect;
    }

    public void setCollect(List<Collect> collect) {
        this.collect = collect;
    }

    public String getUimg() {
        return uimg;
    }

    public void setUimg(String uimg) {
        this.uimg = uimg;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getUnickname() {
        return unickname;
    }

    public void setUnickname(String unickname) {
        this.unickname = unickname;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getUsex() {
        return usex;
    }

    public void setUsex(String usex) {
        this.usex = usex;
    }

    public Integer getUage() {
        return uage;
    }

    public void setUage(Integer uage) {
        this.uage = uage;
    }

    public String getUarea() {
        return uarea;
    }

    public void setUarea(String uarea) {
        this.uarea = uarea;
    }
}
