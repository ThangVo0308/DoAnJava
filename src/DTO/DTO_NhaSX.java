package DTO;

public class DTO_NhaSX {
	private String ma_NSX,ten_NSX,diaChi,SDT,email;
	private boolean check_exist;
	public DTO_NhaSX(String ma_NSX, String ten_NSX, String diaChi, String sDT, String email, boolean check_exist) {
		super();
		this.ma_NSX = ma_NSX;
		this.ten_NSX = ten_NSX;
		this.diaChi = diaChi;
		SDT = sDT;
		this.email = email;
		this.check_exist = check_exist;
	}
	public String getMa_NSX() {
		return ma_NSX;
	}
	public void setMa_NSX(String ma_NSX) {
		this.ma_NSX = ma_NSX;
	}
	public String getTen_NSX() {
		return ten_NSX;
	}
	public void setTen_NSX(String ten_NSX) {
		this.ten_NSX = ten_NSX;
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
		return "DTO_NhaSX [ma_NSX=" + ma_NSX + ", ten_NSX=" + ten_NSX + ", diaChi=" + diaChi + ", SDT=" + SDT
				+ ", email=" + email + ", check_exist=" + check_exist + "]";
	}

	
	
}
