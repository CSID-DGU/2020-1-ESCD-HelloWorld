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
	</style>
	
	<script src="https://davidshimjs.github.io/qrcodejs/qrcode.js"></script>
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
	
		<%
		
		String professor_id=(String)session.getAttribute("id");
		String c_name=(String)session.getAttribute("class_name");
		String c_id = (String)session.getAttribute("class_id");
		int week_num = (int)session.getAttribute("week_num");
		
		session.setAttribute("class_id", c_id);

		String []student_college=new String[40];
		String []student_major=new String[40];
		int []student_year=new int[40];
		String []student_id=new String[40];
		String []student_name=new String[40];
		int []student_attendance=new int[40];
		int i = 0;
		
		Class.forName("org.mariadb.jdbc.Driver");
		
		try{
			
			String url = "jdbc:mariadb://27.96.131.64:3306/attend_test?characterEncoding=UTF-8"; 
			Connection conn = DriverManager.getConnection(url, "root", "T7u=LAU3ic2+q"); 
			
			Statement stmt = conn.createStatement();
			String strSQL = "select student_college, student_major, student_year, student.student_id, student_name, attend_week2"
					+ " from student, enroll, class, attendance"
					+ " where enroll.student_id = student.student_id"
					+ " and student.student_id = attendance.student_id"
					+ " and enroll.class_id = class.class_id"
					+ " and class.class_id = attendance.class_id"
					+ " and enroll.class_id = ?";
				
			PreparedStatement pstmt = conn.prepareStatement(strSQL); 
			 pstmt.setString(1,c_id);
		
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				student_college[i]=rs.getString(1);
				student_major[i]=rs.getString(2);
				 student_year[i]=rs.getInt(3);
				 student_id[i]=rs.getString(4);
				 student_name[i]=rs.getString(5);
				 student_attendance[i]=rs.getInt(6);
				i++;
				}	
			%>
			
		 <%} 
		catch (SQLException e) { e.printStackTrace(); }
		 %>
		<div class="form_caja">
			
		<center><font size="6" color="black"><b><%=c_name%> 2주차 출석부</b></font></center>
		
		<button id="main" style="float: right;">출석 시작</button>	<!-- 출석 시작 버튼 -->

		  <form class="login-form" action="/company/BoardServlet" method="post"  onclick="return save_alert();" name ="arrayParam"  >
		<button value ="week2_save" type="submit" name="submit" style="float: right;"  id="save">저장</button><Br>
	
	</form>
		
			<table align="center" style="overflow:hidden; position:realative" >
				<thead>
					<tr>
						<td>소속단과대학</td>
						<td>소속학과</td>
						<td>학년</td>
						<td>학번</td>
						<td>이름</td>
						<td>출결</td>
						
					</tr>
				</thead>
				
				<% for(int k=0;k<i;k++){%>
					<tr>
						<td><%=student_college[k] %></td>
						<td><%=student_major[k] %></td>
						<td><%=student_year[k] %></td>
						<td><%=student_id[k] %></td>
						<td><%=student_name[k] %></td>
						<% if(student_attendance[k]==0) { %>
						<td><input type="checkbox" value="0" name="attend" ></input></td>
						<%} else if(student_attendance[k]==1) { %>
						<td><input type="checkbox" value="1" checked="checked" name="attend"></input></td>
							
						</form>
						<%}%>
					</tr>
				<%} %> }
			</table>
			<div id="output" style="width:350px; height:350px; padding-left: 250px"></div>	<!-- QR 코드 이미지 영역 -->
		</div>

	<script type="text/javascript">
	var index;
	var string;
	var string2;
	var string3;
	var code;
	
	var id = '<%=c_id%>';
	var week = '<%=week_num%>';
	
	function sleep(t){ // 슬립 함수 정의
	  return new Promise(resolve => setTimeout(resolve, t));
	}
	
	var i =0;
	
	main.onclick = function(){
		let qrcode = new QRCode("output", {
		    text: "https://donggukattendance.com/",
		    width: 550,
		    height: 550,
		    colorDark : "#000000",
		    colorLight : "#ffffff",
		    correctLevel : QRCode.CorrectLevel.H
		});
		qrcode.clear();
		
		showCode = setInterval(function(){ // 무한 반복하면서 코드 호출
		
		  (async function(){
		    document.getElementById("countdown").innerHTML = "<span style='color: red;'>새 QR 코드</span>";
		    await sleep(500);
		    document.getElementById("countdown").innerHTML = "<span style='color: black;'>새 QR 코드</span>";
		    await sleep(500);
		    document.getElementById("countdown").innerHTML = "<span style='color: red;'>새 QR 코드</span>";
		    await sleep(500);
		    document.getElementById("countdown").innerHTML = "<span style='color: black;'>새 QR 코드</span>";
		    document.getElementById("countdown").innerHTML = "";
		  })();
		
		
		  // 새 QR코드
		let today = new Date(); // 현재 시간
		let hour = parseInt(today.getHours()) * 3600;
		let minute = parseInt(today.getMinutes()) * 60;
		let seconds = parseInt(today.getSeconds()); // 초
		
		var test = hour + minute + seconds;
		//var test = "qqlasfbjk" + test;
		
		var key = 6;
		
		//qrcode.makeCode(test); //
		
		test = String(test);
		
		// 시저 암호 -> 암호화.. key값은 일단 default로 주는거로..
		string = String(test.charCodeAt(0) + key);
		for(index = 1; index < test.length; index++){
		  string += String(test.charCodeAt(index) + key);
		}
		
		code = week + id + string;
		qrcode.makeCode(code);
		
		i++;
		
		if(i == 100) // 10분간 출석 후 종료
		  clearInterval(showCode);
		
		save.onclick = function(){
			clearInterval(showCode);
		};
		
		}, 5000);
		
		qrcode.clear();
	};
	

</script>

</body>
		<script>
	function save_alert() {
		
		
		var arrayParam = new Array();
		var tag = document.arrayParam;
		tag.action = "/company/BoardServlet?";// c_id="+c_id+"&"
		var chkbox = document.getElementsByName('attend');
		//alert(chkbox.length);
		
		for(var i=0 ; i<chkbox.length ; i++) { 
			if(chkbox[i].checked) { arrayParam[i] = 1; } 
			else { arrayParam[i] = 0; } 
			//alert(arrayParam[i]);
			if(i==0) {tag.action = tag.action + "arrayParam" + i+"="+arrayParam[i];}
			else if(i==chkbox.length) {tag.action = tag.action + "&arrayParam" + i+"="+arrayParam[i];}
			else {tag.action = tag.action  + "&arrayParam" + i+"="+arrayParam[i];}
			}
        alert("출석 정보가 정상적으로 저장되었습니다.");
       
	}
			
    </script>
		</html>
		