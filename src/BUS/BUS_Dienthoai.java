package BUS;

import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import com.toedter.calendar.JDateChooser;

import DAL.DAL_Dienthoai;
import DAL.DAL_Hoadon;
import DAL.DB_Connect;
import DTO.DTO_Dienthoai;
import DTO.DTO_Hoadon;
import GUI.SanPhamForm;
import DTO.DTO_Dienthoai;

public class BUS_Dienthoai {
	ArrayList<DTO_Dienthoai> listDT = new ArrayList<>();
	DAL_Dienthoai dalDT = new DAL_Dienthoai();
	
	public BUS_Dienthoai() {
		listDT = dalDT.readDB();
	}
	
	public ArrayList<DTO_Dienthoai> getListDT() {
		return listDT;
	}
	
	public DTO_Dienthoai getDT(String maDT) {
		for(DTO_Dienthoai dt: listDT) {
			if(dt.getMa_DT().equals(maDT)) {
				return dt;
			}
		}
		return null;
	}
	
    public String getMaDTNext() {
    	ArrayList<DTO_Dienthoai> list = dalDT.readDB();
    	int max = 0;
    	for (DTO_Dienthoai dt : list) {
    		String maDT = dt.getMa_DT();
    		if(maDT.length() >= 4) {
    			int currentMaDT = Integer.parseInt(maDT.substring(2));
    			if(currentMaDT > max) {
    				max = currentMaDT;
    			}
    		}
		}
    	return String.format("DT%02d", max + 1);
    }
	
	public boolean checkMaDT(String maDT) {
		for (DTO_Dienthoai dt : listDT) {
			if(dt.getMa_DT().equals(maDT)) {
				return false;
			}
		}
		return true;
	}
	
	public boolean add(DTO_Dienthoai dt) {
		boolean check = dalDT.addDT(dt);
	
		if(check && checkMaDT(dt.getMa_DT())) {
			listDT.add(dt);
			JOptionPane.showMessageDialog(null, "Thêm thành công");
		}
		return check;
	}
	
	public boolean addDTToTable(String ma_DT, String tenLoai, String maBH, String tinhNang, String tenDT, int sL, int giaTien,
			String img, boolean check_exist) {
		DTO_Dienthoai dt = new DTO_Dienthoai(ma_DT, tenLoai, maBH, tinhNang, tenDT, sL, giaTien, img, check_exist);
		
		return add(dt);
	}
	
	
	public boolean update(String ma_DT, String tenLoai, String maBH, String tinhNang, String tenDT, int sL, int giaTien,
			String img, boolean check_exist) {
		boolean check = dalDT.updateDT(ma_DT, tenLoai, maBH, tenDT, tinhNang, sL, giaTien, img, check_exist);
		
		if(check) {
			for (DTO_Dienthoai dt : listDT) {
				if(dt.getMa_DT().equals(ma_DT)) {
					dt.setTenLoai(tenLoai);
					dt.setMaBH(maBH);
					dt.setTinhNang(tinhNang);
					dt.setTenDT(tenDT);
					dt.setSL(sL);
					dt.setGiaTien(giaTien);
					dt.setImg(img);
					dt.setCheck_exist(check_exist);
				}
			}
		}else {
			JOptionPane.showMessageDialog(null, "Update thất bại");
		}
		JOptionPane.showMessageDialog(null, "Update thành công");
		return check;
	}
	
	@SuppressWarnings("unlikely-arg-type")
	public boolean delete(String maDT) {
		boolean check = dalDT.deleteDT(maDT);
		if(check) {
			for (DTO_Dienthoai dt : listDT) {
				if(dt.getMa_DT().equals(maDT)) {
					System.out.println("OK LA");
//					listDT.remove(maDT);
					JOptionPane.showMessageDialog(null, "Xóa thành công");
				}
			}
		}
		return check;
	}

	
	public ArrayList<DTO_Dienthoai> searchDienThoai(String giaTien, String tenLoai) {
	    ArrayList<DTO_Dienthoai> listDTSearch = new ArrayList<>();
	    DAL_Dienthoai dalDT = new DAL_Dienthoai();

	    try {
	        listDTSearch = dalDT.searchDT(giaTien,tenLoai);
	    } catch (Exception e) {
	        // Xử lý ngoại lệ nếu có
	        e.printStackTrace();
	    }
	    return listDTSearch;
	}
}
