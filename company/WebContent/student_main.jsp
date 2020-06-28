<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>동국대학교 서울캠퍼스 출석 WebSite</title>
<script src="https://code.jquery.com/jquery-3.1.1.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://rawgit.com/schmich/instascan-builds/master/instascan.min.js"></script>
<%@ page import="java.sql.*"  %>
 <%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>

 
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

<video id="preview"></video>
<script type="text/javascript">
    
	var test =0;
    var key = 6;
    var index;
    var string;
    var string2;
    var string3;
    var now;   // 현재시간 저장
    
    var class_id;
    var week_num;
    
    let scanner = new Instascan.Scanner({ video: document.getElementById('preview'), scanPeriod: 4, mirror:false} );

    scanner.addListener('scan', function (content) {
         
      string = content;
      week_num = string.substr(0,1); // 주차
      class_id = string.substr(1,10); // 학수번호
      string = string.substr(11,string.length); // 랜덤값
      
      let today = new Date(); // 현재 시간
      let hour = Number(today.getHours()) * 3600;   // 시
      let minute = Number(today.getMinutes()) * 60;   // 분
      let seconds = Number(today.getSeconds()); // 초
      now = hour + minute + seconds; // 현재 시간 초로 저장
      
      string2 = String(Number(string.substring(0,2)) - key);
      string3 = String.fromCharCode(string2);
      for(index = 2; index <= string.length - 2; index += 2){
        string2 = String(Number(string.substring(index, index + 2)) - key);
        string3 += String.fromCharCode(string2);
      }
      
      string3 = Number(string3)+5;
     // alert("string 3 : " + string3 + " now : " +now);
     
      if(now <= string3){ // 5초안에 출석했다면,
         scanner.stop();   // 스캐너와 카메라 모두 끄고 출석 완료 메시지 출력
                
        // alert("출석 완료!");
         
         var student_id = "<%=(String)session.getAttribute("id")%>";
        
         attendance_Start(student_id, class_id, week_num);
        
         
         /*
         *
         * 민선아 학수번호는 class_id 라는 변수에 string으로 저장되어있고
         * 주차는 week_num 이라는 변수에 string으로 저장되어있어
         * 이 부분에서 DB에 접근할 수 있어야 함... db에서 출석 체크
         *
         */

      }
      else
         alert("출석 미인증! 다시 시도하세요.");
      //content = parseInt(content);
     // alert(typeof content); // 자료형 확인
      
    });

    Instascan.Camera.getCameras().then(function (cameras) {
      
      if (cameras.length > 0) { 
         // default 카메라를 후면으로 정하기 위한 조건문
         
         if(cameras[0].name.match(/back/i)){
          // 이벤트 리스너(버튼 클릭시 스캐너 키기)
            button.onclick = function(){   
               scanner.start(cameras[0]);
             };
         }
         else if(cameras[1].name.match(/back/i)){
          // 이벤트 리스너(버튼 클릭시 스캐너 키기)
            button.onclick = function(){
               scanner.start(cameras[1]);
             };
            //scanner.start(cameras[1]);
         }
      } else {
        console.error('No cameras found.');
      }

    });</script>


<div style="border :1px solid none; width : 400px; height : 150px;" class="form">
  <a href = "student_main.jsp"><img width = 400px height = 150px src = "res/dgl.png"></a>
   <center>
   <div>
      <img width = 45px height = 45px src = "res/user.png">
      <%=(String)session.getAttribute("name") %>님 환영합니다.
   </div>
   </center>
      <form style="display:none"><br><br>
          <button type="button" id = "bbb1" onclick="location.href='student_main.jsp' ">출석하기</button>
          <button type="button" id = "bbb3" onclick="location.href='student_class.jsp' ">수강 과목 출석 확인</button><!--<br><br><br><br>  -->
          <button type="button" id = "bbb4" onclick="location.href='student_info.jsp' ">마이페이지</button>
          <button name = "s" type="button" id = "bbb5" onclick="location.href='index.jsp' ">로그아웃</button>
       </form>
</div>

<div class="fixed">
<%
	Date nowTime = new Date();
	SimpleDateFormat sf = new SimpleDateFormat("yyyy년 MM월 dd일 a hh:mm:ss");
%>
<br><br><br><br><br>
<b><h2><%=(String)session.getAttribute("major")%> <%=(String)session.getAttribute("id")%> <%=(String)session.getAttribute("name")%>님 반갑습니다.</h2>

<br> <h3>:: 현재 날짜와 시간은 <%= sf.format(nowTime) %> 입니다. ::</h3><br>
<h4>아래의 버튼을 눌러 QR 코드를 찍어 출석을 진행하세요.</h4><br>
 </b>
 
 <button id = "button" style="width:100pt;height:60pt;" href="#">출석시작</button><br>

</div>
</body>
<script>
function attendance_Start(student_id, class_id, week_num) {
   
      alert(student_id + " 학생의 " + class_id + " 강의가 출석처리 되었습니다.");
     
      //alert("/company/BoardServlet?student_id=" + student_id + "&week_num=" + week_num + "&class_id=" + class_id);   
     
      location.href = "/company/BoardServlet?student_id=" + student_id + "&week_num=" + week_num + "&class_id=" + class_id;  
   }

</script>

</html>