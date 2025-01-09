package lichsumodal;

import java.util.Date;

public class LichSu {
	private String tenbanh;
	private Long soluongmua;
	private Long gia;
	private Long thanhtien;
	private Date ngaymua;
	private boolean damua;
	private Long makhachhang;

	public String getTenbanh() {
		return tenbanh;
	}

	public void setTenbanh(String tenbanh) {
		this.tenbanh = tenbanh;
	}

	public Long getSoluongmua() {
		return soluongmua;
	}

	public void setSoluongmua(Long soluongmua) {
		this.soluongmua = soluongmua;
	}

	public Long getGia() {
		return gia;
	}

	public void setGia(Long gia) {
		this.gia = gia;
	}

	public Long getThanhtien() {
		return thanhtien;
	}

	public void setThanhtien(Long thanhtien) {
		this.thanhtien = thanhtien;
	}

	public Date getNgaymua() {
		return ngaymua;
	}

	public void setNgaymua(Date ngaymua) {
		this.ngaymua = ngaymua;
	}

	public Long getMakhachhang() {
		return makhachhang;
	}

	public boolean isDamua() {
		return damua;
	}

	public void setDamua(boolean damua) {
		this.damua = damua;
	}

	public LichSu(String tenbanh, Long soluongmua, Long gia, Long thanhtien, Date ngaymua, boolean damua,
			Long makhachhang) {
		super();
		this.tenbanh = tenbanh;
		this.soluongmua = soluongmua;
		this.gia = gia;
		this.thanhtien = thanhtien;
		this.ngaymua = ngaymua;
		this.damua = damua;
		this.makhachhang = makhachhang;
	}

	public void setMakhachhang(Long makhachhang) {
		this.makhachhang = makhachhang;
	}

	public LichSu() {
		super();
		// TODO Auto-generated constructor stub
	}

}
