package DAL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class DB_Connect {
    Connection conn = null;
    Statement stmt = null;
    ResultSet rset = null;
	public boolean ConnectDB() {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			
			conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=QLDienthoai;user=sa;password=123456789");
//			System.out.println("Kết nối thành công");
			return true;
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
//			System.out.println("Ket noi that bai");
			return false;
		}
	}
	
	public void closeConnectionDB() {
		try {
	        if (conn != null) {
	            conn.close();
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}
	
	
	// lay ra cau query
	public ResultSet getSQLQuery(String qry) throws SQLException {
	    if (ConnectDB()) {
	        stmt = conn.createStatement();
	        rset = stmt.executeQuery(qry);
	        
	        return rset;
	    }
	    throw new SQLException("Không thể truy vấn đến DB");
	}
	
	
	public boolean sqlUpdate(String qry) {
	    if (ConnectDB()) {
	        try {
	            stmt = conn.createStatement();
	            stmt.executeUpdate(qry);
	            return true;
	        } catch (SQLException ex) {
	            ex.printStackTrace();
	        } finally {
	            closeConnectionDB();
	        }
	    }
	    return false;
	}
}
