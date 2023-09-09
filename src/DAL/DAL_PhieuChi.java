package DAL;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import DTO.DTO_PhieuChi;
import javax.swing.JOptionPane;

public class DAL_PhieuChi {

    DB_Connect connection;

    public DAL_PhieuChi() {

    }

    public ArrayList<DTO_PhieuChi> readDB() {
        connection = new DB_Connect();
        ArrayList<DTO_PhieuChi> listPC = new ArrayList<>();
        try {
            String query = "select * from Phieu_chi";
            ResultSet rs = connection.getSQLQuery(query);
            if (rs != null) {
                while (rs.next()) {
                    DTO_PhieuChi pc = new DTO_PhieuChi(
                    		rs.getString("Ma_PC"),
                            rs.getString("Ma_PN"),
                            rs.getString("Ma_NV"),
                            rs.getDate("Ngay_chi"),
                            rs.getInt("Tong_gia"),
                            rs.getBoolean("check_exist")) ;
                    listPC.add(pc);
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Khong tim thay du lieu!");
            e.printStackTrace();
        } finally {
            connection.closeConnectionDB();
        }
        return listPC;
    }

    public boolean addPhieuChi(DTO_PhieuChi pc) {
        connection = new DB_Connect();
        boolean add = connection.sqlUpdate("insert into Phieu_chi (Ma_PC, Ma_PN, Ma_NV, Ngay_chi, Tong_gia, check_exist) values ('"
                + pc.getMaPC() + "','"
                + pc.getMaPN() + "','"
                + pc.getMaNV() + "','"
                + pc.getNgayChi() + "','"
                + pc.getGia() + "','"
                + pc.isCheck_exist() + "');");

        connection.closeConnectionDB();
        return add;
    }

    public Boolean deletePhieuChi(String maPC) {
        connection = new DB_Connect();
        boolean del = connection.sqlUpdate("update Phieu_chi set check_exist='" + false + "' where Ma_PC='" + maPC + "';");
        connection.closeConnectionDB();
        return del;
    }

    public Boolean suaPhieuChi(DTO_PhieuChi pc) {
        connection = new DB_Connect();
        boolean fix = connection.sqlUpdate("update Phieu_chi set "
                + "Ma_PN='" + pc.getMaPN() + "', "
                + "Ma_NV='" + pc.getMaNV() + "', "
                + "Ngay_chi='" + pc.getNgayChi() + "', "
                + "Tong_gia='" + pc.getGia() + "', "
                + "check_exist='" + pc.isCheck_exist() + "' "
                + "where Ma_PC='" + pc.getMaPC() + "'");
        connection.closeConnectionDB();
        return fix;
    }

    public Boolean updateTonggia(String mapc, float tonggia) {
        connection = new DB_Connect();
        boolean kq = connection.sqlUpdate("update Phieu_chi set Tong_gia='" + tonggia + "' where Ma_PC='" + mapc + "';");
        connection.closeConnectionDB();
        return kq;
    }

    public boolean updatePhieuChi(String Ma_PC, String Ma_PN, String Ma_NV,java.util.Date ngayChi, int Tong_gia,boolean check) {
        DTO_PhieuChi updatePC = new DTO_PhieuChi(Ma_PC, Ma_PN, Ma_NV, ngayChi, Tong_gia, check);

        return suaPhieuChi(updatePC);
    }

    public void close() {
        connection.closeConnectionDB();
    }
}
