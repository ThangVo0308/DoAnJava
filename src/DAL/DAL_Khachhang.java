package DAL;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import DTO.DTO_Khachhang;

public class DAL_Khachhang {

    DB_Connect connection;

    public DAL_Khachhang() {

    }

    public ArrayList<DTO_Khachhang> readDB() {
        connection = new DB_Connect();
        ArrayList<DTO_Khachhang> listKH = new ArrayList<>();
        try {
            String query = "select * from Khach_hang";
            ResultSet rs = connection.getSQLQuery(query);
            if (rs != null) {
                while (rs.next()) {
                    DTO_Khachhang kh = new DTO_Khachhang(
                            rs.getString("Ma_KH"),
                            rs.getString("Ten_KH"),
                            rs.getString("Dia_chi"),
                            rs.getString("SDT"),
                            rs.getBoolean("check_exist"));
                    listKH.add(kh);
                }
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Khong tim thay du lieu!");
            e.printStackTrace();
        } finally {
            connection.closeConnectionDB();
        }
        return listKH;
    }

    public ArrayList<DTO_Khachhang> searchKH(String columnName, String keyword) {
        connection = new DB_Connect();
        ArrayList<DTO_Khachhang> listKH = new ArrayList<>();

        try {
            String query = "select * from Khach_hang where " + columnName + " like '%d" + keyword + "%'";
            ResultSet rs = connection.getSQLQuery(query);
            if (rs != null) {
                while (rs.next()) {
                    DTO_Khachhang kh = new DTO_Khachhang(
                            rs.getString("Ma_KH"),
                            rs.getString("Ten_KH"),
                            rs.getString("Dia_chi"),
                            rs.getString("SDT"),
                            rs.getBoolean("check_exist"));
                    listKH.add(kh);
                }
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "-- ERROR! Lỗi tìm dữ liệu " + columnName + " = " + keyword + " bảng khách hàng");
            e.printStackTrace();
        } finally {
            connection.closeConnectionDB();
        }

        return listKH;
    }

    public boolean addKH(DTO_Khachhang kh) {
        connection = new DB_Connect();
        boolean add = connection.sqlUpdate("insert into Khach_hang (Ma_KH,Ten_KH,Dia_chi,SDT,check_exist) values ('"
        		+ kh.getMa_KH() + "', '"
        		+ kh.getTen_KH() + "', '"
        		+ kh.getDiaChi() + "','"
        		+ kh.getSDT() + "','"
        		+ kh.isCheck_exist() + "');");
        connection.closeConnectionDB();
        return add;
    }

    public boolean deleteKH(String maKH) {
        connection = new DB_Connect();
        boolean del = connection.sqlUpdate("update Khach_hang set check_exist='" + false + "' where Ma_KH='" + maKH + "'");
        connection.closeConnectionDB();
        return del;
    }

    public boolean suaKH(DTO_Khachhang kh) {
        connection = new DB_Connect();
        boolean fix = connection.sqlUpdate("update Khach_hang set "
                + "Ten_KH='" + kh.getTen_KH()
                + "', Dia_chi='" + kh.getDiaChi()
                + "', SDT='" + kh.getSDT()
                + "' where Ma_KH='" + kh.getMa_KH() + "';");
        connection.closeConnectionDB();
        return fix;
    }

    public boolean updateKH(String MaKH, String TenKH, String DiaChi, String SDT,boolean check_exist) {
        DTO_Khachhang updateKH = new DTO_Khachhang(MaKH, TenKH, DiaChi, SDT,check_exist);
        return suaKH(updateKH);
    }

    public void close() {
        connection.closeConnectionDB();
    }
}
