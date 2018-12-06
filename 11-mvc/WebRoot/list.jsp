<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
   
  </head>
  
  <script type="text/javascript">
//创建异步对象
function createXMLHttpRequest() {
	try {
		return new XMLHttpRequest();//大多数浏览器
	} catch (e) {
		try {
			return ActvieXObject("Msxml2.XMLHTTP");//IE6.0
		} catch (e) {
			try {
				return ActvieXObject("Microsoft.XMLHTTP");//IE5.5及更早版本	
			} catch (e) {
				alert("哥们儿，您用的是什么浏览器啊？");
				throw e;
			}
		}
	}
}


window.onload = function() {
	// 获取文本框，给它的失去焦点事件注册监听
	var userEle = document.getElementById("usernameEle");
	userEle.onblur = function() {
		//1.得到异步对象
		var xmlHttp = createXMLHttpRequest();
		//2.打开连接
		xmlHttp.open("post", "/11-mvc/MyFileUploadServlet", true);
		//3.设置请求头：Content-Type
		xmlHttp.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
		//4.发送请求，给出请求体
		//userEle.value 的值 为 文本框 中输入的东西
		xmlHttp.send("username=" +userEle.value);
		
		
		
		//5.给xmlHttp的onreadystatechange事件注册监听
		xmlHttp.onreadystatechange = function() {
			if(xmlHttp.readyState == 4 && xmlHttp.status == 200) {//双重判断
				
				
				//获取服务器的响应，判断是否为1
				var text = xmlHttp.responseText;
				// 是：获取span，添加内容：“用户名已被注册”
				var span = document.getElementById("errorSpan");
				if(text == "1") {
					//得到span元素
					span.innerHTML = "用户名已被注册！";
				} else {
					span.innerHTML = "";
				}
			}
		};
	};
};
</script>
  </head>
  
  <body>
<h1>演示用户名是否被注册</h1>
<form action="" method="post">
用户名：<input type="text" name="username" id="usernameEle"/><span id="errorSpan"></span><br/>
密　码：<input type="password" name="password"/><br/>
<input type="submit" value="注册"/>
</form>
  </body>
</html>
