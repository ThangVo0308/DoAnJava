package DTO;

public class DTO_ChitietPN {
	private String Ma_PN,Ma_DT;
	private int SL,gia;
	private boolean check_exist;
	public DTO_ChitietPN(String ma_PN, String ma_DT, int sL, int gia, boolean check_exist) {
		super();
		Ma_PN = ma_PN;
		Ma_DT = ma_DT;
		SL = sL;
		this.gia = gia;
		this.check_exist = check_exist;
	}
	public String getMa_PN() {
		return Ma_PN;
	}
	public void setMa_PN(String ma_PN) {
		Ma_PN = ma_PN;
	}
	public String getMa_DT() {
		return Ma_DT;
	}
	public void setMa_DT(String ma_DT) {
		Ma_DT = ma_DT;
	}
	public int getSL() {
		return SL;
	}
	public void setSL(int sL) {
		SL = sL;
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
		return "DTO_ChitietPN [Ma_PN=" + Ma_PN + ", Ma_DT=" + Ma_DT + ", SL=" + SL + ", gia=" + gia + ", check_exist="
				+ check_exist + "]";
	}
	
}
