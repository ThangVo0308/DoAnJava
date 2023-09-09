package DTO;

public class DTO_Chucvu {
	private String ma_CV,ten_CV,moTa;
	private boolean check_exist;
	public DTO_Chucvu(String ma_CV, String ten_CV, String moTa, boolean check_exist) {
		super();
		this.ma_CV = ma_CV;
		this.ten_CV = ten_CV;
		this.moTa = moTa;
		this.check_exist = check_exist;
	}
	public String getMa_CV() {
		return ma_CV;
	}
	public void setMa_CV(String ma_CV) {
		this.ma_CV = ma_CV;
	}
	public String getTen_CV() {
		return ten_CV;
	}
	public void setTen_CV(String ten_CV) {
		this.ten_CV = ten_CV;
	}
	public String getMoTa() {
		return moTa;
	}
	public void setMoTa(String moTa) {
		this.moTa = moTa;
	}
	public boolean isCheck_exist() {
		return check_exist;
	}
	public void setCheck_exist(boolean check_exist) {
		this.check_exist = check_exist;
	}
	@Override
	public String toString() {
		return "DTO_Chucvu [ma_CV=" + ma_CV + ", ten_CV=" + ten_CV + ", moTa=" + moTa + ", check_exist=" + check_exist
				+ "]";
	}

	
}
