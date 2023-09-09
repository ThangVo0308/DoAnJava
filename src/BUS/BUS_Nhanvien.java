package BUS;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import DAL.DAL_Nhanvien;
import DAL.DB_Connect;
import DTO.DTO_Nhanvien;

public class BUS_Nhanvien {
	ArrayList<DTO_Nhanvien> listNV = new ArrayList<>();
	DAL_Nhanvien dalNV = new DAL_Nhanvien();
	
	public BUS_Nhanvien() {
		listNV = dalNV.readDB();
	}
	
	public ArrayList<DTO_Nhanvien> getListNV() {
		return listNV;
	}
	
	public DTO_Nhanvien getNV(String maNV) {
		for(DTO_Nhanvien nv: listNV) {
			if(nv.getMaNV().equals(maNV)) {
				return nv;
			}
		}
		return null;
	}
	
    public String getMaNVNext() {
    	ArrayList<DTO_Nhanvien> list = dalNV.readDB();
    	int max = 0;
    	for (DTO_Nhanvien dt : list) {
    		String maNV = dt.getMaNV();
    		if(maNV.length() >= 4) {
    			int currentMaNV = Integer.parseInt(maNV.substring(2));
    			if(currentMaNV > max) {
    				max = currentMaNV;
    			}
    		}
		}
    	return String.format("NV%02d", max + 1);
    }
	
	public boolean checkMaNV(String maNV) {
		for (DTO_Nhanvien nv : listNV) {
			if(nv.getMaNV().equals(maNV)) {
				return false;
			}
		}
		return true;
	}
	
	public boolean add(DTO_Nhanvien nv) {
		boolean check = dalNV.addNV(nv);
	
		if(check && checkMaNV(nv.getMaNV())) {
			listNV.add(nv);
			JOptionPane.showMessageDialog(null, "Thêm thành công");
		}
		return check;
	}
	
	public boolean addnvToTable(String maNV, String tenNV, String maCV, String diaChi, String sDT, boolean gioiTinh,
			java.sql.Date ngaySinh, String soCMND, boolean check_exist) {
		DTO_Nhanvien nv = new DTO_Nhanvien(maNV, tenNV, maCV, diaChi, sDT, gioiTinh, ngaySinh, soCMND, check_exist);
		
		return add(nv);
	}
	
	
	public boolean update(String maNV, String tenNV, String maCV, String diaChi, String sDT, boolean gioiTinh,
			java.sql.Date ngaySinh, String soCMND, boolean check_exist) {
		boolean check = dalNV.updateNV(maNV, tenNV, maCV, diaChi, sDT, gioiTinh, ngaySinh, soCMND, check_exist);
		
		if(check) {
			for (DTO_Nhanvien nv : listNV) {
				if(nv.getMaNV().equals(maNV)) {
					nv.setTenNV(tenNV);
                    nv.setMaCV(maCV);
                    nv.setDiaChi(diaChi);
                    nv.setSDT(sDT);
                    nv.setGioiTinh(gioiTinh);
                    nv.setNgaySinh(ngaySinh);
                    nv.setSoCMND(soCMND);
					nv.setCheck_exist(check_exist);
				}
			}
			JOptionPane.showMessageDialog(null, "Update thành công");
		}else {
			JOptionPane.showMessageDialog(null, "Update thất bại");
		}
		return check;
	}
	
	@SuppressWarnings("unlikely-arg-type")
	public boolean delete(String maNV) {
		boolean check = dalNV.deleteNV(maNV);
		if(check) {
			for (DTO_Nhanvien nv : listNV) {
				if(nv.getMaNV().equals(maNV)) {
					System.out.println("OK LA");
//					listNV.remove(maNV);
					JOptionPane.showMessageDialog(null, "Xóa thành công");
				}
			}
		}
		return check;
	}

	
	public ArrayList<DTO_Nhanvien> searchNhanVien(String gioiTinh, String maCV) {
	    ArrayList<DTO_Nhanvien> listNVSearch = new ArrayList<>();
	    DAL_Nhanvien dalNV = new DAL_Nhanvien();

	    try {
	        listNVSearch = dalNV.searchNV(gioiTinh, maCV);
	    } catch (Exception e) {
	        // Xử lý ngoại lệ nếu có
	        e.printStackTrace();
	    }
	    return listNVSearch;
	}
}
