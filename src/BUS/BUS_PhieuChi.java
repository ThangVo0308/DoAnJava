package BUS;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import DAL.DAL_PhieuChi;
import DAL.DB_Connect;
import DTO.DTO_PhieuChi;

public class BUS_PhieuChi {
	ArrayList<DTO_PhieuChi> listPC = new ArrayList<>();
	DAL_PhieuChi dalPC = new DAL_PhieuChi();
	
	public BUS_PhieuChi() {
		listPC = dalPC.readDB();
	}
	
	public ArrayList<DTO_PhieuChi> getlistPC() {
		return listPC;
	}
	
	public DTO_PhieuChi getPC(String maPC) {
		for(DTO_PhieuChi cv: listPC) {
			if(cv.getMaPC().equals(maPC)) {
				return cv;
			}
		}
		return null;
	}
	
    public String getmaPCNext() {
    	ArrayList<DTO_PhieuChi> list = dalPC.readDB();
    	int max = 0;
    	for (DTO_PhieuChi cv : list) {
    		String maPC = cv.getMaPC();
    		if(maPC.length() >= 4) {
    			int currentMaPC = Integer.parseInt(maPC.substring(2));
    			if(currentMaPC > max) {
    				max = currentMaPC;
    			}
    		}
		}
    	return String.format("PC%02d", max + 1);
    }
	
	public boolean checkmaPC(String maPC) {
		for (DTO_PhieuChi cv : listPC) {
			if(cv.getMaPC().equals(maPC)) {
				return false;
			}
		}
		return true;
	}
	
	public boolean add(DTO_PhieuChi cv) {
		boolean check = dalPC.addPhieuChi(cv);
	
		if(check && checkmaPC(cv.getMaPC())) {
			listPC.add(cv);
			JOptionPane.showMessageDialog(null, "Thêm thành công");
		}
		return check;
	}
	
	public boolean addPCToTable(String maPC, String maPN, String maNV,Date ngayChi, int gia, boolean check_exist) {
		DTO_PhieuChi dt = new DTO_PhieuChi(maPC, maPN, maNV, ngayChi, gia, check_exist);
		
		return add(dt);
	}
	
	
	public boolean update(String maPC, String maPN, String maNV,Date ngayChi, int gia, boolean check_exist) {
		boolean check = dalPC.updatePhieuChi(maPC, maPN, maNV, ngayChi, gia, check_exist);
		
		if(check) {
			for (DTO_PhieuChi dt : listPC) {
				if(dt.getMaPC().equals(maPC)) {
					dt.setMaPN(maPN);
					dt.setNgayChi(ngayChi);
					dt.setGia(gia);
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
	public boolean delete(String maPC) {
		boolean check = dalPC.deletePhieuChi(maPC);
		if(check) {
			for (DTO_PhieuChi dt : listPC) {
				if(dt.getMaPC().equals(maPC)) {
					System.out.println("OK LA");
//					listPC.remove(maPC);
					JOptionPane.showMessageDialog(null, "Xóa thành công");
				}
			}
		}
		return check;
	}

	
	public ArrayList<DTO_PhieuChi> searchPC(String luaChon,String keyword) {
		ArrayList<DTO_PhieuChi> kq = new ArrayList<>();
		for(DTO_PhieuChi dt : listPC) {
			switch(luaChon) {
				case "Mã phiếu chi":
					if(String.valueOf(dt.getMaPC()).toLowerCase().contains(keyword.toLowerCase())) {
						kq.add(dt);
					}
					break;
				default: break;
			}
		}	
		return kq;
	}
}
