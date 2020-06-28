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
	    	align:center; 
	    	height : 200px; 
	    	top : 50px;
	  		left : 450px;
	  		width : 1000px; /*1040*/
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
	    height : 5px;
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
			<a href = "student_main.jsp"><img width = 400px height = 150px src = "res/dgl.png"></a>
			<center> 
				<div>
				<img width = 45px height = 45px src = "res/user.png">
				<%=(String)session.getAttribute("name") %> 님 환영합니다.
				 </div>
			</center>
			
	<form style="display:none"><br><br>
	    <button type="button" id = "bbb1" onclick="location.href='student_main.jsp' ">출석하기</button>
          <button type="button" id = "bbb3" onclick="location.href='student_class.jsp' ">수강 과목 출석 확인</button><!--<br><br><br><br>  -->
          <button type="button" id = "bbb4" onclick="location.href='student_info.jsp' ">마이페이지</button>
          <button name = "s" type="button" id = "bbb5" onclick="location.href='index.jsp' ">로그아웃</button>
	</form>
	</div>
		
	
		<%
		String student_college=(String)session.getAttribute("college");
		String student_major=(String)session.getAttribute("major");
		int student_year=(int)session.getAttribute("year");
		String student_id=(String)session.getAttribute("id");
		String student_name =(String)session.getAttribute("name");
		
		//String class_id = request.getParameter("class_id");
		String class_id = (String)session.getAttribute("class_id");
		String class_name = (String)session.getAttribute("class_name");
		int []week1=new int[40]; int []week2=new int[40]; int []week3=new int[40]; int []week4=new int[40]; int []week5=new int[40]; int []week6=new int[40];
		int []week7=new int[40]; int []week8=new int[40]; int []week9=new int[40]; int []week10=new int[40]; int []week11=new int[40]; int []week12=new int[40];
		
		int i = 0;
		
		Class.forName("org.mariadb.jdbc.Driver");
		
		try{
			// 보안상 연결 정보 비공개
			String url = "jdbc:mariadb://"; 
			Connection conn = DriverManager.getConnection(url, "", ""); 
		
			Statement stmt = conn.createStatement();
			// select student.student_college, student.student_major, student.student_year,  student.student_id, student.student_name, attendance.attend_week1, attendance.attend_week2, attendance.attend_week3,attendance.attend_week4,attendance.attend_week5,attendance.attend_week6,attendance.attend_week7,attendance.attend_week8,attendance.attend_week9,attendance.attend_week10,attendance.attend_week11,attendance.attend_week12 from attendance, student 
			//where attendance.student_id = "2017113506" and student.student_id = "2017113506" and attendance.class_id = "CSE2022-02";
			String strSQL = "select attendance.attend_week1, attendance.attend_week2, attendance.attend_week3,attendance.attend_week4,attendance.attend_week5,attendance.attend_week6,attendance.attend_week7,attendance.attend_week8,attendance.attend_week9,attendance.attend_week10,attendance.attend_week11,attendance.attend_week12 from attendance, student"  
					 + " where attendance.student_id = ? and student.student_id = ? and attendance.class_id = ?";
			
			PreparedStatement pstmt = conn.prepareStatement(strSQL); 
			pstmt.setString(1,student_id);
		    pstmt.setString(2,student_id);
		    pstmt.setString(3, class_id);
		    
		    ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				week1[i] = rs.getInt(1);
				week2[i] = rs.getInt(2);
				week3[i] = rs.getInt(3);
				week4[i] = rs.getInt(4);
				week5[i] = rs.getInt(5);
				week6[i] = rs.getInt(6);
				week7[i] = rs.getInt(7);
				week8[i] = rs.getInt(8);
				week9[i] = rs.getInt(9);
				week10[i] = rs.getInt(10);
				week11[i] = rs.getInt(11);
				week12[i] = rs.getInt(12);
				i++;
				}	
			%>
			
		 <%} 
		catch (SQLException e) { e.printStackTrace(); }
		 %>
		<div class="form_caja">
		<center><font size="6" color="black"><b><%=(String)session.getAttribute("name")%> 학생의 <%=class_name%> 출결 현황</b></font></center>
			<table align="center" style="overflow:auto">
				<thead>
					<tr>
						<td>소속단과대학</td>
						<td>소속학과</td>
						<td>학년</td>
						<td>학번</td>
						<td>이름</td>
						<td>주차</td>
						<td>출결</td>
						
					</tr>
				</thead>
				<tbody>
				<% for(int k=0;k<i;k++){
				
				%>
				
				
					<tr>
					<td><%=student_college%></td>
						<td><%=student_major %></td>
						<td><%=student_year %></td>
						<td><%=student_id %></td>
						<td><%=student_name %></td>
						<td>1주차</td>
						<% if(week1[k]==0) { %>
						<td>결석</td>
						<%} else if(week1[k]==1) { %>
						<td>출석</td>
				<%}%>
					</tr>
					<tr>
						<td><%=student_college%></td>
						<td><%=student_major %></td>
						<td><%=student_year %></td>
						<td><%=student_id %></td>
						<td><%=student_name %></td>
						<td>2주차</td>
						<% if(week2[k]==0) { %>
						<td>결석</td> 
						<%} else if(week2[k]==1) { %>
						<td>출석</td>
				<%}%>
					</tr>
					<tr>
							<td><%=student_college%></td>
						<td><%=student_major %></td>
						<td><%=student_year %></td>
						<td><%=student_id %></td>
						<td><%=student_name %></td>
						<td>3주차</td>
						<% if(week3[k]==0) { %>
						<td>결석</td>
						<%} else if(week3[k]==1) { %>
						<td>출석</td>
				<%}%>
					</tr>
					<tr>
							<td><%=student_college%></td>
						<td><%=student_major %></td>
						<td><%=student_year %></td>
						<td><%=student_id %></td>
						<td><%=student_name %></td>
						<td>4주차</td>
						<% if(week4[k]==0) { %>
						<td>결석</td>
						<%} else if(week4[k]==1) { %>
						<td>출석</td>
				<%}%>
					</tr>
					<tr>
							<td><%=student_college%></td>
						<td><%=student_major %></td>
						<td><%=student_year %></td>
						<td><%=student_id %></td>
						<td><%=student_name %></td>
						<td>5주차</td>
						<% if(week5[k]==0) { %>
						<td>결석</td>
						<%} else if(week5[k]==1) { %>
						<td>출석</td>
				<%}%>
					</tr>
					<tr>
							<td><%=student_college%></td>
						<td><%=student_major %></td>
						<td><%=student_year %></td>
						<td><%=student_id %></td>
						<td><%=student_name %></td>
						<td>6주차</td>
						<% if(week6[k]==0) { %>
						<td>결석</td>
						<%} else if(week6[k]==1) { %>
						<td>출석</td>
				<%}%>
					</tr>
					<tr>
							<td><%=student_college%></td>
						<td><%=student_major %></td>
						<td><%=student_year %></td>
						<td><%=student_id %></td>
						<td><%=student_name %></td>
						<td>7주차</td>
						<% if(week7[k]==0) { %>
						<td>결석</td>
						<%} else if(week7[k]==1) { %>
						<td>출석</td>
				<%}%>
					</tr>
					<tr>
							<td><%=student_college%></td>
						<td><%=student_major %></td>
						<td><%=student_year %></td>
						<td><%=student_id %></td>
						<td><%=student_name %></td>
						<td>8주차</td>
						<% if(week8[k]==0) { %>
						<td>결석</td>
						<%} else if(week8[k]==1) { %>
						<td>출석</td>
				<%}%>
					</tr>
					<tr>
							<td><%=student_college%></td>
						<td><%=student_major %></td>
						<td><%=student_year %></td>
						<td><%=student_id %></td>
						<td><%=student_name %></td>
						<td>9주차</td>
						<% if(week9[k]==0) { %>
						<td>결석</td>
						<%} else if(week9[k]==1) { %>
						<td>출석</td>
				<%}%>
					</tr>
					<tr>
							<td><%=student_college%></td>
						<td><%=student_major %></td>
						<td><%=student_year %></td>
						<td><%=student_id %></td>
						<td><%=student_name %></td>
						<td>10주차</td>
						<% if(week10[k]==0) { %>
						<td>결석</td>
						<%} else if(week10[k]==1) { %>
						<td>출석</td>
				<%}%>
					</tr>
					<tr>
							<td><%=student_college%></td>
						<td><%=student_major %></td>
						<td><%=student_year %></td>
						<td><%=student_id %></td>
						<td><%=student_name %></td>
						<td>11주차</td>
						<% if(week11[k]==0) { %>
						<td>결석</td>
						<%} else if(week11[k]==1) { %>
						<td>출석</td>
				<%}%>
					</tr>
					<tr>
							<td><%=student_college%></td>
						<td><%=student_major %></td>
						<td><%=student_year %></td>
						<td><%=student_id %></td>
						<td><%=student_name %></td>
						<td>12주차</td>
						<% if(week12[k]==0) { %>
						<td>결석</td>
						<%} else if(week12[k]==1) { %>
						<td>출석</td>
				<%}%>
	
				<%} %> }
			</table>
		</div>
		</body>
		</html>