package DAL;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.time.LocalDate;

import DTO.DTO_Hoadon;
import DTO.DTO_Nhanvien;

import javax.swing.JOptionPane;

import com.toedter.calendar.JDateChooser;

public class DAL_Hoadon {

    DB_Connect connection;

    public DAL_Hoadon() {

    }

    public ArrayList<DTO_Hoadon> readDB() {
        connection = new DB_Connect();
        ArrayList<DTO_Hoadon> listHD = new ArrayList<>();
        try {
            String query = "select * from Hoa_don";
            ResultSet rs = connection.getSQLQuery(query);
            if (rs != null) {
                while (rs.next()) {
                    DTO_Hoadon hd = new DTO_Hoadon(
                            rs.getString("Ma_HD"),
                            rs.getDate("Ngaylap_HD"),
                            rs.getInt("Tong_tien"),
                            rs.getString("Ma_KH"),
                            rs.getString("Ma_NV"),                            
                            rs.getBoolean("check_exist"));
                    listHD.add(hd);
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Khong tim thay du lieu!");
            e.printStackTrace();
        } finally {
            connection.closeConnectionDB();
        }
        return listHD;
    }

    public Boolean addHoadon(DTO_Hoadon hd) {
        connection = new DB_Connect();
        boolean add = connection.sqlUpdate("insert into Hoa_don (Ma_HD, Ngaylap_HD, Tong_tien, Ma_KH, Ma_NV,check_exist) values ('"
                + hd.getMa_HD() + "','"
                + hd.getNgayLap_HD() + "','"
                + hd.getTongTien() + "','"
                + hd.getMa_KH() + "','"
                + hd.getMa_NV() + "','"              
                + hd.isCheck_exist() + "');");
        return add;
    }


    public Boolean deleteHoadon(String mahd) {
        connection = new DB_Connect();
        boolean del = connection.sqlUpdate("update Hoa_don set check_exist='" + false + "' where Ma_HD='" + mahd + "'");        
        connection.closeConnectionDB();
        return del;
    }

    public boolean suaHoadon(DTO_Hoadon hd) {
        connection = new DB_Connect();
        boolean fix = connection.sqlUpdate("UPDATE Hoa_don SET "
                + "Ngaylap_HD='" + hd.getNgayLap_HD() + "', "
                + "Tong_tien='" + hd.getTongTien() + "', "
                + "Ma_KH='" + hd.getMa_KH() + "', "
                + "Ma_NV='" + hd.getMa_NV() + "', "
                + "check_exist='" + hd.isCheck_exist() + "' "
                + "WHERE Ma_HD='" + hd.getMa_HD() + "'");
        connection.closeConnectionDB();
        return fix;
    }



    public Boolean updateTongTien(String mahd, float tongtien) {
        connection = new DB_Connect();
        boolean kq = connection.sqlUpdate("update Hoa_don set Tong_tien='" + tongtien + "' where Ma_HD='" + mahd + "';");
        connection.closeConnectionDB();
        return kq;
    }

    public boolean updateHD(String Ma_HD, java.sql.Date ngayLap_HD, int Tong_Tien, String Ma_KH, String Ma_NV,boolean check) {
        DTO_Hoadon hd = new DTO_Hoadon(Ma_HD, ngayLap_HD,Tong_Tien,Ma_KH,Ma_NV,check);

        return suaHoadon(hd);
    }

    public void close() {
        connection.closeConnectionDB();
    }
    
    public ArrayList<DTO_Hoadon> searchHD(String tongTien, JDateChooser ngayLap1,JDateChooser ngayLap2) {
        connection = new DB_Connect();
        ArrayList<DTO_Hoadon> listHDSearch = new ArrayList<>();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String ngayLap1Str = dateFormat.format(ngayLap1.getDate());
	    String ngayLap2Str = dateFormat.format(ngayLap2.getDate());
        String query = null;
        try {
        	if(tongTien.equals("Tất cả") && (ngayLap1Str.isEmpty() && ngayLap2Str.isEmpty())) {
        	    query = "select * from Hoa_don";
        	}else if(tongTien.equals("Tất cả") && (!ngayLap1Str.isEmpty() && !ngayLap2Str.isEmpty())) {
        		query = "select * from Hoa_don where Ngaylap_HD >= '" + ngayLap1Str + "' and Ngaylap_HD <= '" + ngayLap2Str + "'";
        	}else {
        		if(tongTien.equals("Dưới 10 triệu")) {
        			query = "select * from Hoa_don where Tong_tien < 10000000";
        		}else if(tongTien.equals("Từ 10 triệu đến 20 triệu")) {
        			query = "select * from Hoa_don where Tong_tien >= 10000000 and Tong_tien < 20000000";
        		}else if(tongTien.equals("Trên 20 triệu")) {
        			query = "select * from Hoa_don where Tong_tien > 20000000";
        		}
        		if (ngayLap1Str != null && ngayLap2Str != null && tongTien != null) {
        		    query += " and Ngaylap_HD >= '" + ngayLap1Str + "' and Ngaylap_HD <= '" + ngayLap2Str + "'";
        		}else if(ngayLap1Str != null && ngayLap2Str == null && tongTien != null) {
        			query += " and Ngaylap_HD >= '" + ngayLap1Str + "'";
        		}else if(ngayLap1Str == null && ngayLap2Str != null && tongTien != null) {
        		    query += " and Ngaylap_HD >= GETDATE() and Ngaylap_HD <= '" + ngayLap2Str + "'";
        		}
        	}
        	System.out.println(query);
        	ResultSet rs = connection.getSQLQuery(query);
            if (rs != null) {
                while (rs.next()) {
                	DTO_Hoadon hd = new DTO_Hoadon(
                            rs.getString("Ma_HD"),
                            rs.getDate("Ngaylap_HD"),
                            rs.getInt("Tong_tien"),
                            rs.getString("Ma_KH"),
                            rs.getString("Ma_NV"),
                            rs.getBoolean("check_exist"));
                    listHDSearch.add(hd);
                }
            }
            query = null;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Lỗi khi tìm dữ liệu trong bảng nhân viên");
            e.printStackTrace();
        } finally {
            connection.closeConnectionDB();
        }
        return listHDSearch;
    }
}
