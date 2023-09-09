package DTO;

import java.util.Date;

public class DTO_PhieuBH {
	private String ma_BH,ten_BH,diaChi;
	private Date ngay_banHang;
	private String TG_baoHanh;
	private Date ngay_Het_Han;
	private boolean check_exist;
	public DTO_PhieuBH(String ma_BH, String ten_BH, String diaChi, Date ngay_banHang, String tG_baoHanh,
			Date ngay_Het_Han, boolean check_exist) {
		super();
		this.ma_BH = ma_BH;
		this.ten_BH = ten_BH;
		this.diaChi = diaChi;
		this.ngay_banHang = ngay_banHang;
		TG_baoHanh = tG_baoHanh;
		this.ngay_Het_Han = ngay_Het_Han;
		this.check_exist = check_exist;
	}
	public String getMa_BH() {
		return ma_BH;
	}
	public void setMa_BH(String ma_BH) {
		this.ma_BH = ma_BH;
	}
	public String getTen_BH() {
		return ten_BH;
	}
	public void setTen_BH(String ten_BH) {
		this.ten_BH = ten_BH;
	}
	public String getDiaChi() {
		return diaChi;
	}
	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}
	public Date getNgay_banHang() {
		return ngay_banHang;
	}
	public void setNgay_banHang(Date ngay_banHang) {
		this.ngay_banHang = ngay_banHang;
	}
	public String getTG_baoHanh() {
		return TG_baoHanh;
	}
	public void setTG_baoHanh(String tG_baoHanh) {
		TG_baoHanh = tG_baoHanh;
	}
	public Date getNgay_Het_Han() {
		return ngay_Het_Han;
	}
	public void setNgay_Het_Han(Date ngay_Het_Han) {
		this.ngay_Het_Han = ngay_Het_Han;
	}
	public boolean isCheck_exist() {
		return check_exist;
	}
	public void setCheck_exist(boolean check_exist) {
		this.check_exist = check_exist;
	}
	@Override
	public String toString() {
		return "DTO_PhieuBH [ma_BH=" + ma_BH + ", ten_BH=" + ten_BH + ", diaChi=" + diaChi + ", ngay_banHang="
				+ ngay_banHang + ", TG_baoHanh=" + TG_baoHanh + ", ngay_Het_Han=" + ngay_Het_Han + ", check_exist="
				+ check_exist + "]";
	}		
}
