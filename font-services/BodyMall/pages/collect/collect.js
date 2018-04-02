Page({
  	data: {
  		collectArray: [],
      iscollect:true,
      cartImg:'../../image/cart-null.png',
  	},
    onShow:function(){
      let that = this;
      let collectProducts = wx.getStorageSync('collect') || []
     
      this.setData({
        collectArray: collectProducts
      })
      
    },
    removeCollect: function (event){
      let that = this;
      let  index = event.target.dataset.alphaBeta;
      let currentcellctProducts = this.data.collectArray;
      currentcellctProducts.splice(index, 1)
      this.setData({
        carArray: currentcellctProducts,
        iscollect:false
      })
      wx.setStorageSync('collect', this.data.collectArray)
    },
    addCollect:function(e){
      let that = this;
      let index = e.target.dataset.index;
      let collectArray = that.data.collectArray;
      let collectproducts = wx.getStorageSync('collect') || []
      // 标记当前商品未添加到购物车里
      let isAddedTocollect = false;
      products.forEach(function (collectProduct, index) {
        // 判断购物车里是否已经存在指定的商品信息
        if (collectArray.pid === collectProduct.pid) {
          // 已经在购物车中，做数量的累加，并且把isAddedToCart标记为true
          isAddedTocollect = true
        }
      })
      // 如果原先购物车里没有需要添加的商品
      if (!isAddedTocollect) {
        // 组装商品信息+数量 的json对象，由于商品是初次加入购物车，则商品数量初始化为1
        let collectProduct = collectArray; 
        collectproducts.unshift(collectProduct)
        }
        // 把组装好的（商品信息+数量 ）json对象添加到购物车列表中
      wx.setStorageSync('collect', collectproducts)
      },
    goIndex:function(){
      wx.navigateTo({
        url: '../index/index',
      })
    }
})