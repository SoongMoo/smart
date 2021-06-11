package model.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.DTO.EmployeeDTO;

public class EmployeeDAO {
	final String COLUMNS = "EMPLOYEE_ID,EMP_USERID, EMP_PW, "
			+ " EMP_NAME, HIRE_DATE, JOB_ID, PH_NUMBER, OFFICE_NUMBER,"
			+ " EMAIL, EMP_ADDRESS";
	static String jdbcDriver;
	static String jdbcUrl;
	static Connection conn;
	String sql;
	PreparedStatement pstmt;
	Integer result;
	ResultSet rs;
	static {
		jdbcDriver = "oracle.jdbc.driver.OracleDriver";
		jdbcUrl = "jdbc:oracle:thin:@localhost:1521:xe";
	}
	public static void getConnect() {
		try {
			Class.forName(jdbcDriver);
			conn = DriverManager.getConnection(jdbcUrl, "subin", "ORACLE");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	public List<EmployeeDTO> getEmpList() {
		List<EmployeeDTO> list = new ArrayList<EmployeeDTO>();
		sql = "select  " + COLUMNS + "  from employees";
		getConnect();
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				EmployeeDTO dto = new EmployeeDTO();
				dto.setEmployeeId(rs.getString("EMPLOYEE_ID"));
				dto.setEmpUserid(rs.getString(2));
				dto.setEmpPw(rs.getString("EMP_PW"));
				dto.setEmpName(rs.getString(4));
				dto.setHireDate(rs.getString("HIRE_DATE"));
				dto.setJobId(rs.getString("JOB_ID"));
				dto.setPhNumber(rs.getString("PH_NUMBER"));
				dto.setOfficeNumber(rs.getString("OFFICE_NUMBER"));
				dto.setEmail(rs.getString("EMAIL"));
				dto.setEmpAddress(rs.getString("EMP_ADDRESS"));
				list.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return list;
	}
	public int getEmpNo() {
		getConnect();
		sql = "select nvl(max(employee_id), 10000) + 1 from employees";
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			rs.next();
			result = rs.getInt(1);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return result;
	}
	public void empInsert(EmployeeDTO dto) {
		sql = "insert into employees (  " + COLUMNS + " )"
			+ " values(?,?,?,?,?,?,?,?,?,?)";
		getConnect();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getEmployeeId());
			pstmt.setString(2, dto.getEmpUserid());
			pstmt.setString(3, dto.getEmpPw());
			pstmt.setString(4, dto.getEmpName());
			pstmt.setString(5, dto.getHireDate());
			pstmt.setString(6, dto.getJobId());
			pstmt.setString(7, dto.getPhNumber());
			pstmt.setString(8, dto.getOfficeNumber());
			pstmt.setString(9, dto.getEmail());
			pstmt.setString(10, dto.getEmpAddress());	
			result = pstmt.executeUpdate();
			System.out.println(result + "개행이 저장되었습니다.");
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close();
		}
	}
	private void close() {
		if(rs != null)	try {rs.close();} 
						catch (SQLException e) {}
		if(pstmt != null)	try {pstmt.close();} 
						catch (SQLException e) {}
		if(conn != null)	try {conn.close();} 
						catch (SQLException e) {}
	}
	
	
	
	
	
	
	
	
	
}
