var WxAutoImage = require('../../js/detailImage.js');
var app = getApp();
Page({
    data: {
        indicatorDots: true,
        vertical: false,
        autoplay: true,
        interval: 3000,
        duration: 1200,
        iscollect: false,
        product:[],
        collectprocut:[]
    },
    cusImageLoad: function(e){
        var that = this;
        that.setData(WxAutoImage.wxAutoImageCal(e));
    },
    onLoad:function(options){
      let self = this;
      wx: wx.request({
        url: 'http://localhost:8080/productype/getProduct/' + options.pid,
        method: 'get',
        header: {
          'content-type': 'application/json' // 默认值
        },
        success: function (res) {
          self.setData({
            product:res.data
          })
        }
      })
      let currentProducts = wx.getStorageSync('collect') || []
      let product = self.data.product
      currentProducts.forEach(function (collectProduct, index) {
        if (product.pid == collectProduct.pid) {
          self.setData({
            iscollect: true
          })
         }
      })

    },
    addCart:function(){
      let that = this
      let product = that.data.product;
      let products = wx.getStorageSync('cart') || []
      // 标记当前商品未添加到购物车里
      let isAddedToCart = false;
      products.forEach(function (cartProduct, index) {
        // 判断购物车里是否已经存在指定的商品信息
        if (products.pid === cartProduct.product.pid) {
          // 已经在购物车中，做数量的累加，并且把isAddedToCart标记为true
          cartProduct.count = 1
          isAddedToCart = true
        }
      })
      // 如果原先购物车里没有需要添加的商品
      if (!isAddedToCart) {
        // 组装商品信息+数量 的json对象，由于商品是初次加入购物车，则商品数量初始化为1
        let cartProduct = {
          product: product,
          count: 1
        }
        // 把组装好的（商品信息+数量 ）json对象添加到购物车列表中
        products.unshift(cartProduct)
      }
      // 把购物车信息存储到本地存储中
      wx.setStorageSync('cart', products)
      
    },
    addCollect:function(){
      console.log("dfghj")
      let that = this;
      let product = that.data.product;
      let currentCollect = wx.getStorageSync('collect') || []
      let addCollect = false;
      currentCollect.forEach(function (collectProdut, index) {
        if (product.pid == collectProdut.pid ){
          addCollect = true
        }
      })
      if (!addCollect){
        let collectProdut = product;
        currentCollect.unshift(collectProdut);
      }
      wx.setStorageSync('collect', currentCollect)
      that.setData({
        iscollect: true
      })
    },
  removeCollect:function(){
    let that = this;
    let products = that.data.product
    let getCollectStorage = wx.getStorageSync('collect') || []
    getCollectStorage.forEach(function (product, index) {
      if (products.pid == products.pid) {
        getCollectStorage.splice(index, 1)
      }
    })
    wx.setStorageSync('collect', getCollectStorage)
    that.setData({
      iscollect: false
    })
  }
})