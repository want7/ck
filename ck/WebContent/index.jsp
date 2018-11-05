<%@ page language="java" import="java.util.*"
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="entity.user"%>
<!DOCTYPE html>
<html>
<head>
<title>Home</title>
<link href="css/bootstrap.css" rel="stylesheet" type="text/css"
	media="all" />
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="js/jquery.min.js"></script>
<!-- Custom Theme files -->
<!--theme-style-->
<link href="css/style.css" rel="stylesheet" type="text/css" media="all" />
<!--//theme-style-->
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords"
	content="Fashion Mania Responsive web template, Bootstrap Web Templates, Flat Web Templates, Andriod Compatible web template, 
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyErricsson, Motorola web design" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<!-- start menu -->
<link href="css/memenu.css" rel="stylesheet" type="text/css" media="all" />
<script type="text/javascript" src="js/memenu.js"></script>
<script>$(document).ready(function(){$(".memenu").memenu();});</script>
<script src="js/simpleCart.min.js"> </script>
<!-- slide -->
<script src="js/responsiveslides.min.js"></script>
<script>
    $(function () {
      $("#slider").responsiveSlides({
      	auto: true,
      	speed: 500,
        namespace: "callbacks",
        pager: true,
      });
    });
  </script>
<style type="text/css">
a {
	text-decoration: none
}

.a {
	width: 300px;
	height: 30px;
}

#b {
	width: 500px;
	text-align: right; /*右对齐*/
	·
}
</style>
</head>
<body>

	<%= new Date() %>
	<% 
     user user=(user)request.getAttribute("user");
%>
	<!--header-->
	<div class="header">
		<div class="header-top">
			<div class="container">

				<div class="col-sm-4 logo">
					<h1 color="red">Blog</h1>
				</div>

			</div>
		</div>
		<div class="container">
			<div class="head-top">
				<div class="col-sm-2 number">
					<span><i class="glyphicon glyphicon-phone"></i>085 596 234</span>
				</div>
				<div class="col-sm-8 h_menu4">
					<ul class="memenu skyblue">


						<li><a href="#">文章</a>
							<div class="mepanel">
								<div class="row">
									<div class="col1">
										<div class="h_nav">
											<ul>
												<li><a href="products.html">我的文章</a></li>
												<li><a href="products.html">新建文章</a></li>

											</ul>
										</div>
									</div>
								</div>
							</div></li>


						<li><a href="typo.html">我的相册</a></li>
						<li><a class="color6" href="contact.html">留言板</a></li>
						<li><a class="color6" href="contact.html">我的好友</a></li>


						<li><a href="#">个人信息</a>
							<div class="mepanel">
								<div class="row">
									<div class="col1">
										<div class="h_nav">
											<ul>
												<li><a href="changeInfo.html">修改个人信息</a></li>
											</ul>
										</div>
									</div>
								</div>
							</div></li>





					</ul>
				</div>
				<div class="col-sm-2 search">
					<a class="play-icon popup-with-zoom-anim" href="#small-dialog"><i
						class="glyphicon glyphicon-search"> </i> </a>
				</div>
				<div class="clearfix"></div>
				<!---pop-up-box---->
				<script type="text/javascript" src="js/modernizr.custom.min.js"></script>
				<link href="css/popuo-box.css" rel="stylesheet" type="text/css"
					media="all" />
				<script src="js/jquery.magnific-popup.js" type="text/javascript"></script>
				<!---//pop-up-box---->
				<div id="small-dialog" class="mfp-hide">
					<div class="search-top">
						<div class="login">
							<input type="submit" value=""> <input type="text"
								value="Type something..." onFocus="this.value = '';"
								onBlur="if (this.value == '') {this.value = '';}">
						</div>
						<p>Shopping</p>
					</div>
				</div>
				<script>
						$(document).ready(function() {
						$('.popup-with-zoom-anim').magnificPopup({
							type: 'inline',
							fixedContentPos: false,
							fixedBgPos: true,
							overflowY: 'auto',
							closeBtnInside: true,
							preloader: false,
							midClick: true,
							removalDelay: 300,
							mainClass: 'my-mfp-zoom-in'
						});
																						
						});
				</script>
				<!---->
			</div>
		</div>
	</div>
	<!--banner-->
	<div class="banner">
		<div class="col-sm-3 banner-mat">
			<img class="img-responsive" src="images/ba1.jpg" alt="">
		</div>
		<div class="col-sm-6 matter-banner">
			<div class="slider">
				<div class="callbacks_container">
					<ul class="rslides" id="slider">
						<li><img src="images/1.jpg" alt=""></li>
						<li><img src="images/2.jpg" alt=""></li>
						<li><img src="images/1.jpg" alt=""></li>
					</ul>
				</div>
			</div>
		</div>
		<div class="col-sm-3 banner-mat">
			<img class="img-responsive" src="images/ba.jpg" alt="">
		</div>
		<div class="clearfix"></div>
	</div>
	<!--//banner-->
	<div class="copyrights">
		Collect from <a href="http://www.cssmoban.com/">手机网站模板</a>
	</div>
	<!--content-->
	<div class="content">
		<div class="container">
			<div class="content-top">

				<!-- 修改部分 -->
				<h1>Recent Products</h1>
				<div class="content-top1">
					<form action="index?id=1001" method="post">
						<div class="col-md-3 col-md2">
							<div class="col-md1 simpleCart_shelfItem">
								<a href="single.html"> <img class="img-responsive"
									src="images/pi.png" alt="" />
								</a>
								<h3>
									<a href="single.html">Tops</a>
								</h3>
								<div class="price">
									<h5 class="item_price">$300</h5>
									<input type="submit" value="Add To Cart">
									<div class="clearfix"></div>
								</div>
							</div>

						</div>
					</form>
					<form action="index?id=1002" method="post">
						<div class="col-md-3 col-md2">
							<div class="col-md1 simpleCart_shelfItem">
								<a href="single.html"> <img class="img-responsive"
									src="images/pi2.png" alt="" />
								</a>
								<h3>
									<a href="single.html">T-Shirt</a>
								</h3>

								<div class="price">
									<h5 class="item_price">$300</h5>
									<input type="submit" value="Add To Cart">
									<div class="clearfix"></div>
								</div>

							</div>
						</div>
					</form>
					<form action="index?id=1003" method="post">
						<div class="col-md-3 col-md2">
							<div class="col-md1 simpleCart_shelfItem">
								<a href="single.html"> <img class="img-responsive"
									src="images/pi4.png" alt="" />
								</a>
								<h3>
									<a href="single.html">Shirt</a>
								</h3>
								<div class="price">
									<h5 class="item_price">$300</h5>
									<input type="submit" value="Add To Cart">
									<div class="clearfix"></div>
								</div>

							</div>
						</div>
					</form>
					<form action="index?id=1004" method="post">
						<div class="col-md-3 col-md2">
							<div class="col-md1 simpleCart_shelfItem">
								<a href="single.html"> <img class="img-responsive"
									src="images/pi1.png" alt="" />
								</a>
								<h3>
									<a href="single.html">Tops</a>
								</h3>
								<div class="price">
									<h5 class="item_price">$300</h5>
									<input type="submit" value="Add To Cart">
									<div class="clearfix"></div>
								</div>

							</div>
						</div>
					</form>
					<form action="index?id=1005" method="post">
						<div class="clearfix"></div>
				</div>
				<div class="content-top1">
					<div class="col-md-3 col-md2">
						<div class="col-md1 simpleCart_shelfItem">
							<a href="single.html"> <img class="img-responsive"
								src="images/pi3.png" alt="" />
							</a>
							<h3>
								<a href="single.html">Shirt</a>
							</h3>
							<div class="price">
								<h5 class="item_price">$300</h5>
								<input type="submit" value="Add To Cart">
								<div class="clearfix"></div>
							</div>

						</div>
					</div>
					</form>
					<form action="index?id=1006" method="post">
						<div class="col-md-3 col-md2">
							<div class="col-md1 simpleCart_shelfItem">
								<a href="single.html"> <img class="img-responsive"
									src="images/pi5.png" alt="" />
								</a>
								<h3>
									<a href="single.html">T-Shirt</a>
								</h3>
								<div class="price">
									<h5 class="item_price">$300</h5>
									<input type="submit" value="Add To Cart">
									<div class="clearfix"></div>
								</div>

							</div>
						</div>
					</form>
					<form action="index?id=1007" method="post">
						<div class="col-md-3 col-md2">
							<div class="col-md1 simpleCart_shelfItem">
								<a href="single.html"> <img class="img-responsive"
									src="images/pi6.png" alt="" />
								</a>
								<h3>
									<a href="single.html">Jeans</a>
								</h3>
								<div class="price">
									<h5 class="item_price">$300</h5>
									<input type="submit" value="Add To Cart">
									<div class="clearfix"></div>
								</div>

							</div>
						</div>
					</form>
					<form action="index?id=1008" method="post">
						<div class="col-md-3 col-md2">
							<div class="col-md1 simpleCart_shelfItem">
								<a href="single.html"> <img class="img-responsive"
									src="images/pi7.png" alt="" />
								</a>
								<h3>
									<a href="single.html">Tops</a>
								</h3>
								<div class="price">
									<h5 class="item_price">$300</h5>
									<input type="submit" value="Add To Cart">
									<div class="clearfix"></div>
								</div>

							</div>
						</div>
					</form>
					<div class="clearfix"></div>
				</div>
			</div>
		</div>
	</div>
	<!--//content-->
	<!--footer-->
	<div class="footer">
		<div class="container">
			<div class="footer-top">
				<div class="col-md-4 top-footer1">
					<h2>Newsletter</h2>
					<form>
						<input type="text" value="" onFocus="this.value='';"
							onBlur="if (this.value == '') {this.value ='';}"> <input
							type="submit" value="SUBSCRIBE">
					</form>
				</div>
				<div class="clearfix"></div>
			</div>
		</div>
		<div class="footer-bottom">
			<div class="container">
				<div class="col-sm-3 footer-bottom-cate">
					<h6>Categories</h6>
					<ul>
						<li><a href="#">Curabitur sapien</a></li>
						<li><a href="#">Dignissim purus</a></li>
						<li><a href="#">Tempus pretium</a></li>
						<li><a href="#">Dignissim neque</a></li>
						<li><a href="#">Ornared id aliquet</a></li>

					</ul>
				</div>
				<div class="col-sm-3 footer-bottom-cate">
					<h6>Feature Projects</h6>
					<ul>
						<li><a href="#">Curabitur sapien</a></li>
						<li><a href="#">Dignissim purus</a></li>
						<li><a href="#">Tempus pretium</a></li>
						<li><a href="#">Dignissim neque</a></li>
						<li><a href="#">Ornared id aliquet</a></li>

					</ul>
				</div>
				<div class="col-sm-3 footer-bottom-cate">
					<h6>Top Brands</h6>
					<ul>
						<li><a href="#">Curabitur sapien</a></li>
						<li><a href="#">Dignissim purus</a></li>
						<li><a href="#">Tempus pretium</a></li>
						<li><a href="#">Dignissim neque</a></li>
						<li><a href="#">Ornared id aliquet</a></li>
						<li><a href="#">Ultrices id du</a></li>
						<li><a href="#">Commodo sit</a></li>

					</ul>
				</div>
				<div class="col-sm-3 footer-bottom-cate cate-bottom">
					<h6>Our Address</h6>
					<ul>
						<li>Aliquam metus dui.</li>
						<li>orci, ornareidquet</li>
						<li>ut,DUI.</li>
						<li>nisi, dignissim</li>
						<li>gravida at.</li>
						<li class="phone">PH : 6985792466</li>
					</ul>
				</div>
				<div class="clearfix"></div>
				<p class="footer-class">
					Copyright &copy; 2015.Company name All rights reserved.<a
						target="_blank" href="http://www.cssmoban.com/">&#x7F51;&#x9875;&#x6A21;&#x677F;</a>
				</p>
			</div>
		</div>
	</div>
	<!--//footer-->
</body>
</html>