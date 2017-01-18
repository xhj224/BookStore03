<%--
  Created by IntelliJ IDEA.
  User: xhj224
  Date: 2016/12/24
  Time: 13:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">--%>
<%--<html xmlns="http://www.w3.org/1999/xhtml">--%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>Book Store</title>
    <link rel="stylesheet" type="text/css" href="${base}/style/style.css"/>
    <style>
        .ok {
            color: green;
        }

        .error {
            color: red;
            font-weight: bolder;
        }
    </style>
</head>
<body>
<div id="wrap">

    <div class="header">
        <div class="logo">
            <a href="${base}/book/indexAction.do">
                <img src="${base}/images/logo.gif" alt="" title="" border="0"/>
            </a>
        </div>
        <div id="menu">
            <ul>
                <li class="selected"><a href="${base}/book/indexAction.do">首页</a></li>
                <li><a href="${base}/category/1/12/showCategory.do">图书</a></li>
                <li><a href="${base}/book/1000000/1/4/viewBookByCate.do">特价图书</a></li>
                <c:if test="${empty userInfo}" var="userCheck">
                    <li><a href="${base}/user/login.do">登陆</a></li>
                    <li><a href="${base}/user/register.do">注册</a></li>
                </c:if>
                <c:if test="${!userCheck}">
                    <li><a href="${base}/user/exit.do">注销</a></li>
                </c:if>
                <c:if test="${!empty userInfo}" var="userCheck">
                    <li><a href="${base}/order/1/4/orderList.do">我的订单</a></li>
                </c:if>
                <li><a href="${base}/about/aboutAction.do">关于我们</a></li>
                <li><a href="${base}/contact/contactAction.do">联系我们</a></li>
            </ul>
        </div>


    </div>


    <div class="center_content">
        <div class="left_content">
            <div class="title"><span class="title_icon"><img src="${base}/images/bullet1.gif" alt="" title=""/></span>用户注册
            </div>

            <div class="feat_prod_box_details">
                <p class="details">
                    本书店是天创集团旗下的天智教育经营的书店，开业十年来，一直与国内外五百家出版社，近千家发行单位保持着良好的合作关系。以其集文化传播、艺术鉴赏、休闲为一体的崭新经营方式、一流的购书环境及优质的服务，赢得了众多的荣誉，成为华东地区最大的集图书、音像制品、文化用品、快餐、软件开发、广告策划于一体的图书零售企业。
                </p>

                <div class="contact_form">
                    <div class="form_subtitle">创建新用户</div>
                    <form:form modelAttribute="user" name="register" action="${base}/user/register.do" method="post">
                        <div class="form_row">
                            <label class="contact"><strong>用户名:</strong></label>
                            <form:input id="username" type="text" name="username" class="contact_input"
                                        onblur="checkUsername()" title="" path="username"/>
                            <form:errors path="username"/>
                            <span id="usernameHint"></span>
                        </div>

                        <div class="form_row">
                            <label class="contact"><strong>密码:</strong></label>
                            <form:input type="password" name="password" class="contact_input" title="" path="password"/>
                            <form:errors path="password"/>
                        </div>

                        <div class="form_row">
                            <label class="contact"><strong>邮箱:</strong></label>
                            <form:input type="email" name="email" class="contact_input" title="" path="email"/>
                            <form:errors path="email"/>
                        </div>

                        <div class="form_row">
                            <label class="contact"><strong>电话:</strong> </label>
                            <form:input type="tel" name="tel" class="contact_input" title="" path="tel"/>
                            <form:errors path="tel"/>
                        </div>

                        <div class="form_row">
                            <label class="contact"><strong>公司:</strong></label>
                            <form:input type="text" name="comparate" class="contact_input" title="" path="comparate"/>
                            <form:errors path="comparate"/>
                        </div>

                        <div class="form_row">
                            <label class="contact"><strong>地址:</strong></label>
                            <form:input type="text" name="address" class="contact_input" title="" path="address"/>
                            <form:errors path="address"/>
                        </div>

                        <div class="form_row">
                            <div class="terms">
                                <input type="checkbox" name="terms" required title=""/>
                                我同意 <a href="#">terms &amp; conditions</a></div>
                        </div>


                        <div class="form_row">
                            <input type="submit" class="register" value="注册"/>
                        </div>
                    </form:form>
                </div>

            </div>


            <div class="clear"></div>
        </div><!--end of left content-->

        <div class="right_content">

            <div class="languages_box">
                <span class="red">Languages:</span>
                <a href="#"><img src="${base}/images/gb.gif" alt="" title="" border="0"/></a>
                <a href="#"><img src="${base}/images/fr.gif" alt="" title="" border="0"/></a>
                <a href="#"><img src="${base}/images/de.gif" alt="" title="" border="0"/></a>
            </div>
            <div class="currency">
                <span class="red">Currency: </span>
                <a href="#">GBP</a>
                <a href="#">EUR</a>
                <a href="#"><strong>USD</strong></a>
            </div>

            <div class="cart">
                <div class="title">
                  <span class="title_icon">
                    <img src="${base}/images/cart.gif" alt="" title=""/>
                  </span>我的购物车
                </div>
                <c:if test="${!empty userInfo}" var="userCheck">
                    <div class="home_cart_content">
                        <span id="itemCount">${cart.allcount==null?'0':cart.allcount}件商品</span> |
                        <span id="allPrice" class="red">总价:${cart.allPrice==null?'0.0':cart.allPrice}￥</span>
                    </div>
                    <a href="${base}/cart/viewCart.do" class="view_cart">查看购物车</a>
                </c:if>
            </div>

            <div class="title"><span class="title_icon"><img src="${base}/images/bullet3.gif" alt="" title=""/></span>关于我们店
            </div>
            <div class="about">
                <p>
                    <img src="${base}/images/about.gif" alt="" title="" class="right"/>
                    本书店是天创集团旗下的天智教育经营的书店，开业十年来，一直与国内外五百家出版社，近千家发行单位保持着良好的合作关系。以其集文化传播、艺术鉴赏、休闲为一体的崭新经营方式、一流的购书环境及优质的服务，赢得了众多的荣誉，成为华东地区最大的集图书、音像制品、文化用品、快餐、软件开发、广告策划于一体的图书零售企业。
                </p>

            </div>

            <div class="right_box">

                <div class="title"><span class="title_icon"><img src="${base}/images/bullet4.gif" alt=""
                                                                 title=""/></span>推荐图书
                </div>
                <%--@elvariable id="tuijianBook" type="com.tz.online.entity.Pageing"--%>
                <c:forEach items="${tuijianBook.books}" var="book">
                    <div class="new_prod_box">
                        <a href="${base}/book/${book.bookId}/detailBook.do">${book.bookName}</a>
                        <div class="new_prod_bg">
                            <span class="new_icon">
                                <img src="${base}/images/promo_icon.gif" alt="" title=""/>
                            </span>
                            <a href="${base}/book/${book.bookId}/detailBook.do">
                                <img src="${base}/images/${book.imgUrl}" width="60" height="90" alt="" title=""
                                     class="thumb" border="0"/>
                            </a>
                        </div>
                    </div>
                </c:forEach>
            </div>

            <div class="right_box">

                <div class="title"><span class="title_icon"><img src="${base}/images/bullet5.gif" alt=""
                                                                 title=""/></span>图书分类
                </div>

                <ul class="list">
                    <li><a href="#">accesories</a></li>
                    <li><a href="#">books gifts</a></li>
                    <li><a href="#">specials</a></li>
                    <li><a href="#">hollidays gifts</a></li>
                    <li><a href="#">accesories</a></li>
                    <li><a href="#">books gifts</a></li>
                    <li><a href="#">specials</a></li>
                    <li><a href="#">hollidays gifts</a></li>
                    <li><a href="#">accesories</a></li>
                    <li><a href="#">books gifts</a></li>
                    <li><a href="#">specials</a></li>
                </ul>

                <div class="title"><span class="title_icon"><img src="${base}/images/bullet6.gif" alt=""
                                                                 title=""/></span>合作伙伴
                </div>

                <ul class="list">
                    <li><a href="#">accesories</a></li>
                    <li><a href="#">books gifts</a></li>
                    <li><a href="#">specials</a></li>
                    <li><a href="#">hollidays gifts</a></li>
                    <li><a href="#">accesories</a></li>
                    <li><a href="#">books gifts</a></li>
                    <li><a href="#">specials</a></li>
                    <li><a href="#">hollidays gifts</a></li>
                    <li><a href="#">accesories</a></li>
                </ul>

            </div>


        </div><!--end of right content-->


        <div class="clear"></div>
    </div><!--end of center content-->


    <div class="footer">
        <div class="left_footer"><img src="${base}/images/footer_logo.gif" alt="" title=""/><br/> <a
                href="http://csscreme.com"><img src="${base}/images/csscreme.gif" alt="by csscreme.com"
                                                title="by csscreme.com" border="0"/></a></div>
        <div class="right_footer">
            <a href="${base}/book/indexAction.do">home</a>
            <a href="${base}/about/aboutAction.do">about us</a>
            <a href="#">services</a>
            <a href="#">privacy policy</a>
            <a href="${base}/contact/contactAction.do">contact us</a>
        </div>


    </div>


</div>

</body>
<script>
    function AjaxFunction() {
        var xmlHttp;  // 缓存XHR对象便于 Ajax 使用
        try {
            xmlHttp = new XMLHttpRequest(); // Opera 8.0+, Firefox, Safari
        } catch (e) {
            // Internet Explorer Browsers
            try {
                xmlHttp = new ActiveXObject("Msxml2.XMLHTTP");
            } catch (e) {
                try {
                    xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
                } catch (e) {
                    // 错误处理
                    alert("Your browser broke!");
                }
            }
        }
        return xmlHttp;
    }

    function checkUsername() {
        var xmlHttp = AjaxFunction();
        var inputUsername = document.getElementById("username");
        var username = inputUsername.value;
        var url = "${base}/user/" + username + "/validateName.do";
        url = encodeURI(url);
        url = encodeURI(url);
        xmlHttp.open("get", url, true);
        xmlHttp.send();


        // 5。处理来自后台返回的数据

        xmlHttp.onreadystatechange = function () {
            if (xmlHttp.readyState == 4 && xmlHttp.status == 200) {
                // 获取响应中的文本
                var result = xmlHttp.responseText;
                // 判断
                var hint = document.getElementById("usernameHint");
                if (result == 0) {
                    hint.innerHTML = "OK";
                    hint.className = "ok";
                } else if (result == 1) {
                    hint.innerHTML = "用户名 " + username + " 已被注册...";
                    hint.className = "error";
                    inputUsername.value = "";
                    inputUsername.select();
                } else if (result == 2) {
                    hint.innerHTML = "请输入用户名";
                    hint.className = "error";
                    inputUsername.value = "";
                    inputUsername.select();
                }
            }
        }
    }
</script>
</html>
