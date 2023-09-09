package BUS;

import java.util.ArrayList;
import javax.swing.JOptionPane;

import DAL.DAL_Taikhoan;
import DTO.DTO_Taikhoan;

public class BUS_taiKhoan {
	ArrayList<DTO_Taikhoan> listTK = new ArrayList<>();
	DAL_Taikhoan dalTK = new DAL_Taikhoan();
	
	public BUS_taiKhoan() {
		listTK = dalTK.readDB();
	}
	
	public ArrayList<DTO_Taikhoan> getListTK() {
		return listTK;
	}
	
	public DTO_Taikhoan getTK(String tk) {
		for(DTO_Taikhoan tk1: listTK) {
			if(tk1.getTen_TK().equals(tk1)) {
				return tk1;
			}
		}
		return null;
	}
	
	public DTO_Taikhoan getMK(String mk) {
		for(DTO_Taikhoan tk: listTK) {
			if(tk.getMat_khau().equals(mk)) {
				return tk;
			}
		}
		return null;
	}

    public int getSTTNext() {
    	ArrayList<DTO_Taikhoan> list = dalTK.readDB();
    	int max = 0;
    	for (DTO_Taikhoan dt : list) {
    		int STT = dt.getSo_TK();
    		if(STT > max) {
    			max = STT;
    		}
		}
    	return max+1;
    }
	
	public boolean checkSTT(int STT) {
		for (DTO_Taikhoan dt : listTK) {
			if(dt.getSo_TK() == STT) {
				return false;
			}
		}
		return true;
	}
	
	public boolean add(DTO_Taikhoan tk) {
		boolean check = dalTK.addTK(tk);
	
		if(check && checkSTT(tk.getSo_TK())) {
			listTK.add(tk);
			JOptionPane.showMessageDialog(null, "Thêm thành công");
		}
		return check;
	}
	
	public boolean addTKToTable(int STT,String tenTK,String matKhau,String SDT,java.sql.Date ngayTao,boolean check_Exist) {
		DTO_Taikhoan tk = new DTO_Taikhoan(STT, tenTK, matKhau, SDT, ngayTao, check_Exist);
		
		return add(tk);
	}
	
	
	public boolean update(int STT,String tenTK,String matKhau,String SDT,java.sql.Date ngayTao,boolean check_Exist) {
		boolean check = dalTK.updateTK(STT, tenTK, matKhau, SDT, ngayTao, check_Exist);
		
		if(check) {
			for (DTO_Taikhoan dt : listTK) {
				if(dt.getSo_TK() == STT) {
					dt.setTen_TK(tenTK);
					dt.setMat_khau(matKhau);
					dt.setSDT(SDT);
					dt.setNgayTao(ngayTao);
					dt.setCheck_exist(check_Exist);
				}
			}
		}else {
			JOptionPane.showMessageDialog(null, "Update thất bại");
		}
		JOptionPane.showMessageDialog(null, "Update thành công");
		return check;
	}
	
	@SuppressWarnings("unlikely-arg-type")
	public boolean delete(int STT) {
		boolean check = dalTK.deleteTK(STT);
		if(check) {
			for (DTO_Taikhoan dt : listTK) {
				if(dt.getSo_TK() == STT) {
					System.out.println("OK LA");
//					listDT.remove(maDT);
					JOptionPane.showMessageDialog(null, "Xóa thành công");
				}
			}
		}
		return check;
	}
}
