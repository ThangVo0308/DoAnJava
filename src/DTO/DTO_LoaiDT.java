package DTO;


public class DTO_LoaiDT {
	private String maLoai,tenLoai,moTa;
	private boolean checkExist;
	
	public DTO_LoaiDT(String maLoai, String tenLoai, String moTa, boolean checkExist) {
		super();
		this.maLoai = maLoai;
		this.tenLoai = tenLoai;
		this.moTa = moTa;
		this.checkExist = checkExist;
	}
	
	public DTO_LoaiDT() {
		
	}

	public String getMaLoai() {
		return maLoai;
	}

	public void setMaLoai(String maLoai) {
		this.maLoai = maLoai;
	}

	public String getTenLoai() {
		return tenLoai;
	}

	public void setTenLoai(String tenLoai) {
		this.tenLoai = tenLoai;
	}

	public String getMoTa() {
		return moTa;
	}

	public void setMoTa(String moTa) {
		this.moTa = moTa;
	}

	public boolean isCheckExist() {
		return checkExist;
	}

	public void setCheckExist(boolean checkExist) {
		this.checkExist = checkExist;
	}

	@Override
	public String toString() {
		return "DTO_LoaiDT [maLoai=" + maLoai + ", tenLoai=" + tenLoai + ", moTa=" + moTa + ", checkExist=" + checkExist
				+ "]";
	}
}
