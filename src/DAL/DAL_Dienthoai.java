package DAL;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import DTO.DTO_Dienthoai;
import DTO.DTO_Hoadon;
import DTO.DTO_Nhanvien;

public class DAL_Dienthoai {
	DB_Connect connection;
	ArrayList<DTO_Dienthoai> listDT = new ArrayList<>();
	
	public DAL_Dienthoai() {
		
	}
	
	public void closeConnectionDALDT() {
		connection.closeConnectionDB();
	}
	
	@SuppressWarnings("unused")
	public ArrayList<DTO_Dienthoai> readDB() {
		connection = new DB_Connect();
		boolean check = connection.ConnectDB();
		ArrayList<DTO_Dienthoai> listDT = new ArrayList<>();
		try {
			if(check == true) {
				String query = "select * from Dien_thoai";
				ResultSet rs = connection.getSQLQuery(query);
				if(rs != null) {
					while(rs.next()) {
						 String maDT = rs.getString("Ma_DT");
						 String tenLoai = rs.getString("Ten_loai");
						 String maBH = rs.getString("Ma_BH");
						 String tinhNang = rs.getString("Tinh_nang");
						 String tenDT = rs.getString("Ten_DT");
						 int SL = rs.getInt("SL");
						 int giaTien = rs.getInt("Gia_tien");
						 String img = rs.getString("img");
						 boolean isDeleted = rs.getBoolean("IS_DELETED");
						 listDT.add(new DTO_Dienthoai(maDT, tenLoai, maBH, tinhNang, tenDT, SL, giaTien, img,isDeleted));
					}
				}
			}
		}catch (SQLException e){
			JOptionPane.showMessageDialog(null, "Không thể đọc dữ liệu từ DB nè ba");
			e.printStackTrace();
		}finally {
			connection.closeConnectionDB();
		}
		
		return listDT;
	}
	
	public boolean addDT(DTO_Dienthoai dt) {
		connection = new DB_Connect();
		boolean check = connection.sqlUpdate("insert into Dien_thoai (Ma_DT, Ten_loai, Ma_BH, Tinh_nang, Ten_DT, SL, Gia_tien, img, IS_DELETED) VALUES ('"
                + dt.getMa_DT() + "', '"
                + dt.getTenLoai() + "', '"
                + dt.getMaBH() + "', '"
                + dt.getTinhNang() + "', '"
                + dt.getTenDT() + "', '"
                + dt.getSL() + "', '"
                + dt.getGiaTien() + "', '"
                + dt.getImg() + "', '"
                + dt.isCheck_exist() + "')");
		connection.closeConnectionDB();
		return check;
	}
	
	public boolean deleteDT(String maDT) {
	    connection = new DB_Connect();   
	    boolean check = connection.sqlUpdate("update Dien_thoai set IS_DELETED='" + false + "' where Ma_DT='" + maDT + "'");
	    connection.closeConnectionDB();
	    return check;
	}
	
	
	public boolean updateDT(String maDT,String tenLoai,String maBH,String tenDT,String tinhNang,int SL,int giaTien,String imgSource,boolean checkExist) {
		connection = new DB_Connect();
		boolean check = connection.sqlUpdate("update Dien_thoai set "
	            + "Ten_DT='" + tenDT
	            + "', Tinh_nang='" + tinhNang
	            + "', SL='" + SL
	            + "', Gia_tien='" + giaTien
	            + "', img='" + imgSource
	            + "', Ten_loai='" + tenLoai
	            + "', Ma_BH='" + maBH
	            + "', IS_DELETED='" + checkExist
	            + "' where Ma_DT='" + maDT + "'");
		connection.closeConnectionDB();
		return check;
	}
	
	public ArrayList<DTO_Dienthoai> searchDT(String giaTien, String tenLoai) {
        connection = new DB_Connect();
        ArrayList<DTO_Dienthoai> listDTSearch = new ArrayList<>();
        String query = null;
        try {
        	if(giaTien.equals("Tất cả") && tenLoai.equals("Tất cả")) {
        		query = "select * from Dien_thoai";
        	}else if(giaTien.equals("Dưới 10 triệu") && tenLoai.equals("Tất cả")) {
        		query = "select * from Dien_thoai where Gia_tien < 10000000";
        	}else if(giaTien.equals("Từ 10 triệu đến 20 triệu") && tenLoai.equals("Tất cả")) {
        		query = "select * from Dien_thoai where Gia_tien >= 10000000 and Gia_tien <= 20000000";
        	}else if(giaTien.equals("Trên 20 triệu") && tenLoai.equals("Tất cả") ) {
        		query = "select * from Dien_thoai where Gia_tien > 20000000";
        	}else if(giaTien.equals("Tất cả") && !tenLoai.equals("Tất cả")) {
        		query = "select * from Dien_thoai where Ten_loai='" + tenLoai + "'";
        	}else if(giaTien.equals("Dưới 10 triệu") && !tenLoai.equals("Tất cả")) {
        		query = "select * from Dien_thoai where Gia_tien < 10000000";
        	}else if(giaTien.equals("Từ 10 triệu đến 20 triệu") && !tenLoai.equals("Tất cả")) {
        		query = "select * from Dien_thoai where Gia_tien >= 10000000 and Gia_tien <= 20000000";
        	}else if(giaTien.equals("Trên 20 triệu")) {
        		query = "select * from Dien_thoai where Gia_tien > 20000000";
        	}
        	
        	
        	if(!giaTien.equals("Tất cả") && !tenLoai.equals("Tất cả")) {
        		query += " and Ten_loai='" + tenLoai + "'";
        	}
        	System.out.println(query);
        	ResultSet rs = connection.getSQLQuery(query);
        	if (rs != null) {
                while (rs.next()) {
                	DTO_Dienthoai dt = new DTO_Dienthoai(
                			rs.getString("Ma_DT"),
                			rs.getString("Ten_loai"),
                			rs.getString("Ma_BH"),
                			rs.getString("Tinh_nang"),
                			rs.getString("Ten_DT"),
                			rs.getInt("SL"),
                			rs.getInt("Gia_tien"),
                			rs.getString("img"),
                			rs.getBoolean("IS_DELETED"));
                    listDTSearch.add(dt);
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Lỗi khi tìm dữ liệu trong bảng điện thoại");
            e.printStackTrace();
        } finally {
            connection.closeConnectionDB();
        }
        System.out.println("KAKAKA: "+listDTSearch);
        return listDTSearch;
    }
	
	
	
	
}
