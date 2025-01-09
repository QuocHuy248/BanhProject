package giohangmodal;

public class GioHang {
	private Long makhachhang;
	private Long mabanh;
	private String tenbanh;
	private Long gia;
	private Long soluong;
	private String anh;

	public GioHang(Long makhachhang, Long mabanh, String tenbanh, Long gia, Long soluong, String anh) {
		super();
		this.makhachhang = makhachhang;
		this.mabanh = mabanh;
		this.tenbanh = tenbanh;
		this.gia = gia;
		this.soluong = soluong;
		this.anh = anh;
	}

	public String getAnh() {
		return anh;
	}

	public void setAnh(String anh) {
		this.anh = anh;
	}

	public GioHang() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getMakhachhang() {
		return makhachhang;
	}

	public void setMakhachhang(Long makhachhang) {
		this.makhachhang = makhachhang;
	}

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

	public Long getGia() {
		return gia;
	}

	public void setGia(Long gia) {
		this.gia = gia;
	}

	public Long getSoluong() {
		return soluong;
	}

	public void setSoluong(Long soluong) {
		this.soluong = soluong;
	}

}
