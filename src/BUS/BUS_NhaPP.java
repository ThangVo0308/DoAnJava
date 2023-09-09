package BUS;

import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import DAL.DAL_NhaPP;
import DAL.DB_Connect;
import DTO.DTO_NhaPP;

public class BUS_NhaPP {
	ArrayList<DTO_NhaPP> listNPP = new ArrayList<>();
	DAL_NhaPP dalNPP = new DAL_NhaPP();
	
	public BUS_NhaPP() {
		listNPP = dalNPP.readDB();
	}
	
	public ArrayList<DTO_NhaPP> getListNPP() {
		return listNPP;
	}
	
	public DTO_NhaPP getNPP(String maNPP) {
		for(DTO_NhaPP dt: listNPP) {
			if(dt.getMa_NPP().equals(maNPP)) {
				return dt;
			}
		}
		return null;
	}
	
    public String getMaNPPNext() {
    	ArrayList<DTO_NhaPP> list = dalNPP.readDB();
    	int max = 0;
    	for (DTO_NhaPP dt : list) {
    		String maNPP = dt.getMa_NPP();
    		if(maNPP.length() >= 5) {
    			int currentMaNPP = Integer.parseInt(maNPP.substring(3));
    			if(currentMaNPP > max) {
    				max = currentMaNPP;
    			}
    		}
		}
    	return String.format("NPP%02d", max + 1);
    }
	
	public boolean checkMaNPP(String maNPP) {
		for (DTO_NhaPP dt : listNPP) {
			if(dt.getMa_NPP().equals(maNPP)) {
				return false;
			}
		}
		return true;
	}
	
	public boolean add(DTO_NhaPP npp) {
		boolean check = dalNPP.addNPP(npp);
	
		if(check && checkMaNPP(npp.getMa_NPP())) {
			listNPP.add(npp);
			JOptionPane.showMessageDialog(null, "Thêm thành công");
		}
		return check;
	}
	
	public boolean addNPPToTable(String ma_NPP, String ten_NPP, String diaChi, String sDT, String email, boolean checkExist) {
		DTO_NhaPP npp = new DTO_NhaPP(ma_NPP, ten_NPP, diaChi, sDT, email, checkExist);
		
		return add(npp);
	}
	
	
	public boolean update(String ma_NPP, String ten_NPP, String diaChi, String sDT, String email, boolean check_exist) {
		boolean check = dalNPP.updateNPP(ma_NPP, ten_NPP, diaChi, sDT, email, check_exist);
		
		if(check) {
			for (DTO_NhaPP dt : listNPP) {
				if(dt.getMa_NPP().equals(ma_NPP)) {
					dt.setTen_NPP(ten_NPP);
					dt.setDiaChi(diaChi);
					dt.setSDT(sDT);
                    dt.setEmail(email);
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
	public boolean delete(String maNPP) {
		boolean check = dalNPP.deleteNPP(maNPP);
		if(check) {
			for (DTO_NhaPP dt : listNPP) {
				if(dt.getMa_NPP().equals(maNPP)) {
					System.out.println("OK LA");
//					listNPP.remove(maNPP);
					JOptionPane.showMessageDialog(null, "Xóa thành công");
				}
			}
		}
		return check;
	}

	
	public ArrayList<DTO_NhaPP> searchNPP(String luaChon,String keyword) {
		ArrayList<DTO_NhaPP> kq = new ArrayList<>();
		for(DTO_NhaPP dt : listNPP) {
			switch(luaChon) {
				case "Mã nhà phân phối":
					if(String.valueOf(dt.getMa_NPP()).toLowerCase().contains(keyword.toLowerCase())) {
						kq.add(dt);
					}
					break;
				case "Tên nhà phân phối":
					if(String.valueOf(dt.getTen_NPP()).toLowerCase().contains(keyword.toLowerCase())) {
						kq.add(dt);
					}
					break;
                                case "Địa chỉ":
					if(String.valueOf(dt.getDiaChi()).toLowerCase().contains(keyword.toLowerCase())) {
						kq.add(dt);
					}
					break;
                                case "SĐT":
					if(String.valueOf(dt.getSDT()).toLowerCase().contains(keyword.toLowerCase())) {
						kq.add(dt);
					}
					break;
                                case "Email":
					if(String.valueOf(dt.getEmail()).toLowerCase().contains(keyword.toLowerCase())) {
						kq.add(dt);
					}
					break;        
				default: break;
			}
		}	
		return kq;
	}
}
