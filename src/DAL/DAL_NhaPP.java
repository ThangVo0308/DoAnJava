package DAL;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import DTO.DTO_NhaPP;

public class DAL_NhaPP {

    DB_Connect connection;

    public DAL_NhaPP() {

    }

    public ArrayList<DTO_NhaPP> readDB() {
        ArrayList<DTO_NhaPP> listNPP = new ArrayList<>();
        connection = new DB_Connect();
        try {
            String query = "select * from Nha_PP";
            ResultSet rs = connection.getSQLQuery(query);
            if (rs != null) {
                while (rs.next()) {
                    DTO_NhaPP npp = new DTO_NhaPP(
                    		 rs.getString("Ma_NPP"),
                             rs.getString("Ten_NPP"),
                             rs.getString("Dia_chi"),
                             rs.getString("SDT"),
                             rs.getString("email"),
                             rs.getBoolean("check_exist"));
                    listNPP.add(npp);
                }
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Khong tim thay du lieu!");
            e.printStackTrace();
        } finally {
            connection.closeConnectionDB();
        }
        return listNPP;
    }

    public ArrayList<DTO_NhaPP> searchNPP(String columnName, String keyword) {
        connection = new DB_Connect();
        ArrayList<DTO_NhaPP> listNPP = new ArrayList<>();

        try {
            String query = "select * from Nha_PP where " + columnName + " like '%d" + keyword + "%'";
            ResultSet rs = connection.getSQLQuery(query);
            if (rs != null) {
                while (rs.next()) {
                    DTO_NhaPP npp = new DTO_NhaPP(
                            rs.getString("Ma_NPP"),
                            rs.getString("Ten_NPP"),
                            rs.getString("Dia_chi"),
                            rs.getString("SDT"),
                            rs.getString("email"),
                            rs.getBoolean("check_exist"));
                    listNPP.add(npp);
                }
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "-- ERROR! Lỗi tìm dữ liệu " + columnName + " = " + keyword + " bảng nhà phân phối");
            e.printStackTrace();
        } finally {
            connection.closeConnectionDB();
        }

        return listNPP;
    }

    public boolean addNPP(DTO_NhaPP npp) {
    	connection = new DB_Connect();
        boolean add = connection.sqlUpdate("insert into Nha_PP(Ma_NPP,Ten_NPP,Dia_chi,SDT,email,check_exist) values ('"
        		+ npp.getMa_NPP() + "','"
        		+ npp.getTen_NPP() + "','"
        		+ npp.getDiaChi() + "','"
        		+ npp.getSDT() + "','"
        		+ npp.getEmail() + "','"
        		+ npp.isCheck_exist() + "')");
        return add;
    }

    public boolean deleteNPP(String MaNPP) {
        connection = new DB_Connect();
        boolean del = connection.sqlUpdate("update Nha_PP set check_exist='" + false + "' where Ma_NPP='" + MaNPP + "'");
        connection.closeConnectionDB();
        return del;
    }

    public boolean suaNPP(DTO_NhaPP npp) {
        connection = new DB_Connect();
        boolean fix = connection.sqlUpdate("update Nha_PP set "
                + "Ten_NPP='" + npp.getTen_NPP()
                + "',Dia_chi='" + npp.getDiaChi()
                + "',SDT='" + npp.getSDT()
                + "',email='" + npp.getEmail()
                + "',check_exist='" + npp.isCheck_exist()
                + "' where Ma_NPP='" + npp.getMa_NPP() + "';");
        connection.closeConnectionDB();
        return fix;
    }

    public boolean updateNPP(String MaNPP, String TenNPP, String Diachi, String SDT, String Email,boolean check_exist) {
        DTO_NhaPP updateNPP = new DTO_NhaPP(MaNPP, TenNPP, Diachi, SDT, Email,check_exist);
        return suaNPP(updateNPP);
    }

    public void close() {
        connection.closeConnectionDB();
    }
}
