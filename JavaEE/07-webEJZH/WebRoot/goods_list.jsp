
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>码蚁商城</title>
    <!--链接外部样式-->
    <link rel="stylesheet" href="style/index.css">
    <link rel="stylesheet" href="style/pageStyle.css">
</head>
<body>
<!-- 通过jsp指令导入头部 -->
<%@ include file="/header.jsp" %>
<!--热买商品-->
<div id="hot_goods">
    <h3 class="hot_goods_title">热卖商品</h3>
    <div class="hot_goods_body">
        <ul>
       <%--  <%
        	//从域当中取数据
        	List<Goods> allGoods =  (List<Goods>)request.getAttribute("allGoods");
        	System.out.println(allGoods);
        	if(allGoods != null){
        		
        		//取出每一个商品展示
        		for( Goods pro : allGoods){
        			
        			out.write("<li>");
        			out.write("<a href=''>");
        			out.write(" <img src='images/pimages/"+pro.getImage()+"' alt=''>");
        			out.write(" <p>"+pro.getName()+"</p>");
        			out.write("<i class='yuan'>￥</i><span class='price'>"+pro.getPrice()+"</span>");
        			out.write("</a>");
        			out.write("</li>");
        		}
        		
        	}else{
        		out.write("没有商品");
        	}
          %> --%>
            
           
           <c:if test="${empty allGoods }">
           		没有商品
           </c:if>
           
           <c:forEach items="${allGoods }" var="goods">
           		<li>
                	<a href="">
                    	<!-- <img src="images/pimages/${goods.image }" alt=""> -->
                    	<p>${goods.name }</p>
                    	<i class="yuan">￥</i><span class="price">${goods.price }</span>
                	</a>
            	</li>
           </c:forEach> 
            
        </ul>
    </div>
    <!--分页-->
    <div id="page" class="page_div"></div>
</div>

<%@ include file="/footer.jsp" %>

<script src="http://www.jq22.com/jquery/jquery-1.10.2.js"></script>
<script type="text/javascript" src="js/paging.js"></script>
<script>
    //分页
    $("#page").paging({
        pageNo:5,
        totalPage: 10,
        totalSize: 300,
        callback: function(num) {
            alert(num);
        }
    })
</script>

</body>



</html>


