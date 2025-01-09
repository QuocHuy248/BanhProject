package KhachHangModal;

public class KhachHang {
	private Long makhachhang;
	private String hoten;
	private String diachi;
	private String tendn;
	private String pass;

	public Long getMakhachhang() {
		return makhachhang;
	}

	public void setMakhachhang(Long makhachhang) {
		this.makhachhang = makhachhang;
	}

	public String getHoten() {
		return hoten;
	}

	public void setHoten(String hoten) {
		this.hoten = hoten;
	}

	public String getDiachi() {
		return diachi;
	}

	public void setDiachi(String diachi) {
		this.diachi = diachi;
	}

	public String getTendn() {
		return tendn;
	}

	public void setTendn(String tendn) {
		this.tendn = tendn;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public KhachHang(Long makhachhang, String hoten, String diachi, String tendn, String pass) {
		super();
		this.makhachhang = makhachhang;
		this.hoten = hoten;
		this.diachi = diachi;
		this.tendn = tendn;
		this.pass = pass;
	}

	public KhachHang() {
		super();
		// TODO Auto-generated constructor stub
	}

}
