package BUS;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import DAL.DAL_Phieunhap;
import DAL.DB_Connect;
import DTO.DTO_Phieunhap;

public class BUS_Phieunhap {
	ArrayList<DTO_Phieunhap> listPN = new ArrayList<>();
	DAL_Phieunhap dalPN = new DAL_Phieunhap();
	
	public BUS_Phieunhap() {
		listPN = dalPN.readDB();
	}
	
	public ArrayList<DTO_Phieunhap> getlistPN() {
		return listPN;
	}
	
	public DTO_Phieunhap getPN(String maPN) {
		for(DTO_Phieunhap cv: listPN) {
			if(cv.getMa_PN().equals(maPN)) {
				return cv;
			}
		}
		return null;
	}
	
    public String getmaPNNext() {
    	ArrayList<DTO_Phieunhap> list = dalPN.readDB();
    	int max = 0;
    	for (DTO_Phieunhap cv : list) {
    		String maPN = cv.getMa_PN();
    		if(maPN.length() >= 4) {
    			int currentMaPN = Integer.parseInt(maPN.substring(2));
    			if(currentMaPN > max) {
    				max = currentMaPN;
    			}
    		}
		}
    	return String.format("PN%02d", max + 1);
    }
	
	public boolean checkmaPN(String maPN) {
		for (DTO_Phieunhap cv : listPN) {
			if(cv.getMa_PN().equals(maPN)) {
				return false;
			}
		}
		return true;
	}
	
	public boolean add(DTO_Phieunhap cv) {
		boolean check = dalPN.addPN(cv);
	
		if(check && checkmaPN(cv.getMa_PN())) {
			listPN.add(cv);
			JOptionPane.showMessageDialog(null, "Thêm thành công");
		}
		return check;
	}
	
	public boolean addPNToTable(String ma_PN, Date ngayNhap, int tongGia, String ma_NPP, boolean check_exist) {
		DTO_Phieunhap dt = new DTO_Phieunhap(ma_PN, ngayNhap, tongGia, ma_NPP, check_exist);
		
		return add(dt);
	}
	
	
	public boolean update(String ma_PN, java.sql.Date ngayNhap, int tongGia, String ma_NPP, boolean check_exist) {
		boolean check = dalPN.updatePN(ma_PN, ngayNhap, tongGia, ma_NPP, check_exist);
		
		if(check) {
			for (DTO_Phieunhap dt : listPN) {
				if(dt.getMa_PN().equals(ma_PN)) {
					dt.setNgayNhap(ngayNhap);
					dt.setTongGia(tongGia);
					dt.setMa_NPP(ma_NPP);
                    dt.setCheck_exist(check_exist);
				}
			}
//			JOptionPane.showMessageDialog(null, "Update thành công");
		}else {
			JOptionPane.showMessageDialog(null, "Update thất bại");
		}
		return check;
	}   
	
	@SuppressWarnings("unlikely-arg-type")
	public boolean delete(String maPN) {
		boolean check = dalPN.deletePN(maPN);
		if(check) {
			for (DTO_Phieunhap dt : listPN) {
				if(dt.getMa_PN().equals(maPN)) {
					System.out.println("OK LA");
					JOptionPane.showMessageDialog(null, "Xóa thành công");
				}
			}
		}
		return check;
	}

	
	public ArrayList<DTO_Phieunhap> searchPN(String luaChon,String keyword) {
		ArrayList<DTO_Phieunhap> kq = new ArrayList<>();
		for(DTO_Phieunhap dt : listPN) {
			switch(luaChon) {
				case "Mã phiếu nhập":
					if(String.valueOf(dt.getMa_PN()).toLowerCase().contains(keyword.toLowerCase())) {
						kq.add(dt);
					}
					break;
				default: break;
			}
		}	
		return kq;
	}
}
