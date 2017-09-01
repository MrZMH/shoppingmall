<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="zh-CN">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录</title> 
    <meta name="renderer" content="webkit|ie-comp|ie-stand">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta charset="utf-8">
    <meta http-equiv="Cache-Control" content="no-siteapp">
    <meta name="keywords" content="">
    <meta name="description" content="">
    <link href="css/iconfont/iconfont.css" rel="stylesheet"/>
    <link href="css/common.css" rel="stylesheet"/>
    <link href="css/login.css" rel="stylesheet"/>
    <script src="js/jquery.js"></script>
<link rel="stylesheet" href="js/icheck/style.css"/>
<script src="js/icheck/icheck.min.js"></script>
<script src="js/global.js"></script>
<script>
    $('.check input').iCheck({
            checkboxClass: 'sty1-checkbox'
        });
</script>
</head>
<body>
  <div class="login-header">
        <div class="wrapper">
            <a href="index.jsp" class="logo">
                <img src="img/logo3.png" alt="" />
            </a>
            <div class="zp">
                <span class="ico"></span>
                <div>正品保障</div>
            </div>
        </div>
    </div>
    <div class="login-main-wrap">
        <div class="login-main wrapper">
            <div class="login-box">
                <form action="" method="">
                    <div class="box-hd">
                        <span class="tit">用户登录</span>
                        <a href="register.jsp">注册新账号</a>
                    </div>
                    <label class="txtin-box">
                        <span class="ico user"></span>
                        <input class="txtin" type="text" name="username" placeholder="用户名/手机" />
                    </label>
                    <label class="txtin-box">
                        <span class="ico pwd"></span>
                        <input class="txtin" type="password" name="password" placeholder="密码" />
                    </label>
                    <div class="clearfix tool">
                        <label class="check"><input type="checkbox" id="" />保存账号</label>
                        <a class="find" href="forget-password.jsp">忘记密码？</a>
                    </div>
                    <input class="tj" type="submit" value="登&ensp;录" />
                    <div class="other-way clearfix">
                        <a class="item first" href="">
                            <img src="img/login/weixin.jpg" alt="" class="ico" />
                            <span class="label">微信</span>
                        </a>
                        <a class="item" href="">
                            <img src="img/login/qq.jpg" alt="" class="ico" />
                            <span class="label">QQ</span>
                        </a>
                        <a class="item" href="">
                            <img src="img/login/sina.jpg" alt="" class="ico" />
                            <span class="label">微博</span>
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