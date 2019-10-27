<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<link rel="stylesheet" href="css/bootstrap.min.css"/>
<!-- Favicon  -->
<link rel="icon" href="img/core-img/favicon.ico">

<!-- Core Style CSS -->
<link rel="stylesheet" href="css/core-style.css">
<link rel="stylesheet" href="style.css">
<!-- Header Area Start -->
<header class="header-area clearfix">
    <!-- Close Icon -->
    <div class="nav-close">
        <i class="fa fa-close" aria-hidden="true"></i>
    </div>
    <!-- Logo -->
    <div class="logo">
        <a href="index"><img src="img/core-img/logo.png" alt=""></a>
        <% if(session.getAttribute("userId")!=null){ %>
        <div class="join">
            <%--로그아웃은 스프링 시큐리티 로직 탐--%>
            <a>${userId}님 환영합니다.</a>
            <a href="logout"><button type="button"  alt="로그아웃버튼"/>로그아웃</a>
        </div>
        <% }else{%>
        <div class="join">
            <a href="login"><button type="button"  alt="로그인버튼"/>로그인</a>
            <a href="join"><button type="button"  alt="회원가입버튼"/>회원가입</a>
        </div>
        <% }%>
    </div>



    <!-- Amado Nav -->
    <nav class="amado-nav">
        <ul>
            <li class="active"><a href="index">Home</a></li>
            <li><a href="shop">Shop</a></li>
            <li><a href="product-details">Product</a></li>
            <li><a href="cart">Cart</a></li>
            <li><a href="checkout">Checkout</a></li>
        </ul>
    </nav>
    <!-- Button Group -->
    <div class="amado-btn-group mt-30 mb-100">
        <a href="#" class="btn amado-btn mb-15">%Discount%</a>
        <a href="#" class="btn amado-btn active">New this week</a>
    </div>
    <!-- Cart Menu -->
    <div class="cart-fav-search mb-100">
        <a href="cart.html" class="cart-nav"><img src="img/core-img/cart.png" alt=""> Cart <span>(0)</span></a>
        <a href="#" class="fav-nav"><img src="img/core-img/favorites.png" alt=""> Favourite</a>
        <a href="#" class="search-nav"><img src="img/core-img/search.png" alt=""> Search</a>
    </div>
    <!-- Social Button -->
    <div class="social-info d-flex justify-content-between">
        <a href="#"><i class="fa fa-pinterest" aria-hidden="true"></i></a>
        <a href="#"><i class="fa fa-instagram" aria-hidden="true"></i></a>
        <a href="#"><i class="fa fa-facebook" aria-hidden="true"></i></a>
        <a href="#"><i class="fa fa-twitter" aria-hidden="true"></i></a>
    </div>

</header>

