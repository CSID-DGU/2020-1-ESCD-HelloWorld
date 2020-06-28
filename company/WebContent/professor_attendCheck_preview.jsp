<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"  %>
<%@ page import="javax.naming.InitialContext"  %>
<%@ page import="javax.naming.InitialContext"  %>
<%@ page import="javax.naming.Context"  %>
<%@ page import="javax.naming.InitialContext"  %>
<%@ page import="javax.servlet.http.HttpSession"  %>
<%@ page import="javax.sql.DataSource"  %>

<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
	<title>동국대학교 서울캠퍼스 출석 WebSite</title>
	<script src="https://code.jquery.com/jquery-3.1.1.js"></script>
<script>

$(document).ready(function(){

$("form").show("slow");

$("#tip").hover(function(){
  $("#div2").show("slow");
  $("#tip").css('background-color', '#0067A3');

},function(){
  $("#div2").slideUp("slow");
  $("#tip").css('background-color', '#50bcdf');
});

$("#bbb1").hover(function(){	  
	  $("#bbb1").css('background-color', '#0067A3');
	},function(){	 
	  $("#bbb1").css('background-color', '#50bcdf');
	});
	
$("#bbb2").hover(function(){	  
	  $("#bbb2").css('background-color', '#0067A3');
	},function(){	 
	  $("#bbb2").css('background-color', '#50bcdf');
	});
	
$("#bbb3").hover(function(){	  
	  $("#bbb3").css('background-color', '#0067A3');
	},function(){	 
	  $("#bbb3").css('background-color', '#50bcdf');
	});
	
$("#bbb4").hover(function(){	  
	  $("#bbb4").css('background-color', '#0067A3');
	},function(){	 
	  $("#bbb4").css('background-color', '#50bcdf');
	});
	
$("#bbb5").hover(function(){	  
	  $("#bbb5").css('background-color', '#0067A3');
	},function(){	 
	  $("#bbb5").css('background-color', '#50bcdf');
	});
});

</script>
	
<style type = "text/css">
		/* 배경화면을 꽉차게 설정 */
	    html {
			background: url("res/background.png") no-repeat center center fixed;
	        -webkit-background-size: cover;
	        -moz-background-size: cover;
	        -o-background-size: cover;
	        background-size: cover;
		}
	       
		div.fixed {
			-webkit-background-size: cover;
	        -moz-background-size: cover;
	        -o-background-size: cover;
	        background-size: cover;
	  		position : fixed;
	  		top : 50px;
	  		left : 450px;
	 		width : 1040px;
	  		height : 600px;
	  		border : none;
	  		background-color : #D4F4FA;
	  		padding-top: 8px;
	        padding-bottom: 15px;
	        padding-left : 8px;
	        padding-right : 8px;
			border-radius: 15px;    
	        -moz-border-radius: 15px;    
	        -webkit-border-radius: 15px;
		}
	
		.form {
		  position: relative;
		  z-index: 1;
		}
	
		.form button {
		  font-family: "Roboto", sans-serif;
		  /* 배경색 */
		  background: #50bcdf ;
		  /* 아래로 글자가사리지지 않음 */
		  width: 100%;
		  border: 0;
		  padding: 15px;
		  /*글씨체 색깔 */
		  color: #FFFFFF;
		  font-size: 14px;
		}
		
		.form_caja {
			width: 500px;
	        padding-top: 8px;
	        padding-bottom: 8px; /*15*/
	        padding-left : 8px;
	        padding-right : 8px;
	        margin: 0 auto 20px auto;
	        background-color: #D4F4FA;    /*#f0ffff*/
	        border-radius: 15px;    
	        -moz-border-radius: 15px;    
	        -webkit-border-radius: 15px;
	        color: #f0ffff;
	        position:fixed center;
	        overflow:auto; /*hidden->auto*/
	        position : fixed;
	        top : 50px;
			left : 450px;
	  		width : 1040px;
	  		height : 600px;
	  		border :3px solid #FFFFFF;
	    }
	 
	    table { 
	    	background-color : #FFFFFF; /*#f0ffff*/
	    	color : #000000; 
	    	align: center; 
	    	height : 200px; 
	    	top : 50px;
	  		left : 450px;
	  		width : 500px; /*1040*/
	  		height : 300px; /*600*/
	  		
	    }
	    
	    thead { 
	    	background-color: #a0efff; 
	    	color :#000000; 
	    	padding:4px; 
	    	/*line-height:30px */
	    	border :1px solid #000000;
	    }
	    
	    th, td {
	    height : 4px;
		    padding: 10px; 
		    text-align: center;
		    border :1px solid #000000;
	  	}
	  	
	  /*  tbody tr:nth-child(even) { background: #FBF8EF }
	    tbody tr:nth-child(odd) { background: #FFF }*/
	</style>
	
	
	</head>
	
	<body>
	
		<div style="border :1px solid none; width : 400px; height : 150px;" class="form">
			<a href = "professor_class.jsp"><img width = 400px height = 150px src = "res/dgl.png"></a>
			<center> 
				<div>
				<img width = 45px height = 45px src = "res/user.png">
				<%=(String)session.getAttribute("name") %> 교수님 환영합니다.
				 </div>
			</center>
			
			
			
<form style="display:none"><br><br>
	      	<button type="button" id = "bbb2" onclick="location.href='professor_class.jsp' ">개설 과목 확인</button> <!--  여기서 qr코드 생성 -->
	      	<button type="button" id = "bbb4" onclick="location.href='professor_info.jsp' ">마이페이지</button>
	      	<button name = "s" type="button" id = "bbb5" onclick="location.href='index.jsp' ">로그아웃</button>
	    </form>
		</div>

		<div class="form_caja">
		<center><font size="6" color="black"><b><%=(String)session.getAttribute("class_name") %> 주차별 출석 관리</b></font></center><Br> <!--  원래 c_name -->
		<center>
		<table>
		<thead><tr><td>주차</td><td>관리</td></tr></thead> 
		<tbody>
		
		<tr><td>1주차</td>
		<td><form class="login-form" action="/company/BoardServlet?week_num=1" method="post">
		<button type="submit" value="week1" name ="submit" >출석 관리</button></form></td></tr>
		
		<tr><td>2주차</td>
		<td><form class="login-form" action="/company/BoardServlet?week_num=2" method="post">
		<button type="submit" value="week2" name ="submit">출석 관리</button>	</form></td></tr>
		
		<tr><td>3주차</td>
		<td><form class="login-form" action="/company/BoardServlet?week_num=3" method="post">
		<button type="submit" value="week3" name ="submit">출석 관리</button>	</form></td></tr>
		
		<tr><td>4주차</td>
		<td><form class="login-form" action="/company/BoardServlet?week_num=4" method="post">
		<button type="submit" value="week4" name ="submit">출석 관리</button>	</form></td></tr>
		
		<tr><td>5주차</td>
		<td><form class="login-form" action="/company/BoardServlet?week_num=5" method="post">
		<button type="submit" value="week5" name ="submit">출석 관리</button></form></td></tr>
		
		<tr><td>6주차</td>
		<td><form class="login-form" action="/company/BoardServlet?week_num=6" method="post">
		<button type="submit" value="week6" name ="submit">출석 관리</button>	</form></td></tr>
		
		<tr><td>7주차</td>
		<td><form class="login-form" action="/company/BoardServlet?week_num=7" method="post">
		<button type="submit" value="week7" name ="submit">출석 관리</button>	</form></td></tr>
		
		<tr><td>8주차</td>
		<td><form class="login-form" action="/company/BoardServlet?week_num=8" method="post">
		<button type="submit" value="week8" name ="submit">출석 관리</button>	</form></td></tr>
		
		<tr><td>9주차</td>
		<td><form class="login-form" action="/company/BoardServlet?week_num=9" method="post">
		<button type="submit" value="week9" name ="submit">출석 관리</button>	</form></td></tr>
		
		<tr><td>10주차</td>
		<td><form class="login-form" action="/company/BoardServlet?week_num=10" method="post">
		<button type="submit" value="week10" name ="submit">출석 관리</button></form>
		
		<tr><td>11주차</td>
		<td><form class="login-form" action="/company/BoardServlet?week_num=11" method="post">
		<button type="submit" value="week11" name ="submit">출석 관리</button></form>
		
		<tr><td>12주차</td>
		<td><form class="login-form" action="/company/BoardServlet?week_num=12" method="post">
		<button type="submit" value="week12" name ="submit">출석 관리</button></form>
		
		
		</tbody>
		</table></center>
		</div>
		</body>
		</html>
		
		
		
	
		
		