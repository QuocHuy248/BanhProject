package LoaiModal;

public class Loai {
	private Long maloai;
	private String tenloai;

	public Long getMaloai() {
		return maloai;
	}

	public void setMaloai(Long maloai) {
		this.maloai = maloai;
	}

	public String getTenloai() {
		return tenloai;
	}

	public void setTenloai(String tenloai) {
		this.tenloai = tenloai;
	}

	public Loai(Long maloai, String tenloai) {
		super();
		this.maloai = maloai;
		this.tenloai = tenloai;
	}

	public Loai() {
		super();
		// TODO Auto-generated constructor stub
	}

}
