<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<meta name="renderer" content="webkit|ie-comp|ie-stand">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta http-equiv="Cache-Control" content="no-siteapp">
<title>商城首页</title>
<meta name="keywords" content="">
<meta name="description" content="">
<link href="css/iconfont/iconfont.css" rel="stylesheet" />
<link href="css/common.css" rel="stylesheet" />
<link href="css/sxtc.css" rel="stylesheet" />
<script src="js/jquery.js"></script>
<link rel="stylesheet" href="js/slick/slick.css" />
<script src="js/slick/slick.min.js"></script>
<script src="js/global.js"></script>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
</head>
<body>
<script>
$(document).ready(function(){
    $('.home-banner').slick({
        autoplay: true,
        autoplaySpeed: 5000,
        dots: true
      });

    $('.today-special-slider').slick({
        autoplay: true,
        autoplaySpeed: 5000,
        slidesToShow: 3,
        draggable: false
      });
})
</script>
   <%@include file="head.jsp"%>
	<div class="header-wrap">
		<div class="header wrapper">
			<a href="" class="logo"> <img src="img/logo4.png" alt="" />
			</a>
			<div class="header-schbox">
				<div class="inner clearfix">
					<form action="" method="">
						<input class="search-txt" placeholder="搜索宝贝">
						<button class="search-btn"></button>
						<div class="suggest-box">
							<div class="item" data-title="上衣 短款 短袖">
								上衣 短款 短袖
								<div class="tags">
									<span>雪纺</span><span>蕾丝</span><span>一字领</span>
								</div>
							</div>
						</div>
					</form>
				</div>
				<div class="hot-words">
					<a href="">太平鸟</a>
					<a href="">手机 </a>
					<a href="">内衣</a>
					<a href="">周大福</a>
					<a href="">太平鸟</a>
				</div>
			</div>
			<div class="contact">
				<div class="item">
					<span class="ico iconfont">&#xe61b;</span> <span class="tel">400-000-0000</span>
				</div>
				<div class="item">
					<span class="ico iconfont">&#xe61d;</span><a class="kefu">在线客服</a>
				</div>
			</div>
		</div>
	</div>
	<!-- 上面是搜索栏-->
	
	<div class="nav-box">
		<div class="nav wrapper">
			<div class="category-tit">全部分类</div>
			<ul class="nav-ul">
			<li><a href="">首页</a></li>
			<c:forEach items="${cs}" var="c" varStatus="st">
			<c:if test="${st.count<=4}">
				<li><a href="forecategory?cid=${c.id}">${c.name}</a></li>	
			</c:if>
			</c:forEach>
			</ul>
			<div class="nav-ad">
				<a class="ad" href=""><img src="uploads/nav-ad.jpg" alt="" /></a>
			</div>
		</div>
	</div>
	<!--头部-->

	<div class="wrapper">
		<div class="category-menu">
		<c:forEach items="${cs}" var="c" varStatus="st">
			<div class="f-item">
					<c:if test="${st.count<=4}">
						<div class="f-tit">
							<a href="forecategory?cid=${c.id}">${c.name}</a>
							<div class="f-list">
	
							<c:forEach items="${c.productsByRow}" var="ps" varStatus="st">
								<c:forEach items="${ps}" var="p">
								<c:if test="${!empty p.subTitle}">
								<a href="foreproduct?pid=${p.id}">
									<c:forEach items="${fn:split(p.subTitle, ' ')}" var="title" varStatus="st">
										<c:if test="${st.index==0}">
											${title}
										</c:if>
									</c:forEach>
								</a>
								</c:if>
								</c:forEach>
							</c:forEach>
							</div>
						</div>
					</c:if>
				</div>
			</c:forEach>
		</div>
		<div class="home-banner">
			<a href="goods-detail.html"><img src="uploads/banner-sxtc.jpg" alt="" /></a> 
			<a href="goods-detail.html"><img src="uploads/banner-sxtc.jpg" alt="" /></a>
		</div>
		<div class="home-banner-ad">
			<a href="goods-detail.html"><img src="uploads/39.jpg" alt="" /></a>
			<a href="goods-detail.html"><img src="uploads/40.jpg" alt="" /></a>
		</div>
	</div>

	<div class="wrapper">
		<div class="home-promot">
		<c:forEach items="${cs}" var="c" varStatus="stc">
		<c:if test="${stc.count<=5}">
			<div class="home-promot-tit">${c.name}</div>
			<div class="clearfix">
				<div class="list-x">
					<c:forEach items="${c.products}" var="p" varStatus="stc">
					<c:if test="${st.count <= 5}">
						<div class="item">
							<a href="foreproduct?pid=${p.id}"><img width="100px" src="img/productSingle_middle/${p.firstProductImage.id}.jpg"></a>
							<div class="info">
								<div class="name">
									<a class="productItemDescLink" href="foreproduct?pid=${p.id}">
									<span class="productItemDesc">[热销]${fn:substring(p.name, 0, 20)}</span>
							    </a>
								</div>
								<div class="price">${p.promotePrice}</div>
							</div>
						</div>
					</c:if>
					</c:forEach>
				</div>
			</div>
		</c:if>
		</c:forEach>
		</div>
	</div>
	 <%@include file="foot.jsp"%>
</body>
</html>