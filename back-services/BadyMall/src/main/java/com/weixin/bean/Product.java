package com.weixin.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Product implements Serializable{
    private  Integer pid;
    private  String  pname;
    private  String  pdescribe;
    private  String  pvideo;  //产品视频
    private  BigDecimal pcostprice;
    private  BigDecimal psellprice;
    private  Integer    pcount;
    private  Integer    pstock; //库存量
    private  String     premark;  //产品备注
    private  Integer    ptid;
    private List<ProductImg> productImg ;
    private List<Cart> cart;
    private List<Collect> collect;

    public Product() {
    }

    public Product(Integer pid, String pname, String pdescribe, String pvideo, BigDecimal pcostprice, BigDecimal psellprice, Integer pcount, Integer pstock, String premark, Integer ptid, List<ProductImg> productImg, List<Cart> cart, List<Collect> collect) {
        this.pid = pid;
        this.pname = pname;
        this.pdescribe = pdescribe;
        this.pvideo = pvideo;
        this.pcostprice = pcostprice;
        this.psellprice = psellprice;
        this.pcount = pcount;
        this.pstock = pstock;
        this.premark = premark;
        this.ptid = ptid;
        this.productImg = productImg;
        this.cart = cart;
        this.collect = collect;
    }

    @Override
    public String toString() {
        return "Product{" +
                "pid=" + pid +
                ", pname='" + pname + '\'' +
                ", pdescribe='" + pdescribe + '\'' +
                ", pvideo='" + pvideo + '\'' +
                ", pcostprice=" + pcostprice +
                ", psellprice=" + psellprice +
                ", pcount=" + pcount +
                ", pstock=" + pstock +
                ", premark='" + premark + '\'' +
                ", ptid=" + ptid +
                ", productImg=" + productImg +
                ", cart=" + cart +
                ", collect=" + collect +
                '}';
    }

    public Integer getPstock() {
        return pstock;
    }

    public void setPstock(Integer pstock) {
        this.pstock = pstock;
    }

    public List<ProductImg> getProductImg() {
        return productImg;
    }

    public void setProductImg(List<ProductImg> productImg) {
        this.productImg = productImg;
    }

    public String getPvideo() {
        return pvideo;
    }

    public void setPvideo(String pvideo) {
        this.pvideo = pvideo;
    }

    public String getPremark() {
        return premark;
    }

    public void setPremark(String premark) {
        this.premark = premark;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public String getPdescribe() {
        return pdescribe;
    }

    public void setPdescribe(String pdescribe) {
        this.pdescribe = pdescribe;
    }

    public BigDecimal getPcostprice() {
        return pcostprice;
    }

    public void setPcostprice(BigDecimal pcostprice) {
        this.pcostprice = pcostprice;
    }

    public BigDecimal getPsellprice() {
        return psellprice;
    }

    public void setPsellprice(BigDecimal psellprice) {
        this.psellprice = psellprice;
    }

    public Integer getPcount() {
        return pcount;
    }

    public void setPcount(Integer pcount) {
        this.pcount = pcount;
    }

    public Integer getPtid() {
        return ptid;
    }

    public void setPtid(Integer ptid) {
        this.ptid = ptid;
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
}
