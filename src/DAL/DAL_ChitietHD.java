package DAL;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import DTO.DTO_ChitietHD;

public class DAL_ChitietHD{
	DB_Connect connection;
	
	public DAL_ChitietHD() {
		
	}
	
	
	public ArrayList<DTO_ChitietHD> readDB() {
		connection = new DB_Connect();
		ArrayList<DTO_ChitietHD> listHD = new ArrayList<>();
		try {
			String query = "select * from CT_Hoadon";
			ResultSet rs = connection.getSQLQuery(query);
			if(rs != null) {
				while(rs.next()) {
					DTO_ChitietHD hd = new DTO_ChitietHD(rs.getString("Ma_HD"), rs.getString("Ma_DT"), rs.getInt("SL"), rs.getInt("Gia"),rs.getBoolean("check_exist"));
					listHD.add(hd);
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			connection.closeConnectionDB();
		}
		return listHD;
	}
	
	public boolean addCTHD(DTO_ChitietHD hd) {
	    connection = new DB_Connect();
	    boolean kq = connection.sqlUpdate("INSERT INTO CT_Hoadon(Ma_HD, Ma_DT, SL, gia, check_exist) VALUES ('" 
	            + hd.getMaHD() + "','" 
	            + hd.getMaDT() + "','" 
	            + hd.getSL() + "','" 
	            + hd.getGia() + "','" 
	            + hd.isCheck_exist() + "')");
	    connection.closeConnectionDB();
	    return kq;
	}

	
	public boolean deleteCTHD(String mahd, String maDT) {
	    connection = new DB_Connect();
	    boolean kq = connection.sqlUpdate("UPDATE CT_Hoadon SET check_exist = '" + false + "' WHERE Ma_HD = '" + mahd + "' AND Ma_DT = '" + maDT + "'");
	    connection.closeConnectionDB();
	    return kq;
	}
	
	public boolean deleteCTHDd(String mahd, String maDT) {
	    connection = new DB_Connect();
	    boolean kq = connection.sqlUpdate("DELETE FROM CT_Hoadon WHERE Ma_HD = '" + mahd + "' AND Ma_DT = '" + maDT + "'");
	    connection.closeConnectionDB();
	    return kq;
	}
	
	public boolean suaCTHD(DTO_ChitietHD hd, String oldMaDT, String newMaDT) {
	    connection = new DB_Connect();
	    boolean kq;
	    if (oldMaDT != null && oldMaDT.equals(newMaDT)) {
	        kq = connection.sqlUpdate("UPDATE CT_Hoadon SET "
	            + "SL=" + hd.getSL() + ", "
	            + "Gia=" + hd.getGia() + ", "
	            + "check_exist='" + hd.isCheck_exist() + "' "
	            + "WHERE Ma_HD='" + hd.getMaHD() + "' AND Ma_DT='" + hd.getMaDT() + "';");
	        System.out.println("UPDATE CT_Hoadon SET "
		            + "SL=" + hd.getSL() + ", "
		            + "Gia=" + hd.getGia() + ", "
		            + "check_exist='" + hd.isCheck_exist() + "' "
		            + "WHERE Ma_HD='" + hd.getMaHD() + "' AND Ma_DT='" + hd.getMaDT() + "';");
	    } else {
	        kq = connection.sqlUpdate("UPDATE CT_Hoadon SET "
	            + "Ma_DT='" + newMaDT + "', "
	            + "SL=" + hd.getSL() + ", "
	            + "Gia=" + hd.getGia() + ", "
	            + "check_exist='" + hd.isCheck_exist() + "' "
	            + "WHERE Ma_HD='" + hd.getMaHD() + "' AND Ma_DT='" + oldMaDT + "';");
	        System.out.println("UPDATE CT_Hoadon SET "
	            + "Ma_DT='" + newMaDT + "', "
	            + "SL=" + hd.getSL() + ", "
	            + "Gia=" + hd.getGia() + ", "
	            + "check_exist='" + hd.isCheck_exist() + "' "
	            + "WHERE Ma_HD='" + hd.getMaHD() + "' AND Ma_DT='" + oldMaDT + "';");
	    }
	    
	    connection.closeConnectionDB();
	    return kq;
	}


	public boolean updateCTHD(String Ma_HD, String oldMaDT, String newMaDT, int SL, int Gia, boolean check_exist) { 
	    DTO_ChitietHD updateHD;
	    System.out.println("testingggg: "+oldMaDT);
	    System.out.println("testinggggaaa: "+newMaDT);
	    if (oldMaDT != null &&  oldMaDT.equals(newMaDT)) {
	        updateHD = new DTO_ChitietHD(Ma_HD, oldMaDT, SL, Gia, check_exist);
	    } else {
	        updateHD = new DTO_ChitietHD(Ma_HD, newMaDT, SL, Gia, check_exist);
	    }
	    
	    return suaCTHD(updateHD, oldMaDT, newMaDT);
	}
	
	
}