package DTO;

public class DTO_Khachhang {
	private String ma_KH,ten_KH,diaChi,SDT;
	private boolean check_exist;
	public DTO_Khachhang(String ma_KH, String ten_KH, String diaChi, String sDT, boolean check_exist) {
		super();
		this.ma_KH = ma_KH;
		this.ten_KH = ten_KH;
		this.diaChi = diaChi;
		SDT = sDT;
		this.check_exist = check_exist;
	}
	public String getMa_KH() {
		return ma_KH;
	}
	public void setMa_KH(String ma_KH) {
		this.ma_KH = ma_KH;
	}
	public String getTen_KH() {
		return ten_KH;
	}
	public void setTen_KH(String ten_KH) {
		this.ten_KH = ten_KH;
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
	public boolean isCheck_exist() {
		return check_exist;
	}
	public void setCheck_exist(boolean check_exist) {
		this.check_exist = check_exist;
	}
	@Override
	public String toString() {
		return "DTO_Khachhang [ma_KH=" + ma_KH + ", ten_KH=" + ten_KH + ", diaChi=" + diaChi + ", SDT=" + SDT
				+ ", check_exist=" + check_exist + "]";
	}

	
}
