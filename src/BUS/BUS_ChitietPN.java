package BUS;

import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import DAL.DAL_ChitietPN;
import DAL.DAL_Dienthoai;
import DAL.DAL_Phieunhap;
import DTO.DTO_ChitietHD;
import DTO.DTO_ChitietPN;

// can nhac xoa
public class BUS_ChitietPN {
	ArrayList<DTO_ChitietPN> listCTPN = new ArrayList<>();
	private DAL_ChitietPN ctpnDAL = new DAL_ChitietPN();
	private DAL_Phieunhap pnDAL = new DAL_Phieunhap();
	private DAL_Dienthoai dtDAL = new DAL_Dienthoai();
	
	public BUS_ChitietPN() {
		listCTPN = ctpnDAL.readDB();
	}
	
	public void readDB() {
		listCTPN = ctpnDAL.readDB();
	}
	
	public ArrayList<DTO_ChitietPN> getListCTPN() {
		return listCTPN;
	}
	
	public void setListCTPN(ArrayList<DTO_ChitietPN> listCTPN) {
		this.listCTPN = listCTPN;
	}

	public DAL_ChitietPN getCtpnDAL() {
		return ctpnDAL;
	}
	
	public void setCtpnDAL(DAL_ChitietPN ctpnDAL) {
		this.ctpnDAL = ctpnDAL;
	}
	
	public DAL_Phieunhap getPnDAL() {
		return pnDAL;
	}
	
	public void setPnDAL(DAL_Phieunhap pnDAL) {
		this.pnDAL = pnDAL;
	}
	
	public DAL_Dienthoai getDtDAL() {
		return dtDAL;
	}
	
	public void setDtDAL(DAL_Dienthoai dtDAL) {
		this.dtDAL = dtDAL;
	}
	
	public boolean checkMaPN(String maPN) {
		for(DTO_ChitietPN ct : listCTPN) {
			if(ct.getMa_PN().equals(maPN)) {
				return false;
			}
		}
		return true; 
	}

	public DTO_ChitietPN getInfoCTPN(String Ma_PN) {
		for(DTO_ChitietPN ct : listCTPN) {
			if(ct.getMa_PN().equals(Ma_PN)) {
				return ct;
			}
		}
		return null;
	}
	
	public boolean add(DTO_ChitietPN ctpn) {
	    boolean check = ctpnDAL.addCTPN(ctpn);
	    if (check && checkMaPN(ctpn.getMa_PN())) {
	        JOptionPane.showMessageDialog(null, "Thêm thành công");
	        return true;
	    }
	    return check;
	}
	
	public boolean addPNToTable(String maPN,String maDT,int SL,int gia,boolean check_exist) {
		DTO_ChitietPN cthd = new DTO_ChitietPN(maPN, maDT, SL, gia,check_exist);
		return add(cthd);
	}

	public boolean update(String maPN, String oldMaDT, String newMaDT, int SL, int gia, boolean check_exist) {
	    boolean check = ctpnDAL.updateCTPN(maPN, oldMaDT, newMaDT, SL, gia, check_exist);
	    if (check) {
	        for (DTO_ChitietPN cthd : listCTPN) {
	            if (cthd.getMa_PN().equals(maPN) && cthd.getMa_PN().equals(newMaDT)) {
	                cthd.setMa_DT(newMaDT);
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



	
	public boolean delete(String maPN,String maDT) {
		boolean check = ctpnDAL.deleteCTPN(maPN,maDT);
		if(check) {
			for (DTO_ChitietPN hd : listCTPN) {
				if(hd.getMa_PN().equals(maPN) && hd.getMa_DT().equals(maDT)) {
					JOptionPane.showMessageDialog(null, "Xóa thành công");
				}
			}
		}
		return check;
	}
	
	public boolean deleteCTPN(String maPN,String maDT) {
		boolean check = ctpnDAL.deleteCTPN(maPN,maDT);
		if(check) {
			for (DTO_ChitietPN hd : listCTPN) {
				if(hd.getMa_PN().equals(maPN) && hd.getMa_DT().equals(maDT)) {
					ctpnDAL.deleteCTPNN(maPN, maDT);
					JOptionPane.showMessageDialog(null, "Xóa thành công");
				}
			}
		}
		return check;
	}
	
	
}
