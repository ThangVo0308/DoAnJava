package DTO;

import java.util.Date;

public class DTO_Phieunhap {
	private String ma_PN;
	private Date ngayNhap;
	private int tongGia;
	private String ma_NPP;
	private boolean check_exist;
	public DTO_Phieunhap(String ma_PN, Date ngayNhap, int tongGia, String ma_NPP, boolean check_exist) {
		super();
		this.ma_PN = ma_PN;
		this.ngayNhap = ngayNhap;
		this.tongGia = tongGia;
		this.ma_NPP = ma_NPP;
		this.check_exist = check_exist;
	}
	public String getMa_PN() {
		return ma_PN;
	}
	public void setMa_PN(String ma_PN) {
		this.ma_PN = ma_PN;
	}
	public Date getNgayNhap() {
		return ngayNhap;
	}
	public void setNgayNhap(Date ngayNhap) {
		this.ngayNhap = ngayNhap;
	}
	public int getTongGia() {
		return tongGia;
	}
	public void setTongGia(int tongGia) {
		this.tongGia = tongGia;
	}
	public String getMa_NPP() {
		return ma_NPP;
	}
	public void setMa_NPP(String ma_NPP) {
		this.ma_NPP = ma_NPP;
	}
	public boolean isCheck_exist() {
		return check_exist;
	}
	public void setCheck_exist(boolean check_exist) {
		this.check_exist = check_exist;
	}
	@Override
	public String toString() {
		return "DTO_Phieunhap [ma_PN=" + ma_PN + ", ngayNhap=" + ngayNhap + ", tongGia=" + tongGia + ", ma_NPP="
				+ ma_NPP + ", check_exist=" + check_exist + "]";
	}
	
	
}
