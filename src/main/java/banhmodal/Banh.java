package banhmodal;

public class Banh {
	private Long mabanh;
	private String tenbanh;
	private String anh;
	private Long soluong;
	private Long gia;
	private String tenloai;

	public Long getMabanh() {
		return mabanh;
	}

	public void setMabanh(Long mabanh) {
		this.mabanh = mabanh;
	}

	public String getTenbanh() {
		return tenbanh;
	}

	public void setTenbanh(String tenbanh) {
		this.tenbanh = tenbanh;
	}

	public String getAnh() {
		return anh;
	}

	public void setAnh(String anh) {
		this.anh = anh;
	}

	public Long getSoluong() {
		return soluong;
	}

	public Banh(Long mabanh, String tenbanh, String anh, Long soluong, Long gia, String tenloai) {
		super();
		this.mabanh = mabanh;
		this.tenbanh = tenbanh;
		this.anh = anh;
		this.soluong = soluong;
		this.gia = gia;
		this.tenloai = tenloai;
	}

	public Banh() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void setSoluong(Long soluong) {
		this.soluong = soluong;
	}

	public Long getGia() {
		return gia;
	}

	public void setGia(Long gia) {
		this.gia = gia;
	}

	public String getTenloai() {
		return tenloai;
	}

	public void setTenloai(String tenloai) {
		this.tenloai = tenloai;
	}

}
