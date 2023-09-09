package DAL;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import DTO.DTO_ChitietHD;
import DTO.DTO_ChitietPN;

public class DAL_ChitietPN {

    DB_Connect connection;

    public ArrayList<DTO_ChitietPN> readDB() {
        connection = new DB_Connect();
        ArrayList<DTO_ChitietPN> listPN = new ArrayList<>();
        try {
            String query = "select * from CT_Phieunhap";
            ResultSet rs = connection.getSQLQuery(query);
            if (rs != null) {
                while (rs.next()) {
                    DTO_ChitietPN pn = new DTO_ChitietPN(rs.getString("Ma_PN"), rs.getString("Ma_DT"), rs.getInt("SL"),rs.getInt("Gia"),rs.getBoolean("check_exist"));
                    listPN.add(pn);
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Khong tim thay du lieu!");
            e.printStackTrace();
        } finally {
            connection.closeConnectionDB();
        }
        return listPN;

    }

    public boolean addCTPN(DTO_ChitietPN pn) {
        connection = new DB_Connect();
        boolean add = connection.sqlUpdate("insert into CT_Phieunhap (Ma_PN, Ma_DT, SL, Gia, check_exist) values ('"
	            + pn.getMa_PN() + "','" 
	            + pn.getMa_DT() + "','" 
	            + pn.getSL() + "','" 
	            + pn.getGia() + "','" 
	            + pn.isCheck_exist() + "')");
        connection.closeConnectionDB();
        return add;
    }

    public boolean deleteCTPN(String maPN, String maDT) {
        connection = new DB_Connect();
        boolean kq = connection.sqlUpdate("UPDATE CT_Phieunhap SET check_exist = '" + false + "' WHERE Ma_PN = '" + maPN + "' AND Ma_DT = '" + maDT + "'");
        connection.closeConnectionDB();
        return kq;
    }
    
    public boolean deleteCTPNN(String maPN, String maDT) {
        connection = new DB_Connect();
        boolean kq = connection.sqlUpdate("DELETE FROM CT_Phieunhap WHERE Ma_PN = '" + maPN + "' AND Ma_DT = '" + maDT + "'");
        connection.closeConnectionDB();
        return kq;
    }

    public boolean suaCTPN(DTO_ChitietPN pn,String oldMaDT, String newMaDT) {
	    connection = new DB_Connect();
	    boolean kq;
	    if (oldMaDT != null && oldMaDT.equals(newMaDT)) {
	        kq = connection.sqlUpdate("UPDATE CT_Phieunhap SET "
	            + "SL=" + pn.getSL() + ", "
	            + "Gia=" + pn.getGia() + ", "
	            + "check_exist='" + pn.isCheck_exist() + "' "
	            + "WHERE Ma_PN='" + pn.getMa_PN() + "' AND Ma_DT='" + pn.getMa_DT() + "';");
	    } else {
	        kq = connection.sqlUpdate("UPDATE CT_Phieunhap SET "
	            + "Ma_DT='" + newMaDT + "', "
	            + "SL=" + pn.getSL() + ", "
	            + "Gia=" + pn.getGia() + ", "
	            + "check_exist='" + pn.isCheck_exist() + "' "
	            + "WHERE Ma_PN='" + pn.getMa_PN() + "' AND Ma_DT='" + oldMaDT + "';");
	    }
	    
	    connection.closeConnectionDB();
	    return kq;
    }

    public boolean updateCTPN(String Ma_PN, String oldMaDT, String newMaDT, int SL, int Gia, boolean check_exist) {
    	DTO_ChitietPN updatePN;
	    if (oldMaDT != null &&  oldMaDT.equals(newMaDT)) {
	        updatePN = new DTO_ChitietPN(Ma_PN, oldMaDT, SL, Gia, check_exist);
	    } else {
	        updatePN = new DTO_ChitietPN(Ma_PN, newMaDT, SL, Gia, check_exist);
	    }
	    
	    return suaCTPN(updatePN, oldMaDT, newMaDT);
    }

    public void close() {
        connection.closeConnectionDB();
    }
}
