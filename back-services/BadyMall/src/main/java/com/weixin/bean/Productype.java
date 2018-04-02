package com.weixin.bean;

import java.io.Serializable;

public class Productype implements Serializable{
    private Integer ptid;
    private String ptname;
    private String ptUrl;

    public Productype() {
    }

    public Productype(Integer ptid, String ptname, String ptUrl) {
        this.ptid = ptid;
        this.ptname = ptname;
        this.ptUrl = ptUrl;
    }

    @Override
    public String toString() {
        return "Productype{" +
                "ptid=" + ptid +
                ", ptname='" + ptname + '\'' +
                ", ptUrl='" + ptUrl + '\'' +
                '}';
    }

    public Integer getPtid() {
        return ptid;
    }

    public void setPtid(Integer ptid) {
        this.ptid = ptid;
    }

    public String getPtname() {
        return ptname;
    }

    public void setPtname(String ptname) {
        this.ptname = ptname;
    }

    public String getPtUrl() {
        return ptUrl;
    }

    public void setPtUrl(String ptUrl) {
        this.ptUrl = ptUrl;
    }
}
