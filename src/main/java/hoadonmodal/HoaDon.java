package hoadonmodal;

import java.sql.Date;

public class HoaDon {
	private Long mahoadon;
	private Long makhachhang;
	private Date ngaymua;
	private boolean damua;

	public Long getMakhachhang() {
		return makhachhang;
	}

	public void setMakhachhang(Long makhachhang) {
		this.makhachhang = makhachhang;
	}

	public Date getNgaymua() {
		return ngaymua;
	}

	public void setNgaymua(Date ngaymua) {
		this.ngaymua = ngaymua;
	}

	public boolean isDamua() {
		return damua;
	}

	public void setDamua(boolean damua) {
		this.damua = damua;
	}

	public HoaDon(Long mahoadon, Long makhachhang, Date ngaymua, boolean damua) {
		super();
		this.mahoadon = mahoadon;
		this.makhachhang = makhachhang;
		this.ngaymua = ngaymua;
		this.damua = damua;
	}

	public HoaDon() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getMahoadon() {
		return mahoadon;
	}

	public void setMahoadon(Long mahoadon) {
		this.mahoadon = mahoadon;
	}

	
}
