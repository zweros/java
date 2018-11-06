### 声明部分 
格式： `<%!      %>`
作用：定义成员变量的属性和方法

#### Scriptlets
格式： `<% %>`
作用： 用来输出内容

### Demo 
```java
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>Hello JSP</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

	<%! //声明部分    定义成员变量的属性和方法
		int a = 1, b = 2;//定义两个变量
	 %>
	 <%!
	 	public String print(){
	 		String str = "szxy  宿州学院最美";
	 		return str;
	 	}
	  %>
  </head>
  
  <body>
  	<%//JSP Scriptlets  用来输出内容
  		out.println("a+b= "+a+b+"<br/>");
  		out.println(print());
  	 %><br/>


  </body>
</html>


```
