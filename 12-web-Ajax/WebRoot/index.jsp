<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
   
  </head>
  <!-- 这是局部刷新 -->
  <script type="text/javascript">
  window.onload= function(){
  var btn = document.getElementById("btn");
  btn.onclick = function(){
  var h = document.getElementById("h1");
  h.innerHTML= "山东菏泽曹县"
  }
  }
  
  </script>
  <body>
   
<button id="btn">点我啊</button>
<h1 id="h1"></h1>


<form action="/12-web-Ajax/Aservlet" method="post"><input type="submit" value="提交">
</form>

  </body>
</html>
