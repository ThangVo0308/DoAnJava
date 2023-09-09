package DAL;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import DTO.DTO_Phieunhap;
import javax.swing.JOptionPane;

public class DAL_Phieunhap {

    DB_Connect connection;

    public DAL_Phieunhap() {

    }

    public ArrayList<DTO_Phieunhap> readDB() {
        connection = new DB_Connect();
        ArrayList<DTO_Phieunhap> listPN = new ArrayList<>();
        try {
            String query = "select * from Phieu_nhap";
            ResultSet rs = connection.getSQLQuery(query);
            if (rs != null) {

                while (rs.next()) {
                    DTO_Phieunhap pn = new DTO_Phieunhap( 
                    		rs.getString("Ma_PN"),
                            rs.getDate("Ngay_nhap"),
                            rs.getInt("Tong_gia"),
                            rs.getString("Ma_NPP"),                       
                            rs.getBoolean("check_exist"));
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

    public boolean addPN(DTO_Phieunhap pn) {
        connection = new DB_Connect();
        boolean add = connection.sqlUpdate("INSERT INTO Phieu_nhap (Ma_PN, Ngay_nhap, Tong_gia, Ma_NPP, check_exist) VALUES ('"
                + pn.getMa_PN() + "','"
                + pn.getNgayNhap() + "','"
                + pn.getTongGia() + "','"
                + pn.getMa_NPP() + "','"
                + pn.isCheck_exist() + "');");
        connection.closeConnectionDB();
        return add;
    }
    
    public boolean deletePN(String maPN) {
	    connection = new DB_Connect();   
	    boolean check = connection.sqlUpdate("update Phieu_nhap set check_exist='" + false + "' where Ma_PN='" + maPN + "'");
	    connection.closeConnectionDB();
	    return check;
	}


    public boolean suaPN(DTO_Phieunhap pn) {
        connection = new DB_Connect();
        boolean fix = connection.sqlUpdate("update Phieu_nhap set "
                + "Ngay_nhap='" + pn.getNgayNhap()
                + "', Tong_gia='" + pn.getTongGia()
                + "', Ma_NPP='" + pn.getMa_NPP()
                + "', check_exist='" + pn.isCheck_exist()
                + "' where Ma_PN='" + pn.getMa_PN() + "';");
        connection.closeConnectionDB();
        return fix;
    }

    public boolean updateTonggia(String _maPN, int _Tonggia) {
        connection = new DB_Connect();
        boolean kq = connection.sqlUpdate("update Phieu_nhap set Tong_gia='" + _Tonggia + "' where Ma_PN='" + _maPN + "';");
        connection.closeConnectionDB();
        return kq;
    }

    public boolean updatePN(String ma_PN, Date ngayNhap, int tongGia, String ma_NPP, boolean check_exist) {
        DTO_Phieunhap updatePN = new DTO_Phieunhap(ma_PN, ngayNhap, tongGia, ma_NPP, check_exist);
        return suaPN(updatePN);
    }

    public void close() {
        connection.closeConnectionDB();
    }
}
