Page({
  	data: {
  		carArray: [],
      totalMoney:0.00,
      cartImg:'../../image/cart-null.png',
  	},
    getAllmoney:function(){
      let price = 0.0
      for (var i = 0; i < this.data.carArray.length; i++) {
        price += this.data.carArray[i].product.psellprice * this.data.carArray[i].count
      }
      this.setData({
        totalMoney: price
      })
    },
    onShow:function(){
      let that = this;
      let cartProducts = wx.getStorageSync('cart') || []
      let price = 0.0;
      this.setData({
        carArray: cartProducts
      })
      //调用自定义的方法
      this.getAllmoney();
      
    },
    removeCart: function (event){
      let that = this;
      let  index = event.target.dataset.alphaBeta;
      let currentProducts = this.data.carArray;
      that.setData({
        totalMoney: this.data.totalMoney - currentProducts[index].product.psellprice * currentProducts[index].count
      })
      currentProducts.splice(index, 1)
      this.setData({
        carArray: currentProducts
      })
      wx.setStorageSync('cart', this.data.carArray)
    },
  	carAdd: function(event){
  		var that = this;
  		var index = event.target.dataset.alphaBeta;
      var product = that.data.carArray[index].product;
      var con = that.data.carArray[index].count + 1;
      var key = 'carArray[' + index +'].count';
  		var obj = {};
  		obj[key] = con;
  		this.setData(obj);
      let products = wx.getStorageSync('cart') || []
      // 标记当前商品未添加到购物车里
      products.forEach(function (cartProduct, index) {
        // 判断购物车里是否已经存在指定的商品信息
        if (product.pid === cartProduct.product.pid) {
          // 已经在购物车中，做数量的累加，并且把isAddedToCart标记为true
          cartProduct.count = con
        }
      })
      wx.setStorageSync('cart', products);
      this.getAllmoney();
  	},
  	carReduce: function(event){
  		var that = this;
  		var index = event.target.dataset.alphaBeta;
      var product = that.data.carArray[index].product;
      var con = that.data.carArray[index].count;
      var key = 'carArray[' + index +'].count';
  		var obj = {};
  		if(con <= 1){
  			obj[key] = 1;
  			that.setData(obj);
  		}
  		else {
  			con--;
  			obj[key] = con;
  			that.setData(obj);
        let products = wx.getStorageSync('cart') || []
        // 标记当前商品未添加到购物车里
        products.forEach(function (cartProduct, index) {
          // 判断购物车里是否已经存在指定的商品信息
          if (product.pid === cartProduct.product.pid) {
            // 已经在购物车中，做数量的累加，并且把isAddedToCart标记为true
            cartProduct.count = con
          }
        })
        wx.setStorageSync('cart', products);
        this.getAllmoney();
  		}
  	},
  	carRemove: function(event){
  		var that = this;
  		var index = event.target.dataset.alphaBeta;
      var key = 'carArray[' + index +'].count';
  		var obj = {};
  		obj[key] = false;
  		this.setData(obj);
      this.getAllmoney();
  	},
    toPay: function(){
        wx.navigateTo({
          url: '../pay/pay'
        })
    },
    goIndex:function(){
      wx.navigateTo({
        url: '../index/index',
      })
    }
})