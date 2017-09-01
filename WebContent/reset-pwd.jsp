<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="renderer" content="webkit|ie-comp|ie-stand">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta charset="utf-8">
    <meta http-equiv="Cache-Control" content="no-siteapp">
    <title>重置密码</title>
    <meta name="keywords" content="">
    <meta name="description" content="">
    <link href="css/iconfont/iconfont.css" rel="stylesheet"/>
    <link href="css/common.css" rel="stylesheet"/>
    <link href="css/login.css" rel="stylesheet"/>
</head>
<script src="js/jquery.js"></script>
<script src="js/global.js"></script>
<script type="text/javascript" src="js/jquery.validate.js"></script>
<script type="text/javascript">
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
                        <span class="tit">重置密码</span>
                    </div>
                    <label class="txtin-box">
                        <input class="txtin" type="password" name="password" placeholder="输入密码" />
                    </label>
                    <label class="txtin-box">
                        <input class="txtin" type="password" name="repassword" placeholder="确认密码" />
                    </label>

                    <input class="tj" type="submit" value="完&nbsp;成" />

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