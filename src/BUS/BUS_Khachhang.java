package BUS;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import DAL.DAL_Khachhang;
import DTO.DTO_Khachhang;

public class BUS_Khachhang {
    ArrayList<DTO_Khachhang> listKH = new ArrayList<>();
	private DAL_Khachhang khDAL = new DAL_Khachhang();
	
	public BUS_Khachhang() {
		listKH = khDAL.readDB();
	}
	
	public ArrayList<DTO_Khachhang> getListKH() {
		return listKH;
	}
        
    public void setListKH(ArrayList<DTO_Khachhang> listKH) {
		this.listKH = listKH;
	}
        
 
    public String getMaKHNext() {
    	ArrayList<DTO_Khachhang> list = khDAL.readDB();
    	int max = 0;
    	for (DTO_Khachhang kh : list) {
    		String maKH = kh.getMa_KH();
    		if(maKH.length() >= 4) {
    			int currentMaDT = Integer.parseInt(maKH.substring(2));
    			if(currentMaDT > max) {
    				max = currentMaDT;
    			}
    		}
		}
    	return String.format("KH%02d", max + 1);
}
        
	public DTO_Khachhang getmaKH(String maKH) {
		for(DTO_Khachhang kh: listKH) {
			if(kh.getMa_KH().equals(maKH)) {
				return kh;
			}
		}
		return null;
	}
	
	public boolean checkMaKH(String maKH) {
		for (DTO_Khachhang kh : listKH) {
			if(kh.getMa_KH().equals(maKH)) {
				return false;
			}
		}
		return true;
	}
	
	public void checkInput(String maKH,String maDT,int SL,float gia,JPanel jp) {
		try {
			// unfinished
			Integer.parseInt(Integer.toString(SL));
			Float.parseFloat(Float.toString(gia));
		}catch(NumberFormatException e) {
			JOptionPane.showMessageDialog(jp, "Dữ liệu truyền vào không phải chữ");
		}
	}
	
	public boolean add(DTO_Khachhang kh) {
		boolean check = khDAL.addKH(kh);
	
		if(check && checkMaKH(kh.getMa_KH())) {
			listKH.add(kh);
			JOptionPane.showMessageDialog(null, "Thêm thành công");
		}
		return check;
	}
	
	public boolean addKHToTable(String ma_KH, String ten_KH, String diaChi, String sDT, boolean check_exist) {
		DTO_Khachhang kh = new DTO_Khachhang(ma_KH, ten_KH, diaChi, sDT, check_exist);
		
		return add(kh);
	}
	
	
	public boolean update(String ma_KH, String ten_KH, String diaChi, String sDT, boolean check_exist) {
		boolean check = khDAL.updateKH(ma_KH, ten_KH, diaChi, sDT, check_exist);
		
		if(check) {
			for (DTO_Khachhang kh : listKH) {
				if(kh.getMa_KH().equals(ma_KH)) {
					kh.setTen_KH(ten_KH);
					kh.setDiaChi(diaChi);
					kh.setSDT(sDT);
					kh.setCheck_exist(check_exist);
				}
			}
		}else {
			JOptionPane.showMessageDialog(null, "Update thất bại");
		}
		JOptionPane.showMessageDialog(null, "Update thành công");
		return check;
	}
	
	@SuppressWarnings("unlikely-arg-type")
	public boolean delete(String maKH) {
		boolean check = khDAL.deleteKH(maKH);
		
		if(check) {
			for (DTO_Khachhang kh : listKH) {
				if(kh.getMa_KH().equals(maKH)) {
//					listKH.remove(maKH);
					JOptionPane.showMessageDialog(null, "Xóa thành công");
				}
			}
		}
		return check;
	}
}
