package prac.board.web;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Enumeration;
import java.io.*; 

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.*;

/**
 * Servlet implementation class BoardServlet
 */

@WebServlet("/BoardServlet")
public class BoardServlet extends HttpServlet {
   private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

   /**
    * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
    */
   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

      
      String s=request.getParameter("s");
      EnrollDao edao=new EnrollDao();
      HttpSession session = request.getSession(); 
      if(s==null) {
         String student_id = request.getParameter("student_id");
         String class_id = request.getParameter("class_id");
         String week_num = request.getParameter("week_num");
         
         session.setAttribute("student_id", student_id);
         session.setAttribute("class_id", class_id);
         session.setAttribute("week_num", week_num);
         
         edao.qrcode_attendance(student_id, class_id, week_num);
         
         String url="/student_main.jsp";
      
         RequestDispatcher disp = request.getRequestDispatcher(url); 
         disp.forward(request, response); 
         
      }
      else if(s.equals("logout")) { 
               session.invalidate();
               RequestDispatcher disp = request.getRequestDispatcher("/index.jsp"); 
               disp.forward(request, response); 
       }   
   }























   /**
    * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
    */
   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      
      request.setCharacterEncoding("utf-8");
      HttpSession session = request.getSession(); 
      String v=request.getParameter("submit");
      MemberDao dao = new MemberDao(); 
      EnrollDao edao=new EnrollDao();

      String id = request.getParameter("id"); 
      String password = request.getParameter("pw");



//

try
{
    MessageDigest di = MessageDigest.getInstance("MD5");
    di.update(new String(password).getBytes());
    byte[] md5Code = di.digest();
    StringBuffer sb = new StringBuffer();
    for (int i=0;i<md5Code.length;i++) {
        String md5Char = String.format("%02x", 0xff&(char)md5Code[i]);
        sb.append(md5Char);
    }
    //System.out.println(sb.toString());
    password = sb.toString();


}catch (NoSuchAlgorithmException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
   }




//





       if(v.equals("login")) {

         String url="";
         
         String student_realpw=dao.student_getpw(id); 
         String professor_realpw = dao.professor_getpw(id);
         
         if(student_realpw.equals(password)) {
            request.setAttribute("message", id + "님 환영합니다.");
            String name = dao.student_getname(id);
            int year = dao.student_getyear(id);
            String college = dao.student_getcollege(id);
            String major = dao.student_getmajor(id);
            session.setAttribute("major", major);
            session.setAttribute("year", year);
            session.setAttribute("name", name);
            session.setAttribute("college", college);
            session.setAttribute("id", id);
            session.setAttribute("pw", password);
            
            url="/student_main.jsp";
            
         }else if(professor_realpw.equals(password)) {
            request.setAttribute("message", id + "님 환영합니다.");
            String name = dao.professor_getname(id);
            String college = dao.professor_getcollege(id);
            String major = dao.professor_getmajor(id);
            session.setAttribute("major", major);
            session.setAttribute("name", name);
            session.setAttribute("college", college);
            session.setAttribute("id", id);
            session.setAttribute("pw", password);
            
            url="/professor_class.jsp";
         }
         
         else if(student_realpw.equals("아이디가 없습니다") || professor_realpw.equals("아이디가 없습니다") ) {
         
            url="/index.jsp";
         }
         
         else {
            System.out.println("실행되었습니다");
            session.setAttribute("message", "password가 일치하지 않습니다");
            
            url="/index.jsp";
         }
         
         RequestDispatcher disp = request.getRequestDispatcher(url); 
         disp.forward(request, response); 
      }
       
       if(v.equals("attend")) {
          
         String c_id = request.getParameter("class_id");
         String c_name = request.getParameter("class_name");
      
         session.setAttribute("class_name", c_name);
         session.setAttribute("class_id", c_id);
   
         String url="/professor_attendCheck_preview.jsp";
          
         RequestDispatcher disp = request.getRequestDispatcher(url); 
         disp.forward(request, response); 
       }
       
       if(v.equals("stu_attend")) {

            String class_id = request.getParameter("class_id");
            String class_name = request.getParameter("class_name");
             
            session.setAttribute("class_id", class_id);
            session.setAttribute("class_name", class_name);
         
            String url="/student_attend_check.jsp";
             
             RequestDispatcher disp = request.getRequestDispatcher(url); 
             disp.forward(request, response); 
          }
       
       if(v.equals("week1")) {

         int week_num = Integer.parseInt(request.getParameter("week_num"));
          
         session.setAttribute("week_num", week_num);
         
         String url="/professor_attendCheck_week1.jsp";
          
          RequestDispatcher disp = request.getRequestDispatcher(url); 
          disp.forward(request, response); 
       }
       
       if(v.equals("week2")) {

         int week_num = Integer.parseInt(request.getParameter("week_num"));
          
         session.setAttribute("week_num", week_num);
         
         String url="/professor_attendCheck_week2.jsp";
          
         RequestDispatcher disp = request.getRequestDispatcher(url); 
         disp.forward(request, response); 
      }
       
       if(v.equals("week3")) {

         int week_num = Integer.parseInt(request.getParameter("week_num"));
          
         session.setAttribute("week_num", week_num);
         
         String url="/professor_attendCheck_week3.jsp";
          
         RequestDispatcher disp = request.getRequestDispatcher(url); 
         disp.forward(request, response); 
      }
       
       if(v.equals("week4")) {

         int week_num = Integer.parseInt(request.getParameter("week_num"));
          
         session.setAttribute("week_num", week_num);
         
         String url="/professor_attendCheck_week4.jsp";
          
          RequestDispatcher disp = request.getRequestDispatcher(url); 
          disp.forward(request, response); 
       }
       
       if(v.equals("week5")) {

         int week_num = Integer.parseInt(request.getParameter("week_num"));
          
         session.setAttribute("week_num", week_num);
         
         String url="/professor_attendCheck_week5.jsp";
          
          RequestDispatcher disp = request.getRequestDispatcher(url); 
          disp.forward(request, response); 
      }
       
       if(v.equals("week6")) {

         int week_num = Integer.parseInt(request.getParameter("week_num"));
          
         session.setAttribute("week_num", week_num);
         
         String url="/professor_attendCheck_week6.jsp";
          
          RequestDispatcher disp = request.getRequestDispatcher(url); 
          disp.forward(request, response); 
      }
       
       if(v.equals("week7")) {

         int week_num = Integer.parseInt(request.getParameter("week_num"));
          
         session.setAttribute("week_num", week_num);
         
         String url="/professor_attendCheck_week7.jsp";
          
         RequestDispatcher disp = request.getRequestDispatcher(url); 
         disp.forward(request, response); 
      }
       
       if(v.equals("week8")) {

         int week_num = Integer.parseInt(request.getParameter("week_num"));
          
         session.setAttribute("week_num", week_num);
         
         String url="/professor_attendCheck_week8.jsp";
          
         RequestDispatcher disp = request.getRequestDispatcher(url); 
         disp.forward(request, response); 
      }
       
       if(v.equals("week9")) {

         int week_num = Integer.parseInt(request.getParameter("week_num"));
          
         session.setAttribute("week_num", week_num);
         
         String url="/professor_attendCheck_week9.jsp";
          
          RequestDispatcher disp = request.getRequestDispatcher(url); 
          disp.forward(request, response); 
      }
       
       if(v.equals("week10")) {

         int week_num = Integer.parseInt(request.getParameter("week_num"));
          
         session.setAttribute("week_num", week_num);
         
         String url="/professor_attendCheck_week10.jsp";
          
          RequestDispatcher disp = request.getRequestDispatcher(url); 
          disp.forward(request, response); 
      }
       
       if(v.equals("week11")) {

         int week_num = Integer.parseInt(request.getParameter("week_num"));
          
         session.setAttribute("week_num", week_num);
         
         String url="/professor_attendCheck_week11.jsp";
          
         RequestDispatcher disp = request.getRequestDispatcher(url); 
         disp.forward(request, response); 
      }
       
       if(v.equals("week12")) {

         int week_num = Integer.parseInt(request.getParameter("week_num"));
          
         session.setAttribute("week_num", week_num);
         
         String url="/professor_attendCheck_week12.jsp";
          
         RequestDispatcher disp = request.getRequestDispatcher(url); 
         disp.forward(request, response); 
      }
      

       if(v.equals("week1_save")) { // 저장한다.
          
          String class_id = (String)session.getAttribute("class_id");
          session.setAttribute("class_id", class_id);
         
          Enumeration param = request.getParameterNames();
           String strParam = "";
           while(param.hasMoreElements()) {
              String name = (String)param.nextElement();
               String value = request.getParameter(name);
               strParam += name + "=" + value + "&";
           }
          String URL = request.getRequestURL() + "?" + strParam;
              
          int idx = URL.indexOf("&submit");
          URL = URL.substring(0, idx);
          
          String[] temp;
          String now_address = request.getServletPath();
          
         String params = URL.substring(URL.indexOf("?") + 1);
         String []real_params = params.split("&");
            
         ArrayList<String> al = new ArrayList<String>();
             
         for(int i = 0; i < real_params.length; i++) {
            temp = real_params[i].split("=");   
               al.add(temp[1]);
             }

          String[] arrayParams = new String[al.size()];
          int size=0;
             
          for(String tempor : al){
            arrayParams[size++] = tempor;
          }

           edao.week1_save(class_id, arrayParams);
           String url="/professor_attendCheck_week1.jsp";
           RequestDispatcher disp = request.getRequestDispatcher(url); 
           disp.forward(request, response);  
       }
       
       if(v.equals("week2_save")) { // 저장한다.
          
          String class_id = (String)session.getAttribute("class_id");
          session.setAttribute("class_id", class_id);
         
          Enumeration param = request.getParameterNames();
           String strParam = "";
           while(param.hasMoreElements()) {
              String name = (String)param.nextElement();
               String value = request.getParameter(name);
               strParam += name + "=" + value + "&";
              }
          String URL = request.getRequestURL() + "?" + strParam;
              
          int idx = URL.indexOf("&submit");
          URL = URL.substring(0, idx);
          
          String[] temp;
          String now_address = request.getServletPath();
          
         String params = URL.substring(URL.indexOf("?") + 1);
         String []real_params = params.split("&");
            
         ArrayList<String> al = new ArrayList<String>();
             
         for(int i = 0; i < real_params.length; i++) {
            temp = real_params[i].split("=");   
               al.add(temp[1]);
             }

          String[] arrayParams = new String[al.size()];
          int size=0;
             
          for(String tempor : al){
            arrayParams[size++] = tempor;
          }

         for(int i = 0; i < arrayParams.length; i++) {
            System.out.println("i : " + arrayParams[i]);
         }
         
           edao.week2_save(class_id, arrayParams);
           String url="/professor_attendCheck_week2.jsp";
           RequestDispatcher disp = request.getRequestDispatcher(url); 
           disp.forward(request, response);  
       }

   if(v.equals("week3_save")) { // 저장한다.
       
       String class_id = (String)session.getAttribute("class_id");
       session.setAttribute("class_id", class_id);
      
       Enumeration param = request.getParameterNames();
        String strParam = "";
        while(param.hasMoreElements()) {
          String name = (String)param.nextElement();
           String value = request.getParameter(name);
           strParam += name + "=" + value + "&";
          }
      String URL = request.getRequestURL() + "?" + strParam;

      int idx = URL.indexOf("&submit");
      URL = URL.substring(0, idx);
       
      String[] temp;
      String now_address = request.getServletPath();
      
      String params = URL.substring(URL.indexOf("?") + 1);
      String []real_params = params.split("&");
         
      ArrayList<String> al = new ArrayList<String>();
          
      for(int i = 0; i < real_params.length; i++) {
         temp = real_params[i].split("=");   
            al.add(temp[1]);
      }
   
       String[] arrayParams = new String[al.size()];
       int size=0;
          
       for(String tempor : al){
         arrayParams[size++] = tempor;
       }
   
        for(int i = 0; i < arrayParams.length; i++) {
           System.out.println("i : " + arrayParams[i]);
        }
   
        edao.week3_save(class_id, arrayParams);
        String url="/professor_attendCheck_week3.jsp";
        RequestDispatcher disp = request.getRequestDispatcher(url); 
        disp.forward(request, response);  
   }
   
   if(v.equals("week4_save")) { // 저장한다.
       
       String class_id = (String)session.getAttribute("class_id");
       session.setAttribute("class_id", class_id);
      
       Enumeration param = request.getParameterNames();
       String strParam = "";
       while(param.hasMoreElements()) {
          String name = (String)param.nextElement();
           String value = request.getParameter(name);
           strParam += name + "=" + value + "&";
          }
      String URL = request.getRequestURL() + "?" + strParam;
          
      System.out.println(URL);
          
      int idx = URL.indexOf("&submit");
      URL = URL.substring(0, idx);
       
      String[] temp;
      String now_address = request.getServletPath();
      
      String params = URL.substring(URL.indexOf("?") + 1);
      String []real_params = params.split("&");
      System.out.println(real_params.length);
         
      ArrayList<String> al = new ArrayList<String>();
          
      for(int i = 0; i < real_params.length; i++) {
         temp = real_params[i].split("=");   
            al.add(temp[1]);
          }
   
          String[] arrayParams = new String[al.size()];
          int size=0;
          
          for(String tempor : al){
            arrayParams[size++] = tempor;
          }
   
        for(int i = 0; i < arrayParams.length; i++) {
           System.out.println("i : " + arrayParams[i]);
        }
   
        edao.week4_save(class_id, arrayParams);
        String url="/professor_attendCheck_week4.jsp";
        RequestDispatcher disp = request.getRequestDispatcher(url); 
        disp.forward(request, response);  
   }
   
   if(v.equals("week5_save")) { // 저장한다.
       
       String class_id = (String)session.getAttribute("class_id");
       session.setAttribute("class_id", class_id);
      
       Enumeration param = request.getParameterNames();
       String strParam = "";
       while(param.hasMoreElements()) {
          String name = (String)param.nextElement();
           String value = request.getParameter(name);
           strParam += name + "=" + value + "&";
          }
      String URL = request.getRequestURL() + "?" + strParam;
          
      System.out.println(URL);
          
      int idx = URL.indexOf("&submit");
      URL = URL.substring(0, idx);
       
      String[] temp;
      String now_address = request.getServletPath();
      
      String params = URL.substring(URL.indexOf("?") + 1);
      String []real_params = params.split("&");
      System.out.println(real_params.length);
         
      ArrayList<String> al = new ArrayList<String>();
          
      for(int i = 0; i < real_params.length; i++) {
         temp = real_params[i].split("=");   
            al.add(temp[1]);
          }
   
          String[] arrayParams = new String[al.size()];
          int size=0;
          
          for(String tempor : al){
            arrayParams[size++] = tempor;
          }
   
        for(int i = 0; i < arrayParams.length; i++) {
           System.out.println("i : " + arrayParams[i]);
        }
   
        edao.week5_save(class_id, arrayParams);
        String url="/professor_attendCheck_week5.jsp";
        RequestDispatcher disp = request.getRequestDispatcher(url); 
        disp.forward(request, response);  
   }
   
   if(v.equals("week6_save")) { // 저장한다.
       
       String class_id = (String)session.getAttribute("class_id");
       session.setAttribute("class_id", class_id);
      
       Enumeration param = request.getParameterNames();
       String strParam = "";
       while(param.hasMoreElements()) {
          String name = (String)param.nextElement();
           String value = request.getParameter(name);
           strParam += name + "=" + value + "&";
          }
      String URL = request.getRequestURL() + "?" + strParam;
          
      System.out.println(URL);
          
      int idx = URL.indexOf("&submit");
      URL = URL.substring(0, idx);
       
      String[] temp;
      String now_address = request.getServletPath();
      
      String params = URL.substring(URL.indexOf("?") + 1);
      String []real_params = params.split("&");
      System.out.println(real_params.length);
         
      ArrayList<String> al = new ArrayList<String>();
          
      for(int i = 0; i < real_params.length; i++) {
         temp = real_params[i].split("=");   
            al.add(temp[1]);
          }
   
          String[] arrayParams = new String[al.size()];
          int size=0;
          
          for(String tempor : al){
            arrayParams[size++] = tempor;
          }
   
        for(int i = 0; i < arrayParams.length; i++) {
           System.out.println("i : " + arrayParams[i]);
        }
   
        edao.week6_save(class_id, arrayParams);
        String url="/professor_attendCheck_week6.jsp";
        RequestDispatcher disp = request.getRequestDispatcher(url); 
        disp.forward(request, response);  
   }
   
   if(v.equals("week7_save")) { // 저장한다.
       
       String class_id = (String)session.getAttribute("class_id");
       session.setAttribute("class_id", class_id);
      
       Enumeration param = request.getParameterNames();
       String strParam = "";
       while(param.hasMoreElements()) {
          String name = (String)param.nextElement();
           String value = request.getParameter(name);
           strParam += name + "=" + value + "&";
          }
      String URL = request.getRequestURL() + "?" + strParam;
          
      System.out.println(URL);
          
      int idx = URL.indexOf("&submit");
      URL = URL.substring(0, idx);
       
      String[] temp;
      String now_address = request.getServletPath();
      
      String params = URL.substring(URL.indexOf("?") + 1);
      String []real_params = params.split("&");
      System.out.println(real_params.length);
         
      ArrayList<String> al = new ArrayList<String>();
          
      for(int i = 0; i < real_params.length; i++) {
         temp = real_params[i].split("=");   
            al.add(temp[1]);
          }
   
          String[] arrayParams = new String[al.size()];
          int size=0;
          
          for(String tempor : al){
            arrayParams[size++] = tempor;
          }
   
        for(int i = 0; i < arrayParams.length; i++) {
           System.out.println("i : " + arrayParams[i]);
        }
   
        edao.week7_save(class_id, arrayParams);
        String url="/professor_attendCheck_week7.jsp";
        RequestDispatcher disp = request.getRequestDispatcher(url); 
        disp.forward(request, response);  
   }
   
   if(v.equals("week8_save")) { // 저장한다.
       
       String class_id = (String)session.getAttribute("class_id");
       session.setAttribute("class_id", class_id);
      
       Enumeration param = request.getParameterNames();
       String strParam = "";
       while(param.hasMoreElements()) {
          String name = (String)param.nextElement();
           String value = request.getParameter(name);
           strParam += name + "=" + value + "&";
          }
      String URL = request.getRequestURL() + "?" + strParam;
          
      System.out.println(URL);
          
      int idx = URL.indexOf("&submit");
      URL = URL.substring(0, idx);
       
      String[] temp;
      String now_address = request.getServletPath();
      
      String params = URL.substring(URL.indexOf("?") + 1);
      String []real_params = params.split("&");
      System.out.println(real_params.length);
         
      ArrayList<String> al = new ArrayList<String>();
          
      for(int i = 0; i < real_params.length; i++) {
         temp = real_params[i].split("=");   
            al.add(temp[1]);
          }
   
          String[] arrayParams = new String[al.size()];
          int size=0;
          
          for(String tempor : al){
            arrayParams[size++] = tempor;
          }
   
        for(int i = 0; i < arrayParams.length; i++) {
           System.out.println("i : " + arrayParams[i]);
        }
   
        edao.week8_save(class_id, arrayParams);
        String url="/professor_attendCheck_week8.jsp";
        RequestDispatcher disp = request.getRequestDispatcher(url); 
        disp.forward(request, response);  
   }
   
   if(v.equals("week9_save")) { // 저장한다.
       
       String class_id = (String)session.getAttribute("class_id");
       session.setAttribute("class_id", class_id);
      
       Enumeration param = request.getParameterNames();
       String strParam = "";
       while(param.hasMoreElements()) {
          String name = (String)param.nextElement();
           String value = request.getParameter(name);
           strParam += name + "=" + value + "&";
          }
      String URL = request.getRequestURL() + "?" + strParam;
          
      System.out.println(URL);
          
      int idx = URL.indexOf("&submit");
      URL = URL.substring(0, idx);
       
      String[] temp;
      String now_address = request.getServletPath();
      
      String params = URL.substring(URL.indexOf("?") + 1);
      String []real_params = params.split("&");
      System.out.println(real_params.length);
         
      ArrayList<String> al = new ArrayList<String>();
          
      for(int i = 0; i < real_params.length; i++) {
         temp = real_params[i].split("=");   
            al.add(temp[1]);
          }
   
          String[] arrayParams = new String[al.size()];
          int size=0;
          
          for(String tempor : al){
            arrayParams[size++] = tempor;
          }
   
        for(int i = 0; i < arrayParams.length; i++) {
           System.out.println("i : " + arrayParams[i]);
        }
   
        edao.week9_save(class_id, arrayParams);
        String url="/professor_attendCheck_week9.jsp";
        RequestDispatcher disp = request.getRequestDispatcher(url); 
        disp.forward(request, response);  
   }
   
   if(v.equals("week10_save")) { // 저장한다.
       
       String class_id = (String)session.getAttribute("class_id");
       session.setAttribute("class_id", class_id);
      
       Enumeration param = request.getParameterNames();
       String strParam = "";
       while(param.hasMoreElements()) {
          String name = (String)param.nextElement();
           String value = request.getParameter(name);
           strParam += name + "=" + value + "&";
          }
      String URL = request.getRequestURL() + "?" + strParam;
          
      System.out.println(URL);
          
      int idx = URL.indexOf("&submit");
      URL = URL.substring(0, idx);
       
      String[] temp;
      String now_address = request.getServletPath();
      
      String params = URL.substring(URL.indexOf("?") + 1);
      String []real_params = params.split("&");
      System.out.println(real_params.length);
         
      ArrayList<String> al = new ArrayList<String>();
          
      for(int i = 0; i < real_params.length; i++) {
         temp = real_params[i].split("=");   
            al.add(temp[1]);
          }
   
          String[] arrayParams = new String[al.size()];
          int size=0;
          
          for(String tempor : al){
            arrayParams[size++] = tempor;
          }
   
        for(int i = 0; i < arrayParams.length; i++) {
           System.out.println("i : " + arrayParams[i]);
        }
   
        edao.week10_save(class_id, arrayParams);
        String url="/professor_attendCheck_week10.jsp";
        RequestDispatcher disp = request.getRequestDispatcher(url); 
        disp.forward(request, response);  
   }
   
   if(v.equals("week11_save")) { // 저장한다.
       
       String class_id = (String)session.getAttribute("class_id");
       session.setAttribute("class_id", class_id);
      
       Enumeration param = request.getParameterNames();
       String strParam = "";
       while(param.hasMoreElements()) {
          String name = (String)param.nextElement();
           String value = request.getParameter(name);
           strParam += name + "=" + value + "&";
          }
      String URL = request.getRequestURL() + "?" + strParam;
          
      System.out.println(URL);
          
      int idx = URL.indexOf("&submit");
      URL = URL.substring(0, idx);
       
      String[] temp;
      String now_address = request.getServletPath();
      
      String params = URL.substring(URL.indexOf("?") + 1);
      String []real_params = params.split("&");
      System.out.println(real_params.length);
         
      ArrayList<String> al = new ArrayList<String>();
          
      for(int i = 0; i < real_params.length; i++) {
         temp = real_params[i].split("=");   
            al.add(temp[1]);
          }
   
          String[] arrayParams = new String[al.size()];
          int size=0;
          
          for(String tempor : al){
            arrayParams[size++] = tempor;
          }
   
        for(int i = 0; i < arrayParams.length; i++) {
           System.out.println("i : " + arrayParams[i]);
        }
   
        edao.week11_save(class_id, arrayParams);
        String url="/professor_attendCheck_week11.jsp";
        RequestDispatcher disp = request.getRequestDispatcher(url); 
        disp.forward(request, response);  
   }
   
   if(v.equals("week12_save")) { // 저장한다.
       
       String class_id = (String)session.getAttribute("class_id");
       session.setAttribute("class_id", class_id);
      
       Enumeration param = request.getParameterNames();
       String strParam = "";
       while(param.hasMoreElements()) {
          String name = (String)param.nextElement();
           String value = request.getParameter(name);
           strParam += name + "=" + value + "&";
          }
      String URL = request.getRequestURL() + "?" + strParam;
          
      System.out.println(URL);
          
      int idx = URL.indexOf("&submit");
      URL = URL.substring(0, idx);
       
      String[] temp;
      String now_address = request.getServletPath();
      
      String params = URL.substring(URL.indexOf("?") + 1);
      String []real_params = params.split("&");
      System.out.println(real_params.length);
         
      ArrayList<String> al = new ArrayList<String>();
          
      for(int i = 0; i < real_params.length; i++) {
         temp = real_params[i].split("=");   
            al.add(temp[1]);
          }
   
          String[] arrayParams = new String[al.size()];
          int size=0;
          
          for(String tempor : al){
            arrayParams[size++] = tempor;
          }
   
        for(int i = 0; i < arrayParams.length; i++) {
           System.out.println("i : " + arrayParams[i]);
        }
   
        edao.week12_save(class_id, arrayParams);
        String url="/professor_attendCheck_week12.jsp";
        RequestDispatcher disp = request.getRequestDispatcher(url); 
        disp.forward(request, response);  
   }
           
      }


}