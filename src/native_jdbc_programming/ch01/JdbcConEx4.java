package native_jdbc_programming.ch01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import native_jdbc_programming.dto.Department;
import native_jdbc_programming.util.JdbcUtil;

/**
 *  JDBC try-catch-resource
 *	2021.2.16
 */
public class JdbcConEx4 {

	public static void main(String[] args) {
		ArrayList<Department> list = null;
		
		String sql = "select deptno, deptname, floor from department";
		
		try (
				Connection con = JdbcUtil.getConnection();
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(sql);
			) 
		{
			// 1. JDBC 드라이버 로딩
			Class.forName("com.mysql.jdbc.Driver");
			
			list = new ArrayList<>();
			System.out.println(list);
			while (rs.next()) {
				list.add(getDepartment(rs));
			}
			System.out.println(list);
			
		} catch (ClassNotFoundException e) {
			System.err.println("JDBC Driver Not Found");
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		
		System.out.println("Department Query 결과는 ");
		for(Department d : list) {
			System.out.println(d);
		}
	}

	private static Department getDepartment(ResultSet rs) throws SQLException {
		int deptno = rs.getInt("deptno");
		String deptname = rs.getString("deptname");
		int floor = rs.getInt("floor");
		return new Department(deptno, deptname, floor);
	}
}
