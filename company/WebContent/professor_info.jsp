<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
<title>동국대학교 서울캠퍼스 출석 Website</title>
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
		  background:  #50bcdf ;
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
		    padding-bottom: 15px;
		    padding-left : 8px;
		    padding-right : 8px;
		    margin: 0 auto 20px auto;
		    background-color: #D4F4FA;    
		    border-radius: 15px;    
		    -moz-border-radius: 15px;    
		    -webkit-border-radius: 15px;
		    color: #f0ffff;
		    position:fixed center;
		    overflow:hidden;
		    position : fixed;
		    top : 50px;
		    left : 450px;
		    width : 1040px;
		    height : 600px;
		    border :3px solid #FFFFFF;
		    }
	 
		table { background-color : #ffffff; color : #000000; align:center; }
	    thead { background-color: #a0eff; color :#000000; padding:4px; line-height:30px; border:1px solid #000000 }
	    th, td { padding: 10px; text-align: center; }
	    /*
	    tbody tr:nth-child(even) { background: #FBF8EF }
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
	
	<div class="fixed">
		<% String id = (String) session.getAttribute("id");
		String name = (String) session.getAttribute("name");
		String pw = (String) session.getAttribute("pw");
		String college = (String) session.getAttribute("college");
		String major = (String) session.getAttribute("major");
		 %>
		 
		<center>
		
	    <h1>마이페이지</h1><br><br><br>
	  로그인 정보 확인<br><br><Br>
		
		<%
		String a=(String)request.getAttribute("message"); 
		if(a!=null) { 
		
		//out.print(a);
		out.print("<script>alert( ' " + a + "' );</script>");
		} %>
		
			
				<table border="1" align="center">
				
				
	 			<tr>
	   					<td class="label" align="center" bgcolor=#50bcdf> 직책 </td>
	    				<td class="field">교수</td>
	     			</tr>
	 				
	 
	 			<tr>
	   					<td class="label" align="center" bgcolor=#a0efff> 소속 단과 대학 </td>
	    				<td class="field"><%=college %></td>
	     			</tr>
	      
	         		<tr>
	          			<td class="label" align="center" bgcolor=#50bcdf> 학과 </td>
	          			<td class="field"><%=major %></td> 
	           		</tr>
	           		
	            <tr> 
	      				<td class="label" align="center" bgcolor=#a0efff > 이름 </td>
	       				<td class="field"><%=name %></td>
	        		</tr>
	            	
	            </table><br>
	            
	     
	       
	<!--  </div>-->           
		<br><br><br><br><br><br><br>
	</div>
	</center>
	

</body>
</html>