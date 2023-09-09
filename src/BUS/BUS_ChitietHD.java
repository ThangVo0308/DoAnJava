package BUS;

import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import DAL.DAL_ChitietHD;
import DAL.DAL_Dienthoai;
import DAL.DAL_Hoadon;
import DTO.DTO_ChitietHD;
import DTO.DTO_Hoadon;

// can nhac xoa
public class BUS_ChitietHD {
	ArrayList<DTO_ChitietHD> listCTHD = new ArrayList<>();
	private DAL_ChitietHD cthdDAL = new DAL_ChitietHD();
	private DAL_Hoadon hdDAL = new DAL_Hoadon();
	private DAL_Dienthoai dtDAL = new DAL_Dienthoai();
	
	public BUS_ChitietHD() {
		listCTHD = cthdDAL.readDB();
	}
	
	public void readDB() {
		listCTHD = cthdDAL.readDB();
	}

	public ArrayList<DTO_ChitietHD> getListCTHD() {
		return listCTHD;
	}

	public void setListCTHD(ArrayList<DTO_ChitietHD> listCTHD) {
		this.listCTHD = listCTHD;
	}

	public DAL_ChitietHD getCthdDAL() {
		return cthdDAL;
	}

	public void setCthdDAL(DAL_ChitietHD cthdDAL) {
		this.cthdDAL = cthdDAL;
	}

	public DAL_Hoadon getHdDAL() {
		return hdDAL;
	}

	public void setHdDAL(DAL_Hoadon hdDAL) {
		this.hdDAL = hdDAL;
	}

	public DAL_Dienthoai getDtDAL() {
		return dtDAL;
	}

	public void setDtDAL(DAL_Dienthoai dtDAL) {
		this.dtDAL = dtDAL;
	}
	
	public int getSL() {
		return listCTHD.size();
	}
	
	public float getTongTien() {
		float tong = 0;
		for(DTO_ChitietHD ct : listCTHD) {
			tong += ct.getSL() * ct.getGia();
		}
		return tong;
	}
	
	public boolean checkMaHD(String maHD) {
		for(DTO_ChitietHD ct : listCTHD) {
			if(ct.getMaHD().equals(maHD)) {
				return false;
			}
		}
		return true; 
	}
	
	public DTO_ChitietHD getInfoCTHD(String Ma_HD) {
		for(DTO_ChitietHD ct : listCTHD) {
			if(ct.getMaHD().equals(Ma_HD)) {
				return ct;
			}
		}
		return null;
	}
	
	public boolean add(DTO_ChitietHD cthd) {
	    boolean check = cthdDAL.addCTHD(cthd);
	    if (check && checkMaHD(cthd.getMaHD())) {
	        JOptionPane.showMessageDialog(null, "Thêm thành công");
	        return true;
	    }
	    return check;
	}
	
	public boolean addHDToTable(String maHD,String maDT,int SL,int gia,boolean check_exist) {
		DTO_ChitietHD cthd = new DTO_ChitietHD(maHD, maDT, SL, gia,check_exist);
		return add(cthd);
	}

	public boolean update(String maHD, String oldMaDT, String newMaDT, int SL, int gia, boolean check_exist) {
	    boolean check = cthdDAL.updateCTHD(maHD, oldMaDT, newMaDT, SL, gia, check_exist);
	    if (check) {
	        for (DTO_ChitietHD cthd : listCTHD) {
	            if (cthd.getMaHD().equals(maHD) && cthd.getMaDT().equals(newMaDT)) {
	                cthd.setMaDT(newMaDT);
	                cthd.setSL(SL);
	                cthd.setGia(gia);
	                cthd.setCheck_exist(check_exist);
	                System.out.println(cthd);
	                break;
	            }
	        }
	        JOptionPane.showMessageDialog(null, "Update thành công");
	    } else {
	        JOptionPane.showMessageDialog(null, "Update thất bại");
	    }
	    return check;
	}



	
	public boolean delete(String maHD,String maDT) {
		boolean check = cthdDAL.deleteCTHD(maHD,maDT);
		if(check) {
			for (DTO_ChitietHD hd : listCTHD) {
				if(hd.getMaHD().equals(maHD) && hd.getMaDT().equals(maDT)) {
					JOptionPane.showMessageDialog(null, "Xóa thành công");
				}
			}
		}
		return check;
	}
	
	public boolean deleteCTHD(String maHD,String maDT) {
		boolean check = cthdDAL.deleteCTHD(maHD,maDT);
		if(check) {
			for (DTO_ChitietHD hd : listCTHD) {
				if(hd.getMaHD().equals(maHD) && hd.getMaDT().equals(maDT)) {
					cthdDAL.deleteCTHDd(maHD, maDT);
					System.out.println("ROI DO");
				}
			}
		}
		return check;
	}
	
	public ArrayList<DTO_ChitietHD> searchCTHD(String luaChon,String keyword) {
		ArrayList<DTO_ChitietHD> kq = new ArrayList<>();
		for(DTO_ChitietHD ct : listCTHD) {
			switch(luaChon) {
				case "Mã hóa đơn":
					if(ct.getMaHD().toLowerCase().contains(keyword.toLowerCase())) {
						kq.add(ct);
					}
					break;
				case "Mã điện thoại":
					if(ct.getMaDT().toLowerCase().contains(keyword.toLowerCase())) {
						kq.add(ct);
					}
					break;
				case "Số lượng":
					if(String.valueOf(ct.getSL()).toLowerCase().contains(keyword.toLowerCase())) {
						kq.add(ct);
					}
					break;
				case "Giá":
					if(String.valueOf(ct.getGia()).toLowerCase().contains(keyword.toLowerCase())) {
						kq.add(ct);
					}
					break;
			}
		}	
		return kq;
	}
	
	
	
	
}
