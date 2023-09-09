package BUS;

import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import DAL.DAL_Chucvu;
import DTO.DTO_Chucvu;
// unfinished
public class BUS_Chucvu {
	ArrayList<DTO_Chucvu> listCV = new ArrayList<>();
	private DAL_Chucvu cvDAL = new DAL_Chucvu();
	
	public BUS_Chucvu() {
		listCV = cvDAL.readDB();
	}
	
	public ArrayList<DTO_Chucvu> getListCV() {
		return listCV;
	}
	
	public DTO_Chucvu getmaCV(String maCV) {
		for(DTO_Chucvu cv: listCV) {
			if(cv.getMa_CV().equals(maCV)) {
				return cv;
			}
		}
		return null;
	}
	
	public void checkInput(String maCV,String maDT,int SL,float gia,JPanel jp) {
		try {
			// unfinished
			Integer.parseInt(Integer.toString(SL));
			Float.parseFloat(Float.toString(gia));
		}catch(NumberFormatException e) {
			JOptionPane.showMessageDialog(jp, "Dữ liệu truyền vào không phải chữ");
		}
	}
	
	public String getMaCVNext() {
    	ArrayList<DTO_Chucvu> list = cvDAL.readDB();
    	int max = 0;
    	for (DTO_Chucvu cv : list) {
    		String maCV = cv.getMa_CV();
    		if(maCV.length() >= 4) {
    			int currentMaDT = Integer.parseInt(maCV.substring(2));
    			if(currentMaDT > max) {
    				max = currentMaDT;
    			}
    		}
		}
    	return String.format("CV%02d", max + 1);
    }
	
	public boolean checkMaCV(String maCV) {
		for (DTO_Chucvu cv : listCV) {
			if(cv.getMa_CV().equals(maCV)) {
				return false;
			}
		}
		return true;
	}
	
	public boolean add(DTO_Chucvu cv) {
		boolean check = cvDAL.addChucVU(cv);
	
		if(check && checkMaCV(cv.getMa_CV())) {
			listCV.add(cv);
			JOptionPane.showMessageDialog(null, "Thêm thành công");
		}
		return check;
	}
	
	public boolean addCVToTable(String ma_CV, String ten_CV, String moTa, boolean check_exist) {
		DTO_Chucvu cv = new DTO_Chucvu(ma_CV, ten_CV, moTa, check_exist);
		
		return add(cv);
	}
	
	
	public boolean update(String ma_CV, String ten_CV, String moTa, boolean check_exist) {
		boolean check = cvDAL.updateChucVU(ma_CV, ten_CV, moTa, check_exist);
		
		if(check) {
			for (DTO_Chucvu cv : listCV) {
				if(cv.getMa_CV().equals(ma_CV)) {
					cv.setTen_CV(ten_CV);
					cv.setMoTa(moTa);
					cv.setCheck_exist(check_exist);
				}
			}
		}else {
			JOptionPane.showMessageDialog(null, "Update thất bại");
		}
		JOptionPane.showMessageDialog(null, "Update thành công");
		return check;
	}
	
	@SuppressWarnings("unlikely-arg-type")
	public boolean delete(String maCV) {
		boolean check = cvDAL.deleteChucVu(maCV);
		if(check) {
			for (DTO_Chucvu cv : listCV) {
				if(cv.getMa_CV().equals(maCV)) {
					System.out.println("OK LA");
//					listDT.remove(maDT);
					JOptionPane.showMessageDialog(null, "Xóa thành công");
				}
			}
		}
		return check;
	}

	
//	public ArrayList<DTO_Dienthoai> searchDT(String luaChon,String keyword) {
//		ArrayList<DTO_Dienthoai> kq = new ArrayList<>();
//		for(DTO_Dienthoai dt : listDT) {
//			switch(luaChon) {
//				case "Mã điện thoại":
//					if(String.valueOf(dt.getMa_DT()).toLowerCase().contains(keyword.toLowerCase())) {
//						kq.add(dt);
//					}
//					break;
//				case "Số lượng":
//					if(String.valueOf(dt.getSL()).toLowerCase().contains(keyword.toLowerCase())) {
//						kq.add(dt);
//					}
//					break;
//				case "Giá":
//					if(String.valueOf(dt.getGia()).toLowerCase().contains(keyword.toLowerCase())) {
//						kq.add(dt);
//					}
//					break;
//				case "Điện thoại có giá từ 5 triệu đến 10 triệu":
//					if(dt.getGia() >= 5000000 && dt.getGia() <= 10000000) {
//						kq.add(dt);
//					}
//					break;
//				case "Điện thoại có giá từ 11 triệu đến 20 triệu":
//					if(dt.getGia() >= 11000000 && dt.getGia() <= 20000000) {
//						kq.add(dt);
//					}
//					break;
//				case "Điện thoại có giá trị lớn hơn 20 triệu":
//					if(dt.getGia() > 20000000) {
//						kq.add(dt);
//					}
//					break;
//				default: break;
//			}
//		}	
//		return kq;
//	}
}
