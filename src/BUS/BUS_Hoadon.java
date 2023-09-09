package BUS;

import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;

import com.toedter.calendar.JDateChooser;

import DAL.DAL_Hoadon;
import DAL.DAL_Nhanvien;
import DTO.DTO_Dienthoai;
import DTO.DTO_Hoadon;
import DTO.DTO_Nhanvien;

public class BUS_Hoadon {
	ArrayList<DTO_Hoadon> listHD = new ArrayList<>();
	private DAL_Hoadon hdDAL = new DAL_Hoadon();
	
	public BUS_Hoadon() {
		listHD = hdDAL.readDB();
	}
	
	public void readDB() {
		listHD = hdDAL.readDB();
	}
	    
	public ArrayList<DTO_Hoadon> getListHD() {
		return listHD;
	}

	public void setListHD(ArrayList<DTO_Hoadon> listHD) {
		this.listHD = listHD;
	}
	
	public DAL_Hoadon getHdDAL() {
		return hdDAL;
	}

	public void setHdDAL(DAL_Hoadon hdDAL) {
		this.hdDAL = hdDAL;
	}
	
	public DTO_Hoadon getHD(String maHD) {
		for(DTO_Hoadon hd: listHD) {
			if(hd.getMa_HD().equals(maHD)) {
				return hd;
			}
		}
		return null;
	}
	
	public boolean checkMaHD(String maHD) {
		for(DTO_Hoadon ct : listHD) {
			if(ct.getMa_HD().equals(maHD)) {
				return false;
			}
		}
		return true; 
	}
	
	 public String getMaHDNext() {
	    	ArrayList<DTO_Hoadon> list = hdDAL.readDB();
	    	int max = 0;
	    	for (DTO_Hoadon hd : list) {
	    		String maHD = hd.getMa_HD();
	    		if(maHD.length() >= 4) {
	    			int currentMaDT = Integer.parseInt(maHD.substring(2));
	    			if(currentMaDT > max) {
	    				max = currentMaDT;
	    			}
	    		}
			}
	    	return String.format("HD%02d", max + 1);
	}
	 
	 public boolean add(DTO_Hoadon hd) {
			boolean check = hdDAL.addHoadon(hd);
		
			if(check && checkMaHD(hd.getMa_HD())) {
				hdDAL.addHoadon(hd);
				JOptionPane.showMessageDialog(null, "Thêm thành công");
			}
			return check;
		}
		
	public boolean addHDToTable(String ma_HD, java.sql.Date ngayLap_HD, int tongTien, String ma_KH, String ma_NV,boolean check) {
		DTO_Hoadon hd = new DTO_Hoadon(ma_HD, ngayLap_HD, tongTien, ma_KH, ma_NV,check);
		return add(hd);
	}
		
		
	public boolean update(String ma_HD, java.sql.Date ngayLap_HD, int tongTien, String ma_KH, String ma_NV,boolean check_exist) {
		boolean check = hdDAL.updateHD(ma_HD, ngayLap_HD, tongTien, ma_KH, ma_NV,check_exist);
			if(check) {
				for (DTO_Hoadon hd : listHD) {
					if(hd.getMa_HD().equals(ma_HD)) {
						hd.setNgayLap_HD(ngayLap_HD);
						hd.setTongTien(tongTien);
						hd.setMa_KH(ma_KH);
						hd.setMa_NV(ma_NV);
						hd.setCheck_exist(check_exist);
					}
				}
				JOptionPane.showMessageDialog(null, "Update thành công");
			}else {
				JOptionPane.showMessageDialog(null, "Update thất bại");
			}
			return check;
			
		}
	
	public boolean delete(String maHD) {
		boolean check = hdDAL.deleteHoadon(maHD);
		if(check) {
			for (DTO_Hoadon hd : listHD) {
				if(hd.getMa_HD().equals(maHD)) {
					System.out.println("OK LA");
					JOptionPane.showMessageDialog(null, "Xóa thành công");
				}
			}
		}
		return check;
	}
	
	public ArrayList<DTO_Hoadon> searchHoaDon(String tongTien, JDateChooser ngayLap1, JDateChooser ngayLap2) {
	    ArrayList<DTO_Hoadon> listHDSearch = new ArrayList<>();
	    DAL_Hoadon dalHD = new DAL_Hoadon();

	    if (ngayLap1.getDate().after(ngayLap2.getDate())) {
	        // Xử lý ngoại lệ nếu ngayLap1 lớn hơn ngayLap2
	        JOptionPane.showMessageDialog(null, "Ngày lập 1 không thể lớn hơn ngày lập 2");
	    }

	    try {
	        listHDSearch = dalHD.searchHD(tongTien, ngayLap1, ngayLap2);
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return listHDSearch;
	}
}
