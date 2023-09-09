package DTO;

import java.sql.Date;

public class DTO_Hoadon {
	private String ma_HD;
	private java.sql.Date ngayLap_HD;
	@Override
	public String toString() {
		return "DTO_Hoadon [ma_HD=" + ma_HD + ", ngayLap_HD=" + ngayLap_HD + ", tongTien=" + tongTien + ", Ma_KH="
				+ Ma_KH + ", Ma_NV=" + Ma_NV + ", check_exist=" + check_exist + "]";
	}
	public DTO_Hoadon(String ma_HD, Date ngayLap_HD, int tongTien, String ma_KH, String ma_NV, boolean check_exist) {
		super();
		this.ma_HD = ma_HD;
		this.ngayLap_HD = ngayLap_HD;
		this.tongTien = tongTien;
		Ma_KH = ma_KH;
		Ma_NV = ma_NV;
		this.check_exist = check_exist;
	}
	public String getMa_HD() {
		return ma_HD;
	}
	public void setMa_HD(String ma_HD) {
		this.ma_HD = ma_HD;
	}
	public java.sql.Date getNgayLap_HD() {
		return ngayLap_HD;
	}
	public void setNgayLap_HD(java.sql.Date ngayLap_HD) {
		this.ngayLap_HD = ngayLap_HD;
	}
	public int getTongTien() {
		return tongTien;
	}
	public void setTongTien(int tongTien) {
		this.tongTien = tongTien;
	}
	public String getMa_KH() {
		return Ma_KH;
	}
	public void setMa_KH(String ma_KH) {
		Ma_KH = ma_KH;
	}
	public String getMa_NV() {
		return Ma_NV;
	}
	public void setMa_NV(String ma_NV) {
		Ma_NV = ma_NV;
	}
	public boolean isCheck_exist() {
		return check_exist;
	}
	public void setCheck_exist(boolean check_exist) {
		this.check_exist = check_exist;
	}
	private int tongTien;
	private String Ma_KH,Ma_NV;
	private boolean check_exist;
	
	
}
