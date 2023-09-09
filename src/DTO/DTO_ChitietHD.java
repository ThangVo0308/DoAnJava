package DTO;

public class DTO_ChitietHD {
	private String maHD,maDT;
	private int SL,gia;
	private boolean check_exist;
	public DTO_ChitietHD(String maHD, String maDT, int sL, int gia, boolean check_exist) {
		super();
		this.maHD = maHD;
		this.maDT = maDT;
		SL = sL;
		this.gia = gia;
		this.check_exist = check_exist;
	}
	public DTO_ChitietHD() {
		// TODO Auto-generated constructor stub
	}
	public String getMaHD() {
		return maHD;
	}
	public void setMaHD(String maHD) {
		this.maHD = maHD;
	}
	public String getMaDT() {
		return maDT;
	}
	public void setMaDT(String maDT) {
		this.maDT = maDT;
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
		return "DTO_ChitietHD [maHD=" + maHD + ", maDT=" + maDT + ", SL=" + SL + ", gia=" + gia + ", check_exist="
				+ check_exist + "]";
	}
	
	
}
