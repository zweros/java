<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@  taglib  prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>    
<%
   String path = request.getContextPath();
   String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<base href="<%=basePath %>">
 <meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
 <title>购物车页面</title>
<link rel="stylesheet" href="css/fullCar.css" />
<link rel="stylesheet" href="css/common.css"/>
<link rel="stylesheet" href="css/style.css" />
<link rel="stylesheet" href="css/icons.css" />
<link rel="stylesheet" href="css/table.css" />
<style>
     .mainCenter{
	   margin-top:20px;
	 }
	 .caozuo{
		 display:block;
		 height:45px;
		 width:120px;
		 background-color:#c5131e;
		 color:white;
		 text-align:center;
		 line-height:45px;
		 font-size:15px;
		 float:right;
		 margin-right:20px;
		 margin-left:20px;
	}
	
</style>
</head>
<body>
	<!--顶部-->
	<div class="top">
    	<div class="top_center">
            <ul class="top_bars">
            	<li><a href="#">退出</a>|</li>
                <li><a href="#">我的订单<span class="jt_down"></span></a>|</li>
                <li><a href="#">关注杰普<span class="jt_down"></span></a>|</li>
                <li><a href="#">网站导航<span class="jt_down"></span></a></li>
            </ul>
        </div>
    </div>
    <!--头部-->
    <div class="header3">
    	<a href="index.html"><img src="images/logo.png"  class="oneImg"></a>
        <div class="h3_right">
        	<img src="images/play_01.png" alt="">
        </div>
       
    </div>
<!--中间部分div-->
<div class="empty">
	<div class="peisong"><pre>全部商品  2 </pre></div>
	<div class="mainCenter" >
		<div class="allCheck">
			<p class="leftM">商品</p>
			<p class="rightM">单价(元)</p>
			<p class="leftM">数量</p>
			<p class="leftM">小计(元)</p>
			<p class="leftM">操作</p>
		</div>
		

		${sessionScope.cart.getOrderlines() }
		<div class="mainPro">
			<c:forEach items="${sessionScope.cart.getOrderlines() }" begin="0" var="orderLine">
			<div class="bb">
				<img src="images/1.png" >
				 <span>
                   ${orderLine.book.name }
                    <br>
                </span>
                <div class="mm">
                	<span>¥${orderLine.book.price }</span>
                </div>
                <span style="margin-top:40px;">${orderLine.num }</span>
                <div class="ri">¥${orderLine.book.price * orderLine.num }元</div>
               	<div class="righ">
               		 <div class="rig">
					 <a href="loginAfter/dropLineServlet?id=${orderLine.book.id }">删除</a></div>
               	</div>
			</div>	
		</c:forEach>
			</div>
			
		</div>
		<div class="allButtom">
			 <a href="loginAfter/confirm.jsp" class="caozuo" >去结算</a>
			<span>已选择<font>${sessionScope.cart.getSize() }
			</font>件商品&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			   总价(不含运费)：<font>¥${sessionScope.cart.getCost() }元</font></span>
		</div>
	</div>
</div>
     <!--脚部-->
    <div class="footer3">
    	<div class="f3_top">
        	<div class="f3_center">
                <div class="ts1">品目繁多 愉悦购物</div>
                <div class="ts2">正品保障 天天低价</div>
                <div class="ts3">极速物流 特色定制</div>
                <div class="ts4">优质服务 以客为尊</div>
            </div>
        </div>
        <div class="f3_middle">
        	<ul class="f3_center">
            	<li class="f3_mi_li01">
                	<h1>购物指南</h1>
                    <p>常见问题</p>
                    <p>找回密码</p>
                    <p>会员介绍</p>
                    <p>购物演示</p>
                </li>
                <li class="f3_mi_li01">
                	<h1>配送方式</h1>
                    <p>常见问题</p>
                    <p>找回密码</p>
                    <p>会员介绍</p>
                    <p>购物演示</p>
                </li>
                <li class="f3_mi_li01">
                	<h1>支付方式</h1>
                    <p>常见问题</p>
                    <p>找回密码</p>
                    <p>会员介绍</p>
                    <p>购物演示</p>
                </li>
                <li class="f3_mi_li01">
                	<h1>售后服务</h1>
                    <p>常见问题</p>
                    <p>找回密码</p>
                    <p>会员介绍</p>
                    <p>购物演示</p>
                </li>
                <li class="f3_mi_li01">
                	<h1>服务保障</h1>
                    <p>常见问题</p>
                    <p>找回密码</p>
                    <p>会员介绍</p>
                    <p>购物演示</p>
                </li>
                <li class="f3_mi_li06">
                	<h1>客服中心</h1>
                    <img src="images/qrcode_jprj.jpg" width="80px" height="80px">
                    <p>抢红包、疑问咨询、优惠活动</p>
                </li>
            </ul>
        </div>
         <div class="f3_bottom">
        	<p class="f3_links">
                <a href="#">关于我们</a>|
                <a href="#">联系我们</a>|
                <a href="#">友情链接</a>|
                <a href="#">供货商入驻</a> 
           	</p>
            <p>沪ICP备14033591号-8 杰普软件briup.com版权所有 杰普软件科技有限公司 </p>
          	<img src="images/police.png">
        </div>
    </div>
</body>
</html>