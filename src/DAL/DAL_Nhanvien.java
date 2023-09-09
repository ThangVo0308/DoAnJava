package DAL;

import java.sql.ResultSet;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

import DTO.DTO_Nhanvien;

public class DAL_Nhanvien {

    DB_Connect connection;

    public DAL_Nhanvien() {

    }

    public ArrayList<DTO_Nhanvien> readDB() {
        ArrayList<DTO_Nhanvien> listNV = new ArrayList<>();
        connection = new DB_Connect();
        try {
            String query = "select * from Nhan_vien";
            ResultSet rs = connection.getSQLQuery(query);
            if (rs != null) {
                while (rs.next()) {
                    DTO_Nhanvien nv = new DTO_Nhanvien(
                            rs.getString("Ma_NV"),
                            rs.getString("Ten_NV"),
                            rs.getString("Ma_CV"),
                            rs.getString("Dia_chi"),
                            rs.getString("SDT"),
                            rs.getBoolean("Gioi_tinh"),
                            rs.getDate("Ngay_sinh"),
                            rs.getString("So_CMND"),
                            rs.getBoolean("check_exist"));
                    listNV.add(nv);
                }
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Khong tim thay du lieu!");
            e.printStackTrace();
        } finally {
            connection.closeConnectionDB();
        }
        return listNV;
    }
    

    @SuppressWarnings("unused")
    public ArrayList<DTO_Nhanvien> searchNV(String gioiTinh, String maCV) {
        connection = new DB_Connect();
        ArrayList<DTO_Nhanvien> listNVSearch = new ArrayList<>();
        String query = null;
        try {
        	if (maCV.equals("Tất cả") && gioiTinh.equals("Tất cả")) {
                query = "SELECT * FROM Nhan_vien";
            }else if(gioiTinh.equals("Tất cả") && !maCV.equals("Tất cả")) {
            	query = "SELECT * FROM Nhan_vien where Ma_CV='"+maCV+"'";
            }else {
            	int checkGT = 0;
            	if(gioiTinh.equals("Nam")) {
            		checkGT = 1;
            	}else if(gioiTinh.equals("Nữ")) {
            		checkGT = 0;
            	}
                query = "SELECT * FROM Nhan_vien WHERE Gioi_tinh=" + checkGT;
                if (!maCV.equals("Tất cả")) {
                    query += " AND Ma_CV='" + maCV + "'";
                }
                if (maCV == null && gioiTinh.equals(query)) {
                	query = "SELECT * FROM Nhan_vien";
                }
            }
        	System.out.println(query);
       
        	ResultSet rs = connection.getSQLQuery(query);
            if (rs != null) {
                while (rs.next()) {
                    DTO_Nhanvien nv = new DTO_Nhanvien(
                        rs.getString("Ma_NV"),
                        rs.getString("Ten_NV"),
                        rs.getString("Ma_CV"),
                        rs.getString("Dia_chi"),
                        rs.getString("SDT"),
                        rs.getBoolean("Gioi_tinh"),
                        rs.getDate("Ngay_sinh"),
                        rs.getString("So_CMND"),
                        rs.getBoolean("check_exist")
                    );
                    listNVSearch.add(nv);
                }
            }
            query = null;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Lỗi khi tìm dữ liệu trong bảng nhân viên");
            e.printStackTrace();
        } finally {
            connection.closeConnectionDB();
        }
        return listNVSearch;
    }



    public boolean addNV(DTO_Nhanvien nv) {
    	connection = new DB_Connect();
    	boolean add = connection.sqlUpdate("INSERT INTO Nhan_vien (Ma_NV, Ten_NV, Ma_CV, Dia_chi, SDT, Gioi_tinh, Ngay_sinh, So_CMND, check_exist) VALUES ('"
    	                + nv.getMaNV() + "', '"
    	                + nv.getTenNV() + "', '"
    	                + nv.getMaCV() + "', '"
    	                + nv.getDiaChi() + "', '"
    	                + nv.getSDT() + "', '"
    	                + nv.isGioiTinh() + "', '"
    	                + nv.getNgaySinh() + "', '"
    	                + nv.getSoCMND() + "', '"
    	                + nv.isCheck_exist() + "')");
    	connection.closeConnectionDB();
    	return add;

    }

    public boolean deleteNV(String manv) {
        connection = new DB_Connect();
        boolean del = connection.sqlUpdate("update Nhan_vien set check_exist='" + false + "' where Ma_NV='" + manv + "'");
        connection.closeConnectionDB();
        return del;
    }

    public boolean suaNV(DTO_Nhanvien nv) {
        connection = new DB_Connect();
        boolean fix = connection.sqlUpdate("update Nhan_vien set "
                + "Ten_NV='" + nv.getTenNV()
                + "',Ma_CV='" + nv.getMaCV()
                + "',Dia_chi='" + nv.getDiaChi()
                + "',SDT='" + nv.getSDT()
                + "',Gioi_tinh='" + nv.isGioiTinh()
                + "',Ngay_sinh='" + nv.getNgaySinh()
                + "',So_CMND='" + nv.getSoCMND()
                + "' WHERE Ma_NV='" + nv.getMaNV() + "';");
        connection.closeConnectionDB();
        return fix;
    }

    public boolean updateNV(String MaNV, String TenNV, String maCV,String diaChi,String SDT,boolean gioiTinh,java.sql.Date ngaySinh,String soCMND,boolean check_exist) {
        DTO_Nhanvien updateNV = new DTO_Nhanvien(MaNV, TenNV, maCV, diaChi, SDT, gioiTinh, ngaySinh, soCMND, check_exist);
        return suaNV(updateNV);
    }

    public void close() {
        connection.closeConnectionDB();
    }
}
