package DAL;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import DTO.DTO_Chucvu;

public class DAL_Chucvu {

    DB_Connect connection;

    public ArrayList<DTO_Chucvu> readDB() {
        connection = new DB_Connect();
        ArrayList<DTO_Chucvu> listCV = new ArrayList<>();
        try {
            String query = "select * from Chuc_vu";
            ResultSet rs = connection.getSQLQuery(query);
            if (rs != null) {
                while (rs.next()) {
                    DTO_Chucvu cv = new DTO_Chucvu(
                            rs.getString("Ma_CV"), 
                            rs.getString("Ten_CV"), 
                            rs.getString("MO_TA"),
                            rs.getBoolean("check_exist"));
                    listCV.add(cv);
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Khong tim thay du lieu!");
            e.printStackTrace();
        } finally {
            connection.closeConnectionDB();
        }
        return listCV;

    }

    public boolean addChucVU(DTO_Chucvu cv) {
        connection = new DB_Connect();
        boolean add = connection.sqlUpdate("insert into Chuc_vu (Ma_CV, Ten_CV, MO_TA, check_exist) values ('"
        		+ cv.getMa_CV() + "','"
        		+ cv.getTen_CV() + "','"
        		+ cv.getMoTa() + "','"
        		+ cv.isCheck_exist() + "')");
        return add;
    }

    public boolean deleteChucVu(String maCV) {
        connection = new DB_Connect();
        boolean del = connection.sqlUpdate("update Chuc_vu set check_exist='" + false + "' where Ma_CV='" + maCV + "'");        
        connection.closeConnectionDB();
        return del;
    }

    public boolean suaChucVu(DTO_Chucvu cv) {
        connection = new DB_Connect();
        boolean fix = connection.sqlUpdate("update Chuc_vu set "
                + "Ten_CV='" + cv.getTen_CV() + "', "
                + "MO_TA='" + cv.getMoTa() + "', "
                + "check_exist='" + cv.isCheck_exist() + "' "
                + "where Ma_CV='" + cv.getMa_CV() + "'");
        connection.closeConnectionDB();
        return fix;
    }

    public boolean updateChucVU(String MaCV, String TenCV, String Mota,boolean check_exist) {
        DTO_Chucvu updateCV = new DTO_Chucvu(MaCV, TenCV, Mota,check_exist);
        return suaChucVu(updateCV);
    }

    public void close() {
        connection.closeConnectionDB();
    }
}
