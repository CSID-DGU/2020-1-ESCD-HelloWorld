/*
 * 
 * 동국대학교 베팅형 수강신청
 * BoardServlet.java
 * 
 */

package prac.board.web;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

public class MemberDao {
	
	private Connection getConnection() {
		DataSource ds = null; Connection con = null;
		try {
			
			 Class.forName("org.mariadb.jdbc.Driver");
		// 보안상 연결 정보 비공개
		con = DriverManager.getConnection("jdbc:mariadb://");
		
		}catch(Exception e) {
			e.printStackTrace(); 
		} 
		
		return con; }
	
	private void closeConnection (Connection con) { 
		if(con!=null) { try { con.close(); }catch(Exception e) {} } }
	
	public String student_getpw(String id) {
			
			
			String pw = ""; Connection con = null; 
			try {
				con = getConnection();  
				String sql = "select student_pwd from student where student_id=?";
				//select student_pwd from student where student_id='2017113506';
				PreparedStatement pstmt = con.prepareStatement(sql); 
				pstmt.setString(1, id); //2017113506으로 세팅
				ResultSet rs = pstmt.executeQuery();
				if(rs.next()) { 
					
					pw = rs.getString("student_pwd"); 
					
					}else {
						String message="아이디가 없습니다";return message;
					} }catch(Exception e) {
						
				throw new RuntimeException("MemberDAO.getPassword : " + e.getMessage()); 
				}finally { closeConnection(con); } 
			return pw; 
		}
	
	
	
	public String professor_getpw(String id) {
		
		String pw = ""; Connection con = null; 
		try {
			con = getConnection(); 
			String sql = "select professor_pwd from professor where professor_id=?";
			//select student_pwd from student where student_id='2017113506';
			PreparedStatement pstmt = con.prepareStatement(sql); 
			pstmt.setString(1, id); //2017113506으로 세팅
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) { 
				
				pw = rs.getString("professor_pwd"); 
				//pw = rs.getString(1); 
				}else {
					String message="아이디가 없습니다";return message;
				} }catch(Exception e) {
					
			throw new RuntimeException("MemberDAO.getPassword : " + e.getMessage()); 
			}finally { closeConnection(con); } 
		return pw; 
	}
	
	public int student_getyear(String id) {
		int year=0;
		
		 Connection con = null; try {
				con = getConnection(); 
				String sql = "select student_year from student where student_id=?";
				PreparedStatement pstmt = con.prepareStatement(sql); 
				pstmt.setString(1, id);
				ResultSet rs = pstmt.executeQuery();
				if(rs.next()) { 
					year = rs.getInt("student_year"); 
					}else {
					throw new RuntimeException("아이디가 존재하지 않습니다"); } }catch(Exception e) {
						
				throw new RuntimeException("MemberDAO.getmajor : " + e.getMessage()); 
				}finally { closeConnection(con); } 
			return year; 
	}
		
	public String student_getmajor(String id) {
		String major="";
		
		 Connection con = null; try {
				con = getConnection(); 
				String sql = "select student_major from student where student_id=?";
				PreparedStatement pstmt = con.prepareStatement(sql); 
				pstmt.setString(1, id);
				ResultSet rs = pstmt.executeQuery();
				if(rs.next()) { 
					major = rs.getString("student_major"); 
					}else {
					throw new RuntimeException("아이디가 존재하지 않습니다"); } }catch(Exception e) {
						
				throw new RuntimeException("MemberDAO.getmajor : " + e.getMessage()); 
				}finally { closeConnection(con); } 
			return major; 
	}
	
	public String professor_getmajor(String id) {
		String major="";
		
		 Connection con = null; try {
				con = getConnection(); 
				String sql = "select professor_major from professor where professor_id=?";
				PreparedStatement pstmt = con.prepareStatement(sql); 
				pstmt.setString(1, id);
				ResultSet rs = pstmt.executeQuery();
				if(rs.next()) { 
					major = rs.getString("professor_major"); 
					}else {
					throw new RuntimeException("아이디가 존재하지 않습니다"); } }catch(Exception e) {
						
				throw new RuntimeException("MemberDAO.getmajor : " + e.getMessage()); 
				}finally { closeConnection(con); } 
			return major; 
	}
	
	public String student_getname(String id) {
		String name="";
		 Connection con = null; try {
				con = getConnection(); 
				String sql = "select student_name from student where student_id=?";
				PreparedStatement pstmt = con.prepareStatement(sql); 
				pstmt.setString(1, id);
				ResultSet rs = pstmt.executeQuery();
				if(rs.next()) { 
					name = rs.getString("student_name"); 
					}else {
					throw new RuntimeException("아이디가 존재하지 않습니다"); } }catch(Exception e) {
						
				throw new RuntimeException("MemberDAO.getname : " + e.getMessage()); 
				}finally { closeConnection(con); } 
			return name; 
	}
	
	public String professor_getname(String id) {
		String name="";
		 Connection con = null; try {
				con = getConnection(); 
				String sql = "select professor_name from professor where professor_id=?";
				PreparedStatement pstmt = con.prepareStatement(sql); 
				pstmt.setString(1, id);
				ResultSet rs = pstmt.executeQuery();
				if(rs.next()) { 
					name = rs.getString("professor_name"); 
					}else {
					throw new RuntimeException("아이디가 존재하지 않습니다"); } }catch(Exception e) {
						
				throw new RuntimeException("MemberDAO.getname : " + e.getMessage()); 
				}finally { closeConnection(con); } 
			return name; 
	}
	
	public String student_getcollege(String id) {
		String college="";
		
		 Connection con = null; try {
				con = getConnection(); 
				String sql = "select student_college from student where student_id=?";
				PreparedStatement pstmt = con.prepareStatement(sql); 
				pstmt.setString(1, id);
				ResultSet rs = pstmt.executeQuery();
				if(rs.next()) { 
					college = rs.getString("student_college"); 
					}else {
					throw new RuntimeException("아이디가 존재하지 않습니다"); } }catch(Exception e) {
						
				throw new RuntimeException("MemberDAO.getcollege : " + e.getMessage()); 
				}finally { closeConnection(con); } 
			return college; 
	}
	
	public String professor_getcollege(String id) {
		String college="";
		
		 Connection con = null; try {
				con = getConnection(); 
				String sql = "select professor_college from professor where professor_id=?";
				PreparedStatement pstmt = con.prepareStatement(sql); 
				pstmt.setString(1, id);
				ResultSet rs = pstmt.executeQuery();
				if(rs.next()) { 
					college = rs.getString("professor_college"); 
					}else {
					throw new RuntimeException("아이디가 존재하지 않습니다"); } }catch(Exception e) {
						
				throw new RuntimeException("MemberDAO.getcollege : " + e.getMessage()); 
				}finally { closeConnection(con); } 
			return college; 
	}
	
	}

