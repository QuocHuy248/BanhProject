package chitiethoadonmodal;

public class ChiTietHoaDon {
	private String tenbanh;
	private Long soluongmua;
	private Long mahoadon;

	public String getTenBanh() {
		return tenbanh;
	}

	public void setTenBanh(String tenbanh) {
		this.tenbanh = tenbanh;
	}

	public Long getSoluongmua() {
		return soluongmua;
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

	public ChiTietHoaDon(String tenbanh, Long soluongmua, Long mahoadon) {
		super();
		this.tenbanh = tenbanh;
		this.soluongmua = soluongmua;
		this.mahoadon = mahoadon;
	}

	public ChiTietHoaDon() {
		super();
		// TODO Auto-generated constructor stub
	}

}
