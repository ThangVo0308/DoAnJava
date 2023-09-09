package DTO;

public class DTO_NhaPP {
	private String ma_NPP,ten_NPP,diaChi,SDT,email;
	private boolean check_exist;
	public DTO_NhaPP(String ma_NPP, String ten_NPP, String diaChi, String sDT, String email, boolean check_exist) {
		super();
		this.ma_NPP = ma_NPP;
		this.ten_NPP = ten_NPP;
		this.diaChi = diaChi;
		SDT = sDT;
		this.email = email;
		this.check_exist = check_exist;
	}
	public String getMa_NPP() {
		return ma_NPP;
	}
	public void setMa_NPP(String ma_NPP) {
		this.ma_NPP = ma_NPP;
	}
	public String getTen_NPP() {
		return ten_NPP;
	}
	public void setTen_NPP(String ten_NPP) {
		this.ten_NPP = ten_NPP;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public boolean isCheck_exist() {
		return check_exist;
	}
	public void setCheck_exist(boolean check_exist) {
		this.check_exist = check_exist;
	}
	@Override
	public String toString() {
		return "DTO_NhaPP [ma_NPP=" + ma_NPP + ", ten_NPP=" + ten_NPP + ", diaChi=" + diaChi + ", SDT=" + SDT
				+ ", email=" + email + ", check_exist=" + check_exist + "]";
	}
	
	
	
	
}
