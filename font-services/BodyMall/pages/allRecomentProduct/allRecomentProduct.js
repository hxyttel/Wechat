Page({
  data: {
    listRecoment:[],
    pname:'',
  },
  onLoad: function (options) {
    let listRecoment = JSON.parse(options.listRecment);
    this.setData({
      listRecoment: listRecoment
    })
  },
  searchRecoName:function(){
    let self = this;
    let pname = this.data.pname
    if(pname.length<=0){
      pname=null
    }
    wx.request({
      url: 'http://localhost:8080/productype/listReBypname/' + pname,
      method: 'post',
      header: {
        'content-type': 'application/json' // 默认值
      },
      success: function (res) {
        console.log(res.data)
        self.setData({
          listRecoment: res.data,
        })
      }
    })
  },
  /**
   * bindinput事件当键盘输入时，触发input事件，
   * event.detail = {value, cursor}，
   * 处理函数可以直接 return 一个字符串，将替换输入框的内容。
   * **/
  pnameConfirm:function(e){
    let pname = e.detail.value;
    this.setData({
      pname: pname
    })
  },
  /**
   * 页面相关事件处理函数--监听用户下拉动作
   */
  onPullDownRefresh: function () {
  
  },

  /**
   * 页面上拉触底事件的处理函数
   */
  onReachBottom: function () {
  
  },

  /**
   * 用户点击右上角分享
   */
  onShareAppMessage: function () {
  
  }
})