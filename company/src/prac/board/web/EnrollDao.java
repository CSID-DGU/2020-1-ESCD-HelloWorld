package prac.board.web;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import java.io.*;

public class EnrollDao {
	
	private Connection getConnection() throws SQLException {
		DataSource ds = null; Connection con = null;
		
		try { 
				 Class.forName("org.mariadb.jdbc.Driver");
				 // 보안상 연결 정보 비공개
				 con = DriverManager.getConnection("jdbc:mariadb://");
		}catch(Exception e) {
			e.printStackTrace(); } return con; }
	
	
	private void closeConnection (Connection con) { 
		if(con!=null) { try { con.close(); }catch(Exception e) {} } }
	
	public String professorTeach(String professor_id) {
		
		String sql;
		String class_id;
		String class_name;
		int class_unit;
	
		ResultSet rs=null;
		PreparedStatement pstmt=null;
		Connection con = null; 
		try {
			con = getConnection();
			
			sql="select class_id, class_name, class_unit from class, professor where class.professor_id = ? and professor.professor_name = class.class_professor";
	
			 pstmt = con.prepareStatement(sql); 
			 pstmt.setString(1,professor_id);

			 rs=pstmt.executeQuery();

			if(rs.next()) {
				class_id=rs.getString("class_id");
				class_name=rs.getString("class_name");
				class_unit=rs.getInt("class_unit");
			}
	}
		
		catch(Exception e) {
			throw new RuntimeException("EnrollDao.professorTeach() :" + e.getMessage()); }finally { closeConnection(con); }
		
		return "";}

	public void week1_save(String class_id, String[] arrayParam) {
		
		
		String sql="";
		Connection con = null;
		ResultSet rs;
		try {
			con =getConnection();
			sql = "select student.student_id" 
			   + " from student, enroll, class, attendance"
		       + " where enroll.student_id = student.student_id"
		       + " and student.student_id = attendance.student_id"
		       + " and enroll.class_id = class.class_id"
		       + " and class.class_id = attendance.class_id"
		      + " and enroll.class_id =?";
			
			PreparedStatement pstmt=con.prepareStatement(sql);
			pstmt.setString(1, class_id);
			rs=pstmt.executeQuery();
			int attend = -1;
			String student_id="";
			
			for(int i = 0; i < arrayParam.length; i++ ) {
			if(rs.next()) {
			student_id=rs.getString(1);
			
			 sql="update attendance set attend_week1="+Integer.parseInt(arrayParam[i])+ " where student_id=? and class_id=?";

				pstmt=con.prepareStatement(sql);
				pstmt.setString(1, student_id);
				pstmt.setString(2, class_id);

				pstmt.executeUpdate();
			}
			}
			
			
			
		} catch (Exception e) {
			throw new RuntimeException("test"+ e.getMessage());
			
			// TODO: handle exception
		}finally {
			closeConnection(con);             
		}
	}
	
public void week2_save(String class_id, String[] arrayParam) {
		
		
		String sql="";
		Connection con = null;
		ResultSet rs;
		try {
			con =getConnection();
			sql = "select student.student_id" 
			   + " from student, enroll, class, attendance"
		       + " where enroll.student_id = student.student_id"
		       + " and student.student_id = attendance.student_id"
		       + " and enroll.class_id = class.class_id"
		       + " and class.class_id = attendance.class_id"
		      + " and enroll.class_id =?";
			
			PreparedStatement pstmt=con.prepareStatement(sql);
			pstmt.setString(1, class_id);
		
			rs=pstmt.executeQuery();
			int attend = -1;
			String student_id="";
			
			for(int i = 0; i < arrayParam.length; i++ ) {
			if(rs.next()) { 
			student_id=rs.getString(1);
			 
			 sql="update attendance set attend_week2="+Integer.parseInt(arrayParam[i])+ " where student_id=? and class_id=?";
			 
			
				pstmt=con.prepareStatement(sql);
				pstmt.setString(1, student_id);
				pstmt.setString(2, class_id);

				pstmt.executeUpdate();
			}
			}
			
			
			
		} catch (Exception e) {
			throw new RuntimeException("test"+ e.getMessage());
			
			// TODO: handle exception
		}finally {
			closeConnection(con);             
		}
	}

public void week3_save(String class_id, String[] arrayParam) {
	
	
	String sql="";
	Connection con = null;
	ResultSet rs;
	try {
		con =getConnection();
		sql = "select student.student_id" 
		   + " from student, enroll, class, attendance"
	       + " where enroll.student_id = student.student_id"
	       + " and student.student_id = attendance.student_id"
	       + " and enroll.class_id = class.class_id"
	       + " and class.class_id = attendance.class_id"
	      + " and enroll.class_id =?";
		
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1, class_id);
		
		rs=pstmt.executeQuery();
		int attend = -1;
		String student_id="";
		
		for(int i = 0; i < arrayParam.length; i++ ) {
		if(rs.next()) { 
		student_id=rs.getString(1);
		 sql="update attendance set attend_week3="+Integer.parseInt(arrayParam[i])+ " where student_id=? and class_id=?";
		 
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, student_id);
			pstmt.setString(2, class_id);

			pstmt.executeUpdate();
		}
		}
		
		
		
	} catch (Exception e) {
		throw new RuntimeException("test"+ e.getMessage());
		
		// TODO: handle exception
	}finally {
		closeConnection(con);             
	}
}

public void week4_save(String class_id, String[] arrayParam) {
	
	
	String sql="";
	Connection con = null;
	ResultSet rs;
	try {
		con =getConnection();
		sql = "select student.student_id" 
		   + " from student, enroll, class, attendance"
	       + " where enroll.student_id = student.student_id"
	       + " and student.student_id = attendance.student_id"
	       + " and enroll.class_id = class.class_id"
	       + " and class.class_id = attendance.class_id"
	      + " and enroll.class_id =?";
		
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1, class_id);
		rs=pstmt.executeQuery();
		int attend = -1;
		String student_id="";
		
		for(int i = 0; i < arrayParam.length; i++ ) {
		if(rs.next()) { 
		student_id=rs.getString(1); 
		 sql="update attendance set attend_week4="+Integer.parseInt(arrayParam[i])+ " where student_id=? and class_id=?";
		 
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, student_id);
			pstmt.setString(2, class_id);

			pstmt.executeUpdate();
		}
		}
		
		
		
	} catch (Exception e) {
		throw new RuntimeException("test"+ e.getMessage());
		
		// TODO: handle exception
	}finally {
		closeConnection(con);             
	}
}

public void week5_save(String class_id, String[] arrayParam) {
	
	
	String sql="";
	Connection con = null;
	ResultSet rs;
	try {
		con =getConnection();
		sql = "select student.student_id" 
		   + " from student, enroll, class, attendance"
	       + " where enroll.student_id = student.student_id"
	       + " and student.student_id = attendance.student_id"
	       + " and enroll.class_id = class.class_id"
	       + " and class.class_id = attendance.class_id"
	      + " and enroll.class_id =?";
		
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1, class_id);
		rs=pstmt.executeQuery();
		int attend = -1;
		String student_id="";
		
		for(int i = 0; i < arrayParam.length; i++ ) {
		if(rs.next()) { 
		student_id=rs.getString(1);
		 sql="update attendance set attend_week5="+Integer.parseInt(arrayParam[i])+ " where student_id=? and class_id=?";
		 
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, student_id);
			pstmt.setString(2, class_id);

			pstmt.executeUpdate();
		}
		}
		
		
		
	} catch (Exception e) {
		throw new RuntimeException("test"+ e.getMessage());
		
		// TODO: handle exception
	}finally {
		closeConnection(con);             
	}
}

public void week6_save(String class_id, String[] arrayParam) {
	
	
	String sql="";
	Connection con = null;
	ResultSet rs;
	try {
		con =getConnection();
		sql = "select student.student_id" 
		   + " from student, enroll, class, attendance"
	       + " where enroll.student_id = student.student_id"
	       + " and student.student_id = attendance.student_id"
	       + " and enroll.class_id = class.class_id"
	       + " and class.class_id = attendance.class_id"
	      + " and enroll.class_id =?";
		
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1, class_id);
		rs=pstmt.executeQuery();
		int attend = -1;
		String student_id="";
		
		for(int i = 0; i < arrayParam.length; i++ ) {
		if(rs.next()) { 
		student_id=rs.getString(1);
		 sql="update attendance set attend_week6="+Integer.parseInt(arrayParam[i])+ " where student_id=? and class_id=?";
		 
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, student_id);
			pstmt.setString(2, class_id);

			pstmt.executeUpdate();
		}
		}
		
		
		
	} catch (Exception e) {
		throw new RuntimeException("test"+ e.getMessage());
		
		// TODO: handle exception
	}finally {
		closeConnection(con);             
	}
}

public void week7_save(String class_id, String[] arrayParam) {
	
	
	String sql="";
	Connection con = null;
	ResultSet rs;
	try {
		con =getConnection();
		sql = "select student.student_id" 
		   + " from student, enroll, class, attendance"
	       + " where enroll.student_id = student.student_id"
	       + " and student.student_id = attendance.student_id"
	       + " and enroll.class_id = class.class_id"
	       + " and class.class_id = attendance.class_id"
	      + " and enroll.class_id =?";
		
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1, class_id);
		rs=pstmt.executeQuery();
		int attend = -1;
		String student_id="";
		
		for(int i = 0; i < arrayParam.length; i++ ) {
		if(rs.next()) { 
		student_id=rs.getString(1);
		 sql="update attendance set attend_week7="+Integer.parseInt(arrayParam[i])+ " where student_id=? and class_id=?";
		 
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, student_id);
			pstmt.setString(2, class_id);

			pstmt.executeUpdate();
		}
		}
		
		
		
	} catch (Exception e) {
		throw new RuntimeException("test"+ e.getMessage());
		
		// TODO: handle exception
	}finally {
		closeConnection(con);             
	}
}

public void week8_save(String class_id, String[] arrayParam) {
	
	
	String sql="";
	Connection con = null;
	ResultSet rs;
	try {
		con =getConnection();
		sql = "select student.student_id" 
		   + " from student, enroll, class, attendance"
	       + " where enroll.student_id = student.student_id"
	       + " and student.student_id = attendance.student_id"
	       + " and enroll.class_id = class.class_id"
	       + " and class.class_id = attendance.class_id"
	      + " and enroll.class_id =?";
		
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1, class_id);
		
		rs=pstmt.executeQuery();
		int attend = -1;
		String student_id="";
		
		for(int i = 0; i < arrayParam.length; i++ ) {
		if(rs.next()) { 
		student_id=rs.getString(1);
		 sql="update attendance set attend_week8="+Integer.parseInt(arrayParam[i])+ " where student_id=? and class_id=?";
		 
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, student_id);
			pstmt.setString(2, class_id);

			pstmt.executeUpdate();
		}
		}
		
		
		
	} catch (Exception e) {
		throw new RuntimeException("test"+ e.getMessage());
		
		// TODO: handle exception
	}finally {
		closeConnection(con);             
	}
}

public void week9_save(String class_id, String[] arrayParam) {
	
	
	String sql="";
	Connection con = null;
	ResultSet rs;
	try {
		con =getConnection();
		sql = "select student.student_id" 
		   + " from student, enroll, class, attendance"
	       + " where enroll.student_id = student.student_id"
	       + " and student.student_id = attendance.student_id"
	       + " and enroll.class_id = class.class_id"
	       + " and class.class_id = attendance.class_id"
	      + " and enroll.class_id =?";
		
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1, class_id);
		
		rs=pstmt.executeQuery();
		int attend = -1;
		String student_id="";
		
		for(int i = 0; i < arrayParam.length; i++ ) {
		if(rs.next()) { 
		student_id=rs.getString(1);
		 sql="update attendance set attend_week9="+Integer.parseInt(arrayParam[i])+ " where student_id=? and class_id=?";
		 
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, student_id);
			pstmt.setString(2, class_id);

			pstmt.executeUpdate();
		}
		}
		
		
		
	} catch (Exception e) {
		throw new RuntimeException("test"+ e.getMessage());
		
		// TODO: handle exception
	}finally {
		closeConnection(con);             
	}
}

public void week10_save(String class_id, String[] arrayParam) {
	
	
	String sql="";
	Connection con = null;
	ResultSet rs;
	try {
		con =getConnection();
		sql = "select student.student_id" // ,attend_week1
		   + " from student, enroll, class, attendance"
	       + " where enroll.student_id = student.student_id"
	       + " and student.student_id = attendance.student_id"
	       + " and enroll.class_id = class.class_id"
	       + " and class.class_id = attendance.class_id"
	      + " and enroll.class_id =?";
		
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1, class_id);
		rs=pstmt.executeQuery();
		int attend = -1;
		String student_id="";
		
		for(int i = 0; i < arrayParam.length; i++ ) {
		if(rs.next()) { 
		student_id=rs.getString(1);
		
		 sql="update attendance set attend_week10="+Integer.parseInt(arrayParam[i])+ " where student_id=? and class_id=?";
		 
		 System.out.println(sql);
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, student_id);
			pstmt.setString(2, class_id);

			pstmt.executeUpdate();
		}
		}
		
		
		
	} catch (Exception e) {
		throw new RuntimeException("test"+ e.getMessage());
		
		// TODO: handle exception
	}finally {
		closeConnection(con);             
	}
}

public void week11_save(String class_id, String[] arrayParam) {
	
	
	String sql="";
	Connection con = null;
	ResultSet rs;
	try {
		con =getConnection();
		sql = "select student.student_id" 
		   + " from student, enroll, class, attendance"
	       + " where enroll.student_id = student.student_id"
	       + " and student.student_id = attendance.student_id"
	       + " and enroll.class_id = class.class_id"
	       + " and class.class_id = attendance.class_id"
	      + " and enroll.class_id =?";
		
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1, class_id);
		
		rs=pstmt.executeQuery();
		int attend = -1;
		String student_id="";
		
		for(int i = 0; i < arrayParam.length; i++ ) {
		if(rs.next()) { 
		student_id=rs.getString(1);
		 sql="update attendance set attend_week11="+Integer.parseInt(arrayParam[i])+ " where student_id=? and class_id=?";
		
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, student_id);
			pstmt.setString(2, class_id);

			pstmt.executeUpdate();
		}
		}

	} catch (Exception e) {
		throw new RuntimeException("test"+ e.getMessage());
		
		// TODO: handle exception
	}finally {
		closeConnection(con);             
	}
}

public void week12_save(String class_id, String[] arrayParam) {
	
	
	String sql="";
	Connection con = null;
	ResultSet rs;
	try {
		con =getConnection();
		sql = "select student.student_id" 
		   + " from student, enroll, class, attendance"
	       + " where enroll.student_id = student.student_id"
	       + " and student.student_id = attendance.student_id"
	       + " and enroll.class_id = class.class_id"
	       + " and class.class_id = attendance.class_id"
	      + " and enroll.class_id =?";
		
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1, class_id);
		
		rs=pstmt.executeQuery();
		int attend = -1;
		String student_id="";
		
		for(int i = 0; i < arrayParam.length; i++ ) {
		if(rs.next()) { // 1번만 돈다
		student_id=rs.getString(1);
		 sql="update attendance set attend_week12="+Integer.parseInt(arrayParam[i])+ " where student_id=? and class_id=?";
		 
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, student_id);
			pstmt.setString(2, class_id);

			pstmt.executeUpdate();
		}
		}
	
	} catch (Exception e) {
		throw new RuntimeException("test"+ e.getMessage());
		
		// TODO: handle exception
	}finally {
		closeConnection(con);             
	}
}
	
public void qrcode_attendance(String student_id, String class_id, String week_num) {
	
		String sql="";
		Connection con = null;
		
		try {
			con =getConnection();
			sql = "update attendance set attend_week" +week_num + "=1 where student_id=? and class_id=?";
			
			PreparedStatement pstmt=con.prepareStatement(sql);
			
			pstmt.setString(1, student_id);
	        pstmt.setString(2, class_id);
			pstmt.executeUpdate();
		
		} catch (Exception e) {
			throw new RuntimeException("test"+ e.getMessage());
			
			// TODO: handle exception
		}finally {
			closeConnection(con);             
		}
	}
}
