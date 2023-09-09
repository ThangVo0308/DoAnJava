package DTO;

import java.util.Date;

public class DTO_PhieuChi {
	private String MaPC,MaPN,MaNV;
	private Date ngayChi;
	private int gia;
	private boolean check_exist;
	public DTO_PhieuChi(String maPC, String maPN, String maNV, Date ngayChi, int gia, boolean check_exist) {
		super();
		MaPC = maPC;
		MaPN = maPN;
		MaNV = maNV;
		this.ngayChi = ngayChi;
		this.gia = gia;
		this.check_exist = check_exist;
	}
	public String getMaPC() {
		return MaPC;
	}
	public void setMaPC(String maPC) {
		MaPC = maPC;
	}
	public String getMaPN() {
		return MaPN;
	}
	public void setMaPN(String maPN) {
		MaPN = maPN;
	}
	public String getMaNV() {
		return MaNV;
	}
	public void setMaNV(String maNV) {
		MaNV = maNV;
	}
	public Date getNgayChi() {
		return ngayChi;
	}
	public void setNgayChi(Date ngayChi) {
		this.ngayChi = ngayChi;
	}
	public int getGia() {
		return gia;
	}
	public void setGia(int gia) {
		this.gia = gia;
	}
	public boolean isCheck_exist() {
		return check_exist;
	}
	public void setCheck_exist(boolean check_exist) {
		this.check_exist = check_exist;
	}
	@Override
	public String toString() {
		return "DTO_PhieuChi [MaPC=" + MaPC + ", MaPN=" + MaPN + ", MaNV=" + MaNV + ", ngayChi=" + ngayChi + ", gia="
				+ gia + ", check_exist=" + check_exist + "]";
	}
	
}
