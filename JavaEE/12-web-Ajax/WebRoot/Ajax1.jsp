<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
   
  </head>
  
  <script type="text/javascript">
  <!--  这是  get 请求 方式--!>
       //创建异步对象
       function createXMLHttpRequest(){
       try{
       return new XMLHttpRequest(); //大多浏览器
       } catch(e){
       
       try {
       return ActvieObject("Msxml2.XMLHTTP");//ie6
       }catch(e){
             try {
              return ActvieObject("Microsoft.XMLHTTP");//ie 5.5一下
             }   catch(e){
             alert("哥们，你用的是什么浏览器");
             throw e;
             }
       }
       }
       }
  
  
  
  
  window.onload= function(){
  var btn = document.getElementById("btn");
  btn.onclick= function(){
  /*
		ajax四步操作，得到服务器的响应
		把响应结果显示到h1元素中
		*/
		/*
		1. 得到异步对象 
		*/
		var xmlHttp = createXMLHttpRequest();
		/*
		2. 打开与服务器的连接
		  * 指定请求方式
		  * 指定请求的URL
		  * 指定是否为异步请求
		*/
		xmlHttp.open("GET", "/12-web-Ajax/Aservlet", true);
		/*
		3. 发送请求
		*/
 
  xmlHttp.send(null);
  
  
  /*  给异步对象的onreadystatechange事件注册监听器
    4   双重循环 判断 1 是否 为 4  和 状态码 是否 为200 
   */
  xmlHttp.onreadystatechange = function(){
  
  if(xmlHttp.readyState ==4 &&  xmlHttp.status==200){
  //获取 服务器 的相应
  var text = xmlHttp.responseText;
  //获取h1 元素
  var ht = document.getElementById("h1");
  ht.innerHTML=text;
  
  
  }
  };
  
  
  };
  };
  </script>
  <body>
   
<button id="btn">点击这里</button>

<h1 id="h1"></h1>
  </body>
</html>
