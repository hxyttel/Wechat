package com.weixin.controller;

import com.weixin.bean.Product;
import com.weixin.bean.ProductImg;
import com.weixin.bean.Productype;
import com.weixin.service.ProductImgService;
import com.weixin.service.ProductService;
import com.weixin.service.ProductypeService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "productype")
public class ProductypeController {
    @Resource(name="productypeServiceImpl")
    private ProductypeService productypeService;

    @Resource(name="productServiceImpl")
    private ProductService productService;

    @Resource(name="productImgServiceImpl")
    private ProductImgService productImgService;

    /**
     *微信小程序进入首页的数据查询
     * */
    @RequestMapping(value = "allProductype")
    public Map<String,Object> allProductye(){
        Map<String,Object> map = new HashMap<String,Object>();
        List<Productype> productypeList = productypeService.listModel();
        Integer ptid1 = 9;
        List<Product> recommendArray = new ArrayList<Product>();
        List<Product> recommendList= productService.listProductByPtid(ptid1);
        for(Product productrecommend :recommendList){
            List<ProductImg>  recommendImg = productImgService.listProductImgByPid(productrecommend.getPid());
            productrecommend.setProductImg(recommendImg);
            recommendArray.add(productrecommend);
        }
        Integer ptid2 = 10;
        List<Product> newarrivalArray = new ArrayList<Product>();
        List<Product> newarrivalList= productService.listProductByPtid(ptid2);
        for(Product productnewarrival :newarrivalList){
            List<ProductImg>  recommendImg = productImgService.listProductImgByPid(productnewarrival.getPid());
            productnewarrival.setProductImg(recommendImg);
            newarrivalArray.add(productnewarrival);
        }
        Integer ptid3 = 11;
        List<Product> shopsHostList= productService.listProductByPtid(ptid3);
        List<Product> shopsHostArray = new ArrayList<Product>();
        for(Product productshopsHost :shopsHostList){
            List<ProductImg>  recommendImg = productImgService.listProductImgByPid(productshopsHost.getPid());
            productshopsHost.setProductImg(recommendImg);
            shopsHostArray.add(productshopsHost);
        }
        map.put("listproductype",productypeList);
        map.put("recommendArray",recommendArray);
        map.put("shopsHostArray",shopsHostArray);
        map.put("newarrivalArray",newarrivalArray);
        return map;
    }

    /**
     * 模糊查询产品
     * */
    @PostMapping(value="listReBypname/{pname}")
    public  List<Product> listReBypname(@PathVariable("pname")String pname){
        List<Product> listReBypname = productService.listProductByPname(pname);
        return  listReBypname;
    }

    /**
     * 根据pid查询产品
     * */
    @GetMapping(value="getProduct/{pid}")
    public Product getProduct(@PathVariable("pid")Integer pid){
        Product product = productService.getModel(pid);
        List<ProductImg> productImgList = productImgService.listProductImgByPid(pid);
        product.setProductImg(productImgList);
        return product;
    }
}
