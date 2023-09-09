package DTO;

import java.sql.Date;

public class DTO_Nhanvien {
	private String maNV,tenNV,maCV,diaChi,SDT;
	private boolean gioiTinh;
	private java.sql.Date ngaySinh;
	private String soCMND;
	private boolean check_exist;
	public DTO_Nhanvien(String maNV, String tenNV, String maCV, String diaChi, String sDT, boolean gioiTinh,
			java.sql.Date ngaySinh, String soCMND, boolean check_exist) {
		super();
		this.maNV = maNV;
		this.tenNV = tenNV;
		this.maCV = maCV;
		this.diaChi = diaChi;
		SDT = sDT;
		this.gioiTinh = gioiTinh;
		this.ngaySinh = ngaySinh;
		this.soCMND = soCMND;
		this.check_exist = check_exist;
	}
	public String getMaNV() {
		return maNV;
	}
	public void setMaNV(String maNV) {
		this.maNV = maNV;
	}
	public String getTenNV() {
		return tenNV;
	}
	public void setTenNV(String tenNV) {
		this.tenNV = tenNV;
	}
	public String getMaCV() {
		return maCV;
	}
	public void setMaCV(String maCV) {
		this.maCV = maCV;
	}
	public String getDiaChi() {
		return diaChi;
	}
	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}
	public String getSDT() {
		return SDT;
	}
	public void setSDT(String sDT) {
		SDT = sDT;
	}
	public boolean isGioiTinh() {
		return gioiTinh;
	}
	public void setGioiTinh(boolean gioiTinh) {
		this.gioiTinh = gioiTinh;
	}
	public java.sql.Date getNgaySinh() {
		return ngaySinh;
	}
	public void setNgaySinh(java.sql.Date ngaySinh) {
		this.ngaySinh = ngaySinh;
	}
	public String getSoCMND() {
		return soCMND;
	}
	public void setSoCMND(String soCMND) {
		this.soCMND = soCMND;
	}
	public boolean isCheck_exist() {
		return check_exist;
	}
	public void setCheck_exist(boolean check_exist) {
		this.check_exist = check_exist;
	}
	@Override
	public String toString() {
		return "DTO_Nhanvien [maNV=" + maNV + ", tenNV=" + tenNV + ", maCV=" + maCV + ", diaChi=" + diaChi + ", SDT="
				+ SDT + ", gioiTinh=" + gioiTinh + ", ngaySinh=" + ngaySinh + ", soCMND=" + soCMND + ", check_exist="
				+ check_exist + "]";
	}
	
	
	
	
	
	
}
