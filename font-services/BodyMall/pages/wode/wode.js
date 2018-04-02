var app = getApp();

Page({
  	data: {
      userInfo:[],
  	},
  	onShow: function() {
  		var that = this;
      wx.login({
        success: function (e) {
          wx.getUserInfo({
            success: function (res) {
              that.setData({
                userInfo: res.userInfo
              })
              let self = that
              wx.request({
                url: 'http://localhost:8080/user/saveUser',
                data: {
                  unickname: self.data.userInfo.nickName,
                  usex: self.data.userInfo.gender,
                  uarea: self.data.userInfo.country,
                  uimg: self.data.userInfo.avatarUrl,
                },
                method: 'post',
                header: {'content-type': 'application/x-www-form-urlencoded'
                },
                success: function (res) {
                }
              })
            }
          })
        }
      })
    },
    collectPage:function(){
      wx.navigateTo({
        url: '../collect/collect',
      })
    },
    //模拟推出程序
    addCartCollect:function(){
      let cartList =wx.getStorageSync('cart') || []
      let collect = wx.getStorageSync('collect') || []
      console.log("abdcd" + cartList.length)
      cartList.forEach(function(cart,index){
        wx.request({
          url: 'http://localhost:8080/user/saveCart',
          data: {
            uid:'2',
            pid: cart.product.pid,
            count:cart.count
          },
          method: 'post',
          header: {
            'content-type': 'application/x-www-form-urlencoded'
          },
          success: function (res) {
            wx.removeStorageSync('cart')
            app.getIsAdd.isAddedToCart = 0
          }
        })
      })
     
    }
})