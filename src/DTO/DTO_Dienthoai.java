package DTO;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class DTO_Dienthoai {
	public String ma_DT,tenLoai,maBH,tinhNang,tenDT;
	public int SL,giaTien;
	public String img;
	public boolean check_exist;
	


	public DTO_Dienthoai(String ma_DT, String tenLoai, String maBH, String tinhNang, String tenDT, int sL, int giaTien,
			String img, boolean check_exist) {
		super();
		this.ma_DT = ma_DT;
		this.tenLoai = tenLoai;
		this.maBH = maBH;
		this.tinhNang = tinhNang;
		this.tenDT = tenDT;
		SL = sL;
		this.giaTien = giaTien;
		this.img = img;
		this.check_exist = check_exist;
	}



	@Override
	public String toString() {
		return "DTO_Dienthoai [ma_DT=" + ma_DT + ", tenLoai=" + tenLoai + ", maBH=" + maBH + ", tinhNang=" + tinhNang
				+ ", tenDT=" + tenDT + ", SL=" + SL + ", giaTien=" + giaTien + ", img=" + img + ", check_exist="
				+ check_exist + "]";
	}



	public String getMa_DT() {
		return ma_DT;
	}



	public void setMa_DT(String ma_DT) {
		this.ma_DT = ma_DT;
	}



	public String getTenLoai() {
		return tenLoai;
	}



	public void setTenLoai(String tenLoai) {
		this.tenLoai = tenLoai;
	}



	public String getMaBH() {
		return maBH;
	}



	public void setMaBH(String maBH) {
		this.maBH = maBH;
	}



	public String getTinhNang() {
		return tinhNang;
	}



	public void setTinhNang(String tinhNang) {
		this.tinhNang = tinhNang;
	}



	public String getTenDT() {
		return tenDT;
	}



	public void setTenDT(String tenDT) {
		this.tenDT = tenDT;
	}



	public int getSL() {
		return SL;
	}



	public void setSL(int sL) {
		SL = sL;
	}



	public int getGiaTien() {
		return giaTien;
	}



	public void setGiaTien(int giaTien) {
		this.giaTien = giaTien;
	}



	public String getImg() {
		return img;
	}



	public void setImg(String img) {
		this.img = img;
	}



	public boolean isCheck_exist() {
		return check_exist;
	}



	public void setCheck_exist(boolean check_exist) {
		this.check_exist = check_exist;
	}



	public String getGiaTienFormatted() {
		DecimalFormat formatter = new DecimalFormat("###,###,###.##");
	    return formatter.format(this.giaTien)+" VNĐ";
	}
}
