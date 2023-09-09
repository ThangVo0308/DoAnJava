package DTO;

import java.sql.Date;

public class DTO_Taikhoan {
	private int So_TK;
	private String ten_TK,Mat_khau,SDT;
	private Date ngayTao;
	private boolean check_exist;
	public DTO_Taikhoan(int so_TK, String ten_TK, String mat_khau, String sDT, java.util.Date date, boolean check_exist) {
		super();
		So_TK = so_TK;
		this.ten_TK = ten_TK;
		Mat_khau = mat_khau;
		SDT = sDT;
		this.ngayTao = (Date) date;
		this.check_exist = check_exist;
	}
	public int getSo_TK() {
		return So_TK;
	}
	public void setSo_TK(int so_TK) {
		So_TK = so_TK;
	}
	public String getTen_TK() {
		return ten_TK;
	}
	public void setTen_TK(String ten_TK) {
		this.ten_TK = ten_TK;
	}
	public String getMat_khau() {
		return Mat_khau;
	}
	public void setMat_khau(String mat_khau) {
		Mat_khau = mat_khau;
	}
	public String getSDT() {
		return SDT;
	}
	public void setSDT(String sDT) {
		SDT = sDT;
	}
	public Date getNgayTao() {
		return ngayTao;
	}
	public void setNgayTao(Date ngayTao) {
		this.ngayTao = ngayTao;
	}
	public boolean isCheck_exist() {
		return check_exist;
	}
	public void setCheck_exist(boolean check_exist) {
		this.check_exist = check_exist;
	}
	@Override
	public String toString() {
		return "DTO_Taikhoan [So_TK=" + So_TK + ", ten_TK=" + ten_TK + ", Mat_khau=" + Mat_khau + ", SDT=" + SDT
				+ ", ngayTao=" + ngayTao + ", check_exist=" + check_exist + "]";
	}
	
	
}
