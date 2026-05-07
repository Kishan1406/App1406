package com.abc.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.abc.pojo.Student;
import com.abc.utility.JdbcUtil;

public class StudentDaoImpl implements IStudentDao {

	private String SQL_INSERT_QUERY="INSERT INTO STUDENT(SNAME,SAGE,SADDRESS) VALUES(?,?,?)";

	@Override
	public String save(Student student) {
		Connection connection =null;
		PreparedStatement pstmt=null;
		try {
			connection = JdbcUtil.getDbConnection();
			
			if (connection!=null) {
				 pstmt = connection.prepareStatement(SQL_INSERT_QUERY);
			if (pstmt!=null) {
				pstmt.setString(1,student.getSname());
				pstmt.setInt(2, student.getSage());
				pstmt.setString(3, student.getSaddress());
				
				int rowCount = pstmt.executeUpdate();
				
				if (rowCount>0) {
					return "Student record inserted sucessfully..";
					} 
				
			}
		}
			} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "Student record insertion failed..";
	}
	

	@Override
	public Student getById(Integer id) {
		
		Connection connection =null;
		PreparedStatement pstmt=null;
		ResultSet resultSet=null;
		
		try {
			connection = JdbcUtil.getDbConnection();
			
			if (connection!=null) {
				String SQL_SELECT_QUERY="SELECT SID,SNAME,SAGE,SADDRESS FROM STUDENT WHERE SID=?";
				
				 pstmt = connection.prepareStatement(SQL_SELECT_QUERY);
			if (pstmt!=null) {
				pstmt.setInt(1,id);
				resultSet = pstmt.executeQuery();
				if (resultSet.next()) {
					Student student = new Student();
					student.setSid(id);
					student.setSname(resultSet.getString(2));
					student.setSage(resultSet.getInt(3));
					student.setSaddress(resultSet.getString(4));
					
					return student;
				} 
			} 
		}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return null;
		
	}

	@Override
	public String updateById(Student student) {
		Connection connection =null;
		PreparedStatement pstmt=null;
		ResultSet resultSet=null;
		
		try {
			connection = JdbcUtil.getDbConnection();
			
			if (connection!=null) {
				String SQL_UPDATE_QUERY="UPDATE STUDENT SET SNAME=?,SAGE=? , SADDRESS=? where SID=?";
				
				 pstmt = connection.prepareStatement(SQL_UPDATE_QUERY);
			if (pstmt!=null) {
				//Setting the input
				pstmt.setString(1, student.getSname());
				pstmt.setInt(2,student.getSage());
				pstmt.setString(3, student.getSaddress());
				pstmt.setInt(4,student.getSid());
				
				pstmt.executeUpdate();
				return "update successfully";
				
				} 
			}
		}catch (SQLException e){
			e.printStackTrace();
			
		}
		return "updation failed";
	}

	@Override
	public String deleteById(Integer id) {
		Connection connection =null;
		PreparedStatement pstmt=null;
		try {
			connection = JdbcUtil.getDbConnection();
			
			if (connection!=null) {
				 String SQL_DELETE_QUERY="DELETE FROM STUDENT WHERE SID=?";
				 pstmt = connection.prepareStatement(SQL_DELETE_QUERY);
			if (pstmt!=null) {
				pstmt.setInt(1, id);
				
				int rowCount = pstmt.executeUpdate();
				
				if (rowCount>0) {
					return "Student record deleted sucessfully..";
					} 
				
			}
		}
			} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "Student record deletion failed..";
	}

}
