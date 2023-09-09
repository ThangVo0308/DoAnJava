package DAL;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import DTO.DTO_PhieuBH;

public class DAL_PhieuBH {

    DB_Connect connection;

    public DAL_PhieuBH() {

    }

    public ArrayList<DTO_PhieuBH> readDB() {
        ArrayList<DTO_PhieuBH> listPBH = new ArrayList<>();
        connection = new DB_Connect();
        try {
            String query = "select * from Phieu_BH";
            ResultSet rs = connection.getSQLQuery(query);
            if (rs != null) {
                while (rs.next()) {
                    DTO_PhieuBH pbh = new DTO_PhieuBH(
                            rs.getString("Ma_BH"),
                            rs.getString("Ten_CH"),
                            rs.getString("Dia_chi"),
                            rs.getDate("Ngay_Ban_Hang"),
                            rs.getString("TG_Baohanh"),
                            rs.getDate("Ngay_Het_Han"),
                            rs.getBoolean("check_exist"));
                    listPBH.add(pbh);
                }
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Khong tim thay du lieu!");
            e.printStackTrace();
        } finally {
            connection.closeConnectionDB();
        }
        return listPBH;
    }

    public ArrayList<DTO_PhieuBH> searchPBH(String columnName, String keyword) {
        connection = new DB_Connect();
        ArrayList<DTO_PhieuBH> listPBH = new ArrayList<>();

        try {
            String query = "select * from Phieu_BH where " + columnName + " like '%d" + keyword + "%'";
            ResultSet rs = connection.getSQLQuery(query);
            if (rs != null) {
                while (rs.next()) {
                    DTO_PhieuBH pbh = new DTO_PhieuBH(
                    		 rs.getString("Ma_BH"),
                             rs.getString("Ten_CH"),
                             rs.getString("Dia_chi"),
                             rs.getDate("Ngay_Ban_Hang"),
                             rs.getString("TG_Baohanh"),
                             rs.getDate("Ngay_Het_Han"),
                             rs.getBoolean("check_exist"));
                    listPBH.add(pbh);
                }
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "-- ERROR! Lỗi tìm dữ liệu " + columnName + " = " + keyword + " bảng phiếu_BH");
            e.printStackTrace();
        } finally {
            connection.closeConnectionDB();
        }

        return listPBH;
    }

    public boolean addPBH(DTO_PhieuBH bh) {
        connection = new DB_Connect();
        boolean add = connection.sqlUpdate("insert into Phieu_BH (Ma_BH, Ten_CH, Dia_Chi, Ngay_Ban_Hang, TG_Baohanh, Ngay_Het_Han, check_exist) values ('"
                + bh.getMa_BH() + "', '"
                + bh.getTen_BH() + "', '"
                + bh.getDiaChi() + "', '"
                + bh.getNgay_banHang() + "', '"
                + bh.getTG_baoHanh() + "', '"
                + bh.getNgay_Het_Han() + "', '"
                + bh.isCheck_exist() + "');");
        connection.closeConnectionDB();
        return add;
    }

    public boolean deletePBH(String MaBH) {
        connection = new DB_Connect();
        boolean del = connection.sqlUpdate("update Phieu_BH set check_exist='" + false + "' where Ma_BH='" + MaBH + "'");
        connection.closeConnectionDB();
        return del;
    }

    public boolean suaPBH(DTO_PhieuBH pbh) {
        connection = new DB_Connect();
        boolean fix = connection.sqlUpdate("update Phieu_BH set "
                + "Ten_CH='" + pbh.getTen_BH()
                + "',Ngay_Ban_Hang" + pbh.getNgay_banHang()
                + "',TG_Baohanh='" + pbh.getTG_baoHanh()
                + "',Ngay_Het_Han='" + pbh.getNgay_Het_Han()
                + "',Dia_chi='" + pbh.getDiaChi()
                + "',check_exist='" + pbh.isCheck_exist()
                + "' where Ma_BH='" + pbh.getMa_BH()
                + "';");
        connection.closeConnectionDB();
        return fix;
    }

    public boolean updatePBH(String MaBH, String TenCH,String diaChi,Date Ngaybanhang,String TG_baohanh,Date Ngayhethan,boolean check) {
        DTO_PhieuBH updatePBH = new DTO_PhieuBH(MaBH, TenCH, diaChi,Ngaybanhang, TG_baohanh, Ngayhethan,check);
        return suaPBH(updatePBH);
    }

    public void close() {
        connection.closeConnectionDB();
    }
}
