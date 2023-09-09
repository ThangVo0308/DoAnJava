package BUS;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import DAL.DAL_PhieuBH;
import DAL.DB_Connect;
import DTO.DTO_PhieuBH;

public class BUS_PhieuBH {
	ArrayList<DTO_PhieuBH> listPBH = new ArrayList<>();
	DAL_PhieuBH dalPBH = new DAL_PhieuBH();
	
	public BUS_PhieuBH() {
		listPBH = dalPBH.readDB();
	}
	
	public ArrayList<DTO_PhieuBH> getlistPBH() {
		return listPBH;
	}
	
	public DTO_PhieuBH getPC(String maPBH) {
		for(DTO_PhieuBH cv: listPBH) {
			if(cv.getMa_BH().equals(maPBH)) {
				return cv;
			}
		}
		return null;
	}
	
    public String getmaPBHNext() {
    	ArrayList<DTO_PhieuBH> list = dalPBH.readDB();
    	int max = 0;
    	for (DTO_PhieuBH cv : list) {
    		String maPBH = cv.getMa_BH();
    		if(maPBH.length() >= 4) {
    			int currentMaPBH = Integer.parseInt(maPBH.substring(2));
    			if(currentMaPBH > max) {
    				max = currentMaPBH;
    			}
    		}
		}
    	return String.format("BH%02d", max + 1);
    }
	
	public boolean checkmaPBH(String maPBH) {
		for (DTO_PhieuBH cv : listPBH) {
			if(cv.getMa_BH().equals(maPBH)) {
				return false;
			}
		}
		return true;
	}
	
	public boolean add(DTO_PhieuBH cv) {
		boolean check = dalPBH.addPBH(cv);
	
		if(check && checkmaPBH(cv.getMa_BH())) {
			listPBH.add(cv);
			JOptionPane.showMessageDialog(null, "Thêm thành công");
		}
		return check;
	}
	
	public boolean addBHToTable(String ma_BH, String ten_BH, String diaChi, Date ngay_banHang, String tG_baoHanh,
			Date ngay_Het_Han, boolean check_exist) {
		DTO_PhieuBH dt = new DTO_PhieuBH(ma_BH, ten_BH, diaChi, ngay_banHang, tG_baoHanh, ngay_Het_Han, check_exist);
		
		return add(dt);
	}
	
	
	public boolean update(String ma_BH, String ten_BH, String diaChi, Date ngay_banHang, String tG_baoHanh,
			Date ngay_Het_Han, boolean check_exist) {
		boolean check = dalPBH.updatePBH(ma_BH, ten_BH, diaChi, null, tG_baoHanh, null, check_exist);
		
		if(check) {
			for (DTO_PhieuBH dt : listPBH) {
				if(dt.getMa_BH().equals(ma_BH)) {
					dt.setTen_BH(ten_BH);
					dt.setDiaChi(diaChi);
                    dt.setNgay_banHang(ngay_banHang);
                    dt.setTG_baoHanh(tG_baoHanh);
                    dt.setNgay_Het_Han(ngay_Het_Han);
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
	public boolean delete(String maPBH) {
		boolean check = dalPBH.deletePBH(maPBH);
		if(check) {
			for (DTO_PhieuBH dt : listPBH) {
				if(dt.getMa_BH().equals(maPBH)) {
					System.out.println("OK LA");
//					listPBH.remove(maPBH);
					JOptionPane.showMessageDialog(null, "Xóa thành công");
				}
			}
		}
		return check;
	}

	
	public ArrayList<DTO_PhieuBH> searchPC(String luaChon,String keyword) {
		ArrayList<DTO_PhieuBH> kq = new ArrayList<>();
		for(DTO_PhieuBH dt : listPBH) {
			switch(luaChon) {
				case "Mã phiếu chi":
					if(String.valueOf(dt.getMa_BH()).toLowerCase().contains(keyword.toLowerCase())) {
						kq.add(dt);
					}
					break;
				default: break;
			}
		}	
		return kq;
	}
}
