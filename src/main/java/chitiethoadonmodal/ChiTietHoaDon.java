package chitiethoadonmodal;

public class ChiTietHoaDon {
	private String tenbanh;
	private Long soluongmua;
	private Long mahoadon;
	private String anh;
	private Long gia;

	public String getTenBanh() {
		return tenbanh;
	}

	public void setTenBanh(String tenbanh) {
		this.tenbanh = tenbanh;
	}

	public Long getSoluongmua() {
		return soluongmua;
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

	public void setSoluongmua(Long soluongmua) {
		this.soluongmua = soluongmua;
	}

	public Long getMahoadon() {
		return mahoadon;
	}

	public void setMahoadon(Long mahoadon) {
		this.mahoadon = mahoadon;
	}

	public ChiTietHoaDon(String tenbanh, Long soluongmua, Long mahoadon, String anh, Long gia) {
		super();
		this.tenbanh = tenbanh;
		this.soluongmua = soluongmua;
		this.mahoadon = mahoadon;
		this.anh = anh;
		this.gia = gia;
	}

	public Long getGia() {
		return gia;
	}

	public void setGia(Long gia) {
		this.gia = gia;
	}

	public ChiTietHoaDon() {
		super();
		// TODO Auto-generated constructor stub
	}

}
