var WxAutoImage = require('../../js/wxAutoImageCal.js');
var app = getApp();

Page({
    data: {
        imgUrls: [
            '../../image/swiper0.jpg',
            '../../image/swiper4.jpg',
            '../../image/swiper3.jpg'
        ],
        //底部弹出框
        chooseSize:false,
        animationData: {},
        indicatorDots: true,
        vertical: false,
        autoplay: true,
        interval: 3000,
        duration: 1200,
        iconArray: [],
        newArrivalText:'新品上市',
        newarrivalArray:[],
        shopsHostText: "热销宝贝",
        shopsHostArray: [],
        recommendText: "精品推荐",
        recommentIcon:'../../image/icon-arrow.png',
        recomendImg:'../../image/recoment.png',
        recommendArray: [],
        product:[],
        count:1,
        cart:[],
    },
    onLoad:function(e){
      wx.removeStorageSync('cart')
      let products = wx.getStorageSync('cart') || []
      let that = this;
      wx.request({
        url: 'http://localhost:8080/productype/allProductype',
        method:'post',
        header: {
          'content-type': 'application/json' // 默认值
        },
        success:function(res){
          that.setData({
            iconArray: res.data.listproductype,
            recommendArray: res.data.recommendArray,
            shopsHostArray: res.data.shopsHostArray,
            newarrivalArray: res.data.newarrivalArray,
          })
        }
      })
      var isAddedToCart = app.getIsAdd.isAddedToCart;  
      console.log("isAddedToCart"+isAddedToCart)
      if (isAddedToCart == 0) {
        wx.request({
          url: 'http://localhost:8080/user/getUser',
          data: {
            uid: '2'
          },
          header: {
            'content-type': 'application/x-www-form-urlencoded'
          },
          method: 'post',
          success: function (res) {
            that.setData({
              cart: res.data
            })
            let self = that
            let currentCar = {};
            for (var i = 0; i < self.data.cart.length; i++) {
              currentCar = {
                product: self.data.cart[i].product,
                count: self.data.cart[i].ccount
              }
              products.unshift(currentCar)
            }
            wx.setStorageSync('cart', products)
          },

        })
        app.getIsAdd.isAddedToCart = 1
      }
      
    },
    cusImageLoad: function(e){
        var that = this;
        that.setData(WxAutoImage.wxAutoImageCal(e));
    },
    RecomentList:function(){
      /*一个页面传递一个数组去另外一个页面JSON.stringify(值)
       **另外一个页面的得到值JSON.parse(xxx.key)
      */
      wx.navigateTo({
        url: '../allRecomentProduct/allRecomentProduct?listRecment=' + JSON.stringify(this.data.recommendArray)
      })
    },
    //底部弹出框显示
    chooseSezi: function (e) {
      // 用that取代this，防止不必要的情况发生
      let that = this;
      wx.request({
        url: 'http://localhost:8080/productype/getProduct/' + e.target.dataset.pid,
        method: 'get',
        header: {
          'content-type': 'application/json' // 默认值
        },
        success: function (res) {
          that.setData({
            product: res.data
          })
        }
      })
     
      // 创建一个动画实例
      let animation = wx.createAnimation({
        // 动画持续时间
        duration: 500,
        // 定义动画效果，当前是匀速
        timingFunction: 'linear'
      })
      // 将该变量赋值给当前动画
      that.animation = animation
      // 先在y轴偏移，然后用step()完成一个动画
      animation.translateY(200).step()
      // 用setData改变当前动画
      that.setData({
        // 通过export()方法导出数据
        animationData: animation.export(),
        // 改变view里面的Wx：if
        chooseSize: true
      })
      // 设置setTimeout来改变y轴偏移量，实现有感觉的滑动
      setTimeout(function () {
        animation.translateY(0).step()
        that.setData({
          animationData: animation.export()
        })
      }, 200)
      
    },
    //查看详情页面
    recommentClik:function(e){
      wx.navigateTo({
        url: '../spdetail/spdetail?pid=' + e.target.dataset.pid
      })
      
    },
    //底部弹出框隐藏
    hideModal: function (e) {
      var that = this;
      var animation = wx.createAnimation({
        duration: 1000,
        timingFunction: 'linear'
      })
      that.animation = animation
      animation.translateY(200).step()
      that.setData({
        animationData: animation.export()

      })
      setTimeout(function () {
        animation.translateY(0).step()
        that.setData({
          animationData: animation.export(),
          chooseSize: false
        })
      }, 200)
    },
    carAdd: function (e) {
      let that = this;
      let carNum = e.target.dataset.alphaBeta;
      that.setData({
        count: carNum+1
      });
    },
    carReduce: function (e) {
      let that = this;
      let carNum = e.target.dataset.alphaBeta;
      if (carNum <= 1) {
        that.setData({
          count: carNum
        });
      }
      else {
        carNum--;
        that.setData({
          count: carNum
        });
      }
    },
    carRemove: function (e) {
      let that = this;
      let carNum = e.target.dataset.alphaBeta;
      that.setData({
        count: carNum
      });
    },
    toPay: function () {
      wx.navigateTo({
        url: '../pay/pay'
      })
    },
    addCart:function(e){
      let that = this;
      let carNum = e.target.dataset.alphaBeta;
      let product = that.data.product;
      let products = wx.getStorageSync('cart') || []
      // 标记当前商品未添加到购物车里
      let isAddedToCart = false;
      products.forEach(function (cartProduct, index) {
        // 判断购物车里是否已经存在指定的商品信息
        if (product.pid === cartProduct.product.pid) {
          // 已经在购物车中，做数量的累加，并且把isAddedToCart标记为true
          cartProduct.count = carNum
          isAddedToCart = true
        }
      })
      // 如果原先购物车里没有需要添加的商品
      if (!isAddedToCart) {
        // 组装商品信息+数量 的json对象，由于商品是初次加入购物车，则商品数量初始化为1
        let cartProduct = {
          product: product,
          count: carNum
        }
        // 把组装好的（商品信息+数量 ）json对象添加到购物车列表中
        products.unshift(cartProduct)
      }
      // 把购物车信息存储到本地存储中
      wx.setStorageSync('cart', products)
      wx.getStorageSync('cart')
      that.setData({
        count:1
      })

    }
    
})