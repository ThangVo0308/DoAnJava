package DAL;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import DTO.DTO_Taikhoan;

public class DAL_Taikhoan {

    DB_Connect connection;

    public DAL_Taikhoan() {

    }

    public ArrayList<DTO_Taikhoan> readDB() {
        connection = new DB_Connect();
        ArrayList<DTO_Taikhoan> listTK = new ArrayList<>();
        try {
            String query = "select * from Tai_khoan";
            ResultSet rs = connection.getSQLQuery(query);
            if (rs != null) {
                while (rs.next()) {
                    DTO_Taikhoan tk = new DTO_Taikhoan(
                            rs.getInt("So_TK"),
                            rs.getString("Ten_TK"),
                            rs.getString("Mat_khau"),
                            rs.getString("SDT"),
                            rs.getDate("Ngay_tao"),
                            rs.getBoolean("check_exist"));
                    listTK.add(tk);
                }
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "-- ERROR! Lỗi đọc dữ liệu bảng tài khoản");
        } finally {
            connection.closeConnectionDB();
        }
        return listTK;
    }

    public boolean addTK(DTO_Taikhoan tk) {
        connection = new DB_Connect();
        boolean add = connection.sqlUpdate("insert into Tai_khoan (So_TK, Ten_TK, Mat_khau, SDT, Ngay_tao, check_exist) values ('"
                + tk.getSo_TK() + "', '"
                + tk.getTen_TK() + "', '"
                + tk.getMat_khau() + "', '"
                + tk.getSDT() + "', '"
                + tk.getNgayTao() + "', '"
                + tk.isCheck_exist() + "');");
        connection.closeConnectionDB();
        return add;
    }

    public boolean deleteTK(int STT) {
        connection = new DB_Connect();
        boolean del = connection.sqlUpdate("update Tai_khoan set check_exist='" + false + "' where So_TK='" + STT + "'");
        connection.closeConnectionDB();
        return del;
    }

    public boolean suaTK(DTO_Taikhoan tk) {
        connection = new DB_Connect();
        boolean fix = connection.sqlUpdate("update Tai_khoan set Mat_khau='" + tk.getMat_khau()
                + "',SDT='" + tk.getSDT()
                + "',Ngay_tao='" + tk.getNgayTao()
                + "',check_exist='" + tk.isCheck_exist()
                + "' where TenTaiKhoan='" + tk.getTen_TK() + "'");
        connection.closeConnectionDB();
        return fix;
    }

    public boolean updateTK(int SoTK, String TenTK, String Mat_khau, String SDT, Date Ngay_tao, boolean check_exist) {
        DTO_Taikhoan updateTK = new DTO_Taikhoan(SoTK, TenTK, Mat_khau, SDT, Ngay_tao, check_exist);
        return suaTK(updateTK);
    }
    
   

	public void close() {
        connection.closeConnectionDB();
    }
}
