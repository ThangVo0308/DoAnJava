package DAL;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

import DTO.DTO_LoaiDT;

public class DAL_LoaiDT {

    DB_Connect connection;

    public DAL_LoaiDT() {

    }

    public ArrayList<DTO_LoaiDT> readDB() {
        connection = new DB_Connect();
        ArrayList<DTO_LoaiDT> listLDT = new ArrayList<>();
        try {
            String query = "select * from Loai_DT";
            ResultSet rs = connection.getSQLQuery(query);
            if (rs != null) {
                while (rs.next()) {
                    DTO_LoaiDT ldt = new DTO_LoaiDT(
                    rs.getString("Ma_Loai"),
                    rs.getString("Ten_Loai"),
                    rs.getString("Mo_ta"),
                    rs.getBoolean("check_exist"));
                    listLDT.add(ldt);
                }
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Khong tim thay du lieu!");
        } finally {
            connection.closeConnectionDB();
        }
        return listLDT;
    }

    public ArrayList<DTO_LoaiDT> searchLDT(String columnName, String keyword) {
        connection = new DB_Connect();
        ArrayList<DTO_LoaiDT> listLDT = new ArrayList<>();

        try {
            String query = "select * from Loai_DT where " + columnName + " LIKE '%d" + keyword + "%'";
            ResultSet rs = connection.getSQLQuery(query);
            if (rs != null) {
                while (rs.next()) {
                    String maLDT = rs.getString("Ma_Loai");
                    String tenLDT = rs.getString("Ten_Loai");
                    String mota = rs.getString("Mo_ta");
                    boolean check_exist = rs.getBoolean("check_exist");
                }
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "-- ERROR! Lỗi tìm dữ liệu " + columnName + " = " + keyword + " bảng loại sản phẩm");
        } finally {
            connection.closeConnectionDB();
        }

        return listLDT;
    }

    public boolean addLDT(DTO_LoaiDT ldt) {
    	connection = new DB_Connect();
    	boolean add = connection.sqlUpdate("insert into Loai_DT (Ma_Loai, Ten_Loai, Mo_ta, check_exist) values ('"
    	+ ldt.getMaLoai() + "', '"
    	+ ldt.getTenLoai() + "', '"
    	+ ldt.getMoTa() + "', '"
    	+ ldt.isCheckExist() + "');");
    	connection.closeConnectionDB();
    	return add;
    	}

    public boolean deleteLDT(String maLDT) {
        connection = new DB_Connect();
        boolean del = connection.sqlUpdate("update Loai_DT set check_exist='" + false + "' where Ma_Loai='" + maLDT + "'");
        connection.closeConnectionDB();
        return del;
    }

    public boolean suaLDT(DTO_LoaiDT ldt) {
    	connection = new DB_Connect();
        boolean fix = connection.sqlUpdate("update Loai_DT set "
                + "Ten_Loai='" + ldt.getTenLoai() + "', "
                + "Mo_Ta='" + ldt.getMoTa() + "', "
                + "check_exist='" + ldt.isCheckExist() + "' "
                + "where Ma_Loai='" + ldt.getMaLoai() + "'");
        connection.closeConnectionDB();
        return fix;
    }


    public boolean updateLDT(String maLDT, String tenLDT, String Mota, boolean checkExist) {
        DTO_LoaiDT updateLDT = new DTO_LoaiDT(maLDT, tenLDT, Mota, checkExist);
        return suaLDT(updateLDT);
    }

    public void close() {
        connection.closeConnectionDB();
    }
}
