package com.weixin.controller;

import com.weixin.bean.Cart;
import com.weixin.bean.Product;
import com.weixin.bean.ProductImg;
import com.weixin.bean.User;
import com.weixin.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value="user")
public class UserController {
    @Resource(name="userServiceImpl")
    private UserService userService;

    @Resource(name = "cartServiceImpl")
    private CartService cartService;

    @Resource(name = "collectServiceImpl")
    private CollectService collectService;

    @Resource(name="productServiceImpl")
    private ProductService productService;

    @Resource(name="productImgServiceImpl")
    private ProductImgService productImgService;

    /*在微信小程序的wx.request(header: {'content-type': 'application/x-www-form-urlencoded'},)
        以字符串传递值
      */
    @RequestMapping(value="saveUser")
    public Integer saveUser(@RequestParam("unickname")String unickname,
                            @RequestParam("uarea")String uarea,
                            @RequestParam("usex")String usex,
                            @RequestParam("uimg")String uimg){
       /* String unickname = request.getParameter("unickname");
        String uarea = request.getParameter("uarea");
        String usex = request.getParameter("usex");
        String uimg = request.getParameter("uimg");
*/
        User user =  new User();
        user.setUnickname(unickname);
        user.setUarea(uarea);
        user.setUsex(usex);
        user.setUname("hxy");
        user.setUage(20);
        user.setUimg(uimg);
        Integer addCount =userService.saveModel(user);
        return addCount;
    }
    @RequestMapping(value = "saveCart")
    public Integer saveCart(@RequestParam("uid")String uid,@RequestParam("pid")String pid,@RequestParam("count")String count){
        Integer addCount =0;
        Cart carts = cartService.getModel(Integer.valueOf(pid));
        if(carts!=null){
            Cart c= new Cart();
            c.setCcount(Integer.valueOf(count));
            cartService.updateModel(c);
            return addCount ;
        }else {
            Cart cart = new Cart();
            cart.setPid(Integer.valueOf(pid));
            cart.setUid(Integer.valueOf(uid));
            cart.setCcount(Integer.valueOf(count));
            addCount = cartService.saveModel(cart);
        }
        return addCount;
    }
    @RequestMapping(value = "getUser")
    public List<Cart> UserList(@RequestParam("uid")String uid){
        List<Cart> userlist = new ArrayList<Cart>();
        List<Cart> usercart =cartService.listUserCart(Integer.valueOf(uid));
        for(Cart cart : usercart){
            Product product = productService.getModel(cart.getPid());
            List<ProductImg>  recommendImg = productImgService.listProductImgByPid(product.getPid());
            product.setProductImg(recommendImg);
            cart.setProduct(product);
            userlist.add(cart);
        }
        return userlist;
    }
}
