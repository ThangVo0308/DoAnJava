package BUS;

import java.util.ArrayList;
import javax.swing.JOptionPane;

import DAL.DAL_LoaiDT;
import DTO.DTO_LoaiDT;

public class BUS_LoaiDT {
    ArrayList<DTO_LoaiDT> listLoaiDT = new ArrayList<>();
	private DAL_LoaiDT ldtDAL = new DAL_LoaiDT();
	
	public BUS_LoaiDT() {
		listLoaiDT = ldtDAL.readDB();
	}
	
	public ArrayList<DTO_LoaiDT> getlistLoaiDT() {
		return listLoaiDT;
	}
  
	public DTO_LoaiDT getmaLoaiDT(String maLoaiDT) {
		for(DTO_LoaiDT ldt: listLoaiDT) {
			if(ldt.getMaLoai().equals(maLoaiDT)) {
				return ldt;
			}
		}
		return null;
	}
	
	public String getMaLDTNext() {
    	ArrayList<DTO_LoaiDT> list = ldtDAL.readDB();
    	int max = 0;
    	for (DTO_LoaiDT ldt : list) {
    		String maLDT = ldt.getMaLoai();
    		if(maLDT.length() >= 5) {
    			int currentMaLDT = Integer.parseInt(maLDT.substring(3));
    			if(currentMaLDT > max) {
    				max = currentMaLDT;
    			}
    		}
		}
    	return String.format("LDT%02d", max + 1);
    }
	
	public boolean checkmaLoaiDT(String maLoaiDT) {
		for (DTO_LoaiDT ldt : listLoaiDT) {
			if(ldt.getMaLoai().equals(maLoaiDT)) {
				return false;
			}
		}
		return true;
	}
	
	public boolean add(DTO_LoaiDT ldt) {
		boolean check = ldtDAL.addLDT(ldt);
	
		if(check && checkmaLoaiDT(ldt.getMaLoai())) {
			listLoaiDT.add(ldt);
			JOptionPane.showMessageDialog(null, "Thêm thành công");
		}
		return check;
	}
	
	public boolean addLDTToTable(String maLoai, String tenLoai, String moTa, boolean checkExist) {
		DTO_LoaiDT ldt = new DTO_LoaiDT(maLoai, tenLoai, moTa, checkExist);
		
		return add(ldt);
	}
	
	public boolean update(String maLoai, String tenLoai, String moTa, boolean checkExist) {
		boolean check =	ldtDAL.updateLDT(maLoai, tenLoai, moTa, checkExist);
		
		if(check) {
			for (DTO_LoaiDT ldt : listLoaiDT) {
				if(ldt.getMaLoai().equals(maLoai)) {
					ldt.setTenLoai(tenLoai);
					ldt.setMoTa(moTa);
					ldt.setCheckExist(checkExist);
				}
			}
			JOptionPane.showMessageDialog(null, "Update thành công");
		}else {
			JOptionPane.showMessageDialog(null, "Update thất bại");
		}
		return check;
	}
	
	public boolean delete(String maLoaiDT) {
		boolean check = ldtDAL.deleteLDT(maLoaiDT);
		
		if(check) {
			for (DTO_LoaiDT ldt : listLoaiDT) {
				if(ldt.getMaLoai().equals(maLoaiDT)) {
//					listLoaiDT.remove(maLoaiDT);
					JOptionPane.showMessageDialog(null, "Xóa thành công");
				}
			}
		}
		return check;
	}
	
}
