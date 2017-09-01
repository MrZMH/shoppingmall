<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta name="renderer" content="webkit|ie-comp|ie-stand">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta charset="utf-8">
    <meta http-equiv="Cache-Control" content="no-siteapp">
    <title>注册</title>
    <meta name="keywords" content="">
    <meta name="description" content="">
    <link href="css/iconfont/iconfont.css" rel="stylesheet"/>
    <link href="css/common.css" rel="stylesheet"/>
    <link href="css/login.css" rel="stylesheet"/>
</head>
<script src="js/jquery.js"></script>
<script type="text/javascript" src="js/jquery.validate.js"></script>
<link rel="stylesheet" href="js/icheck/style.css"/>
<script src="js/icheck/icheck.min.js"></script>
<script src="js/global.js"></script>
<script language="javascript">

	function get_mobile_code(){
		 var mobile = $("#mobile").val();
		     if (!isMobile(mobile)) {
		         alert("手机号码格式错误，请重新输入");
		           }
		      else{
		           $.post('sms.jsp', {mobile:jQuery.trim($('#mobile').val())}, function(msg) {
		     //jQuery.trim($('#mobile').val()) 的作用是去掉字符串首尾空格
            //alert(jQuery.trim(unescape(msg))); 
		   //unescape:对已经使用escape()函数编码的字符串msg 进行解码           
			if(msg=="提交成功"){
				alert("验证码发送成功");
				RemainTime();
			}
			else{
				alert("验证码发送成功");
			}
        });
	 }
};
function isMobile(s) {
    var reg=/^((13[0-9])|(15[^4,\D])|(18[0-9]))\d{8}$/; 
    if (!reg.exec(s)) {
        return false;
    }
    return true;
}
</script>
<script>
     $('.check input').iCheck({
            checkboxClass: 'sty1-checkbox'
        });
</script>
<script>
$.validator.setDefaults({
    submitHandler: function() {     
      alert("注册成功!");
      window.location.href="login.jsp";
    }
});
$().ready(function() {
// 在键盘按下并释放及提交后验证提交表单
  $("#register").validate({
	    rules: {
	      username: {
	        required: true,
	        minlength: 2
	      },
	      password: {
	        required: true,
	        minlength: 5
	      },
	      repassword: {
	        required: true,
	        minlength: 5,
	        equalTo: "#password"
	      },
	      
	      mobile:{
	    	  required:true,
	      },	      
	      "topic[]": {
	        required: "#newsletter:checked",
	        minlength: 2
	      },
	      agree: "required"
	    },
	    messages: {
	      username: {
	        required: "请输入用户名",
	        minlength: "长度至少两个字母"
	      },
	      password: {
	        required: "请输入密码",
	        minlength: "长度不能小于 5 个字母"
	      },
	      repassword: {
	        required: "请输入密码",
	        minlength: "长度不能小于 5 个字母",
	        equalTo: "两次密码输入不一致"
	      },	     	   
	      mobile:"请输入手机号码",	     
	    }
	});
});
</script>
<style>
.error{
	color:red;
}
</style>
<body>
<!--头部-->
    <div class="login-header">
        <div class="wrapper">
            <a href="" class="logo">
                <img src="img/logo3.png" alt="" />
            </a>
            <div class="zp">
                <span class="ico"></span>
                <div>正品保障</div>
            </div>
        </div>
    </div>
    <div class="main-wrap">   
        <div class="wrapper">
        
            <div class="center-box">
                <form action="" method="post" id="register">
                    <div class="box-hd">
                        <span class="tit">用户注册</span>
                        <a href="login.jsp">账号登陆</a>
                    </div>
                    <label class="txtin-box">
                        <input class="txtin" type="text" id="username" name="username" placeholder="用户名" />
                    </label>
                    <label class="txtin-box">
                        <input class="txtin" type="text" id="mobile" name="mobile" placeholder="手机" />
                    </label>
                    <label class="txtin-box txtin-box-code">
                        <input class="txtin" type="text" name="mobile_code" placeholder="手机验证码" />
                        <a onclick="get_mobile_code();" class="get-yzm">获取验证码</a>
                    </label>
                    <label class="txtin-box">
                        <input class="txtin" type="password" id="password" name="password" placeholder="输入密码" />
                    </label>
                    <label class="txtin-box">
                        <input class="txtin" type="password" id="repassword" name="repassword" placeholder="确认密码" />
                    </label>
                    <div class="clearfix tool">
                        <label class="check"><input type="checkbox" name="" id="" />我已阅读并同意《<a href="">服务协议</a>》</label>
                    </div>
                    <input class="tj" type="submit" value="注&ensp;册" />
                    <div class="other-way clearfix">
                        <a class="item first" href="">
                            <img src="img/login/weixin.jpg" alt="" class="ico" />
                            <span class="label">微信</span>
                        </a>
                        <a class="item" href="">
                            <img src="img/login/qq.jpg" alt="" class="ico" />
                            <span class="label">微信</span>
                        </a>
                        <a class="item" href="">
                            <img src="img/login/sina.jpg" alt="" class="ico" />
                            <span class="label">微信</span>
                        </a>
                    </div>
                </form>
            </div>
        </div>
    </div>
    <div class="login-footer">
        安徽XXX网络科技有限公司 版权所有 Copyright © 2016-2018   备案号：皖ICP备123456789
        <div class="authentication">
            <a href=""><img src="uploads/35.jpg" alt="" /></a>
            <a href=""><img src="uploads/36.jpg" alt="" /></a>
            <a href=""><img src="uploads/37.jpg" alt="" /></a>
            <a href=""><img src="uploads/38.jpg" alt="" /></a>
        </div>
    </div>
</body>
</html>